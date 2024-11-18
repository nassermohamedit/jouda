package nassermohamedit.jouda.doclet;


import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

import com.sun.source.util.DocTrees;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;
import nassermohamedit.jouda.model.Component;
import nassermohamedit.jouda.model.Documentation;
import nassermohamedit.jouda.model.builders.ClassComponentBuilder;
import nassermohamedit.jouda.model.builders.EnumComponentBuilder;
import nassermohamedit.jouda.model.builders.InterfaceComponentBuilder;
import nassermohamedit.jouda.model.builders.PackageComponentBuilder;
import nassermohamedit.jouda.model.builders.RecordComponentBuilder;

public class JoudaDoclet implements Doclet {

    private DocletEnvironment env;

    private DocTrees docTrees;

    private Reporter reporter;

    private PrintWriter stdout;

    private Configuration config;

    @Override
    public String getName() {
        return "JoudaDoclet";
    }

    @Override
    public Set<? extends Doclet.Option> getSupportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

    @Override
    public void init(Locale local, Reporter reporter) {
        this.reporter = reporter;
        this.stdout = reporter.getStandardWriter();
        config = new Configuration(this, reporter);
    }

    @Override
    public boolean run(DocletEnvironment env) {
        this.env = env;
        config.initConfiguration(env);
        Iterator<? extends Element> elements = env.getIncludedElements().iterator();
        while (elements.hasNext()) {
            Element e = elements.next();
            Component c = switch (e.getKind()) {
                case ElementKind.CLASS -> {
                    ClassComponentBuilder builder = new ClassComponentBuilder((TypeElement) e, config);
                    yield builder.build();
                }
                case ElementKind.PACKAGE -> {
                    PackageComponentBuilder  builder = new PackageComponentBuilder((PackageElement) e, config);
                    yield builder.build();
                }
                case ElementKind.RECORD -> {
                    RecordComponentBuilder  builder = new RecordComponentBuilder((TypeElement) e, config);
                    yield builder.build();
                }
                case ElementKind.INTERFACE -> {
                    InterfaceComponentBuilder  builder = new InterfaceComponentBuilder((TypeElement) e, config);
                    yield builder.build();
                }
                case ElementKind.ENUM -> {
                    EnumComponentBuilder builder = new EnumComponentBuilder((TypeElement) e, config);
                    yield builder.build();
                }
                default -> null;
            };
            try {
                
                generateXmlDoc(new Documentation(c), e.getSimpleName().toString() + ".xml");
            } catch (JAXBException e1) {
                e1.printStackTrace();
                return false;
            }
        }

        return true;
    }

    private static void generateXmlDoc(Documentation doc, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Documentation.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", true);
        marshaller.marshal(doc, new File("/home/nasser/doc/" + filename));
    }

}

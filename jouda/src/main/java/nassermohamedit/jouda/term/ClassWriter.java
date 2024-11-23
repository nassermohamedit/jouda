package nassermohamedit.jouda.term;


import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import nassermohamedit.jouda.model.ClassComponent;
import nassermohamedit.jouda.model.Documentation;
import nassermohamedit.jouda.model.Modifier;
import nassermohamedit.jouda.model.Name;
import nassermohamedit.jouda.model.TypeParameter;


public class ClassWriter {

    private final ClassComponent clazz;

    public ClassWriter(Documentation doc) {
        clazz = (ClassComponent) doc.getTopLevel();
    }

    public void write(Writer w) throws IOException {}

    public void write() throws IOException {
        clear();
        writeModuleInfo();
        writePackageInfo();
        writeClassInfo();
        writeTypeParameterInfo();
        writeSignatureInfo();
        //writeDescription();
        //writeFieldSummary();
        //writeConstructorSummary();
        //writeMethodSummary();
        //writeFieldDetails();
        //writeConstructorDetails();
        //writeMethodDetails();
    }

    private void writeModuleInfo() {
        println("\033[1mModule: \033[0m" + clazz.getModule());
    }

    private void writePackageInfo() {
        println("\033[1mPackage: \033[0m" + clazz.getPackage());
    }

    private void writeClassInfo() {
        println("\033[1mClass: \033[0m " + clazz.getName());
    }

    private void writeTypeParameterInfo() {
        List<TypeParameter> tps = clazz.getTypeParameters();
        if (tps == null) return;
        Iterator<TypeParameter> params = tps.iterator();
        println("\033[1mType Parameters:\033[0m");
        while (params.hasNext()) {
            var p = params.next();
            println("\033[1m" + p + "\033[0m - ");
        }
    }

    private void writeSignatureInfo() {
        var mods = clazz.getModifiers();
        String modifiers = "", sup = "", interfaces = "";
        if (mods != null) {
            modifiers = mods.getModifiers()
                .stream()
                .map(Modifier::toString)
                .collect(Collectors.joining(" "));
        }
        sup = clazz.getSupperClass().getSimpleName();
        List<Name> inters_ = clazz.getInterfaces();
        if (inters_ != null) {
            interfaces = inters_
                .stream()
                .map(Name::getSimpleName)
                .collect(Collectors.joining(","));
        }
        println("------------------------------------------------------");
        println(modifiers.toLowerCase() + " class \033[1m" + clazz.getName() + "\033[0m");
        if (!sup.equals("Object")) {
            println("extends \033[3m" + sup + "\033[0m");
        }
        if (!interfaces.isEmpty()) {
            println("implements " + interfaces);
        }
        println("");
        println("");
        print(clazz.getDoc().getFirstSentence());
        print(clazz.getDoc().getBody());
    }

    private void clear() {
        print("\033[2J");
        print("\033[0;0H");
    }

    private void print(Object o) {
        System.out.print(o);
    }

    private void println(Object o) {
        System.out.println(o);
    }
}

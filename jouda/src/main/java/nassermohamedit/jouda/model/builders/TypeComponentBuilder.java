package nassermohamedit.jouda.model.builders;

import javax.lang.model.element.Element;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.ClassComponent;
import nassermohamedit.jouda.model.TypeComponent;
import nassermohamedit.jouda.util.BuildUtils;

public abstract class TypeComponentBuilder<T extends TypeComponent> extends AbstractBuilder<T> {
    
    protected TypeElement e;

    protected BuildUtils buildUtils;

    protected T comp;

    public TypeComponentBuilder(TypeElement e, Configuration config) {
        super(config);
        this.buildUtils = config.getBuildUtils();
        this.e = e;
    }

    @Override
    public final T build() {
        comp = getComponent();
        if (comp == null) {
            throw new IllegalStateException("comp cannot be null");
        } 
        doBuild(); 
        return comp;
    }

    protected void doBuild() {
        setName();
        buildEnclosingPackageModule();
        buildTypeParameters();
        buildModifiers();
        buildSuperClass();
        buildInterfaces();
        buildPermittedSubtypes();
        buildKnownSubtypes();
        buildConstructors();
        buildFields();
        buildMethods();
        buildDoc();
    }

    protected abstract T getComponent();

    protected void setName() {
        comp.setName(e.getSimpleName().toString());
    }

    protected void buildEnclosingPackageModule() {
        Element enclosing = null, pack, module;
        if (e.getNestingKind() != NestingKind.TOP_LEVEL) {
            EnclosementIterator encItr = new EnclosementIterator(e);
            enclosing = encItr.next();
            pack = encItr.nextPackage();
            module = encItr.nextModule();
        }
        else {
            pack = e.getEnclosingElement();
            module = pack.getEnclosingElement();
        }
        comp.setPackage(buildUtils.toName(pack));
        comp.setModule(buildUtils.toName(module));
        comp.setEnclosingType(buildUtils.toName(enclosing));
    }

    protected void buildModifiers() {
        buildUtils.setModifiers(e, comp); 
    }

    protected void buildTypeParameters() {
        buildUtils.setTypeParameters(e, comp);
    }

    protected void buildSuperClass() {
        if (comp instanceof ClassComponent cc) {
            buildUtils.buildSuperClassPart(e, cc);
        }
    }

    protected void buildInterfaces() {
        buildUtils.buildInterfacePart(e, comp);
    }

    protected void buildPermittedSubtypes() {
        buildUtils.buildPermittedSubtypesPart(e, comp);
    }

    protected void buildKnownSubtypes() {
        buildUtils.buildKnownSubtypesPart(e, comp);
    }

    protected void buildConstructors() {
        buildUtils.buildConstructorPart(e, comp);
    }

    protected void buildFields() {
        buildUtils.buildFieldPart(e, comp);
    }

    protected void buildMethods() {
        buildUtils.buildMethodPart(e, comp);
    }
    
    protected void buildDoc() {
        buildUtils.buildDocPart(e, comp);
    }
}

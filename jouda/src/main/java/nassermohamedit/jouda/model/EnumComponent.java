package nassermohamedit.jouda.model;


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public final class EnumComponent implements TypeComponent {

    private String name;

    private Name module;

    private Name backage;

    @XmlElement(name = "enclosing-type")
    private Name enclosingType;

    @XmlElement(name = "modifier")
    private List<Modifier> modifiers;

    @XmlElement(name = "annotation")
    private List<Name> annotations;

    @XmlElement(name = "constant")
    private List<EnumConstantComponent> constants;

    @XmlElement(name = "field")
    private List<FieldComponent> fields;

    @XmlElement(name = "method")
    private List<MethodComponent> methods;

    private DocComponent doc;

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Name getModule() {
        return module;
    }

    @Override
    public void setModule(Name module) {
        this.module = module;
    }

    public Name getPackage() {
        return backage;
    }

    @Override
    public void setPackage(Name backage) {
        this.backage = backage;
    }

    @Override
    public void setEnclosingType(Name enclosing) {
        this.enclosingType = enclosing;
    }

    public Name getEnclosingType() {
        return enclosingType;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    @Override
    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<Name> getAnnotations() {
        return annotations;
    }

    @Override
    public void setAnnotations(List<Name> annotations) {
        this.annotations = annotations;
    }

    public List<EnumConstantComponent> getConstants() {
        return constants;
    }

    public void setConstants(List<EnumConstantComponent> constants) {
        this.constants = constants;
    }

    public List<FieldComponent> getFields() {
        return fields;
    }

    @Override
    public void setFields(List<FieldComponent> fields) {
        this.fields = fields;
    }

    public List<MethodComponent> getMethods() {
        return methods;
    }

    @Override
    public void setMethods(List<MethodComponent> methods) {
        this.methods = methods;
    }

    public DocComponent getDoc() {
        return doc;
    }

    public void setDoc(DocComponent doc) {
        this.doc = doc;
    }

    @Override
    public void setTypeParameters(List<TypeParameter> tp) {}

    @Override
    public void setSuperClass(Name sup) {}

    @Override
    public void setInterfaces(List<Name> interfaces) {}

    @Override
    public void setPermittedSubtypes(List<Name> subtypes) {}

    @Override
    public void setKnownSubtypes(List<Name> subtypes) {}

    @Override
    public void setConstructors(List<ConstructorComponent> contrs) {}
}

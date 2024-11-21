package nassermohamedit.jouda.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public final class InterfaceComponent implements TypeComponent {

    @XmlElement(name = "name")
    private String name;
    
    private Name module;

    @XmlElement(name = "package")
    private Name backage;

    @XmlElement(name = "enclosing-type")
    private Name enclosingType;
    
    @XmlElement(name = "modifier")
    private Modifiers modifiers;
    
    @XmlElement(name = "interface")
    private List<Name> interfaces;

    @XmlElement(name = "permitted")
    private List<Name> permittedSubtypes;

    @XmlElement(name = "known-subclass")
    private List<Name> knownSubtypes;

    @XmlElement(name = "type-parameter")
    private List<TypeParameter> typeParameters;

    @XmlElement(name = "annotation")
    private List<Name> annotations;

    private DocComponent doc;

    @XmlElement(name = "field") 
    private List<FieldComponent> fields;

    @XmlElement(name = "method")
    private List<MethodComponent> methods;

    public boolean addMethod(MethodComponent method) {
        if (methods == null) methods = new ArrayList<>();
        return methods.add(method);
    }

    public boolean addField(FieldComponent field) {
        if (fields == null) fields = new ArrayList<>();
        return fields.add(field);
    }

    @Override
    public boolean isRootComponent() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Name getModule() {
        return module;
    }

    public void setModule(Name module) {
        this.module = module;
    }

    public Name getPackage() {
        return backage;
    }

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


    public Modifiers getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifiers modifiers) {
        this.modifiers = modifiers;
    }

    public List<Name> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<Name> interfaces) {
        this.interfaces = interfaces;
    }

    public void setSuperClass(Name sup) {}

    public List<Name> getPermittedSubtypes() {
        return permittedSubtypes;
    }

    public void setPermittedSubtypes(List<Name> permittedSubtypes) {
        this.permittedSubtypes = permittedSubtypes;
    }

    public List<Name> getKnownSubtypes() {
        return knownSubtypes;
    }

    public void setKnownSubtypes(List<Name> knownSubtypes) {
        this.knownSubtypes = knownSubtypes;
    }

    public DocComponent getDoc() {
        return doc;
    }

    public void setDoc(DocComponent doc) {
        this.doc = doc;
    }

    public List<FieldComponent> getFields() {
        return fields;
    }

    public void setFields(List<FieldComponent> fields) {
        this.fields = fields;
    }

    public List<MethodComponent> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodComponent> methods) {
        this.methods = methods;
    }

    public List<Name> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Name> annotations) {
        this.annotations = annotations;
    }

    public void setConstructors(List<ConstructorComponent> construcors) {}

    public List<TypeParameter> getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(List<TypeParameter> typeParameters) {
        this.typeParameters = typeParameters;
    }
}

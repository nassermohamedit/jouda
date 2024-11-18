package nassermohamedit.jouda.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlType(propOrder = {})
@XmlAccessorType(XmlAccessType.FIELD)
public final class ClassComponent implements TypeComponent {

    @XmlElement(name = "name")
    private String name;

    private Name module;

    @XmlElement(name = "package")
    private Name backage;

    @XmlElement(name = "enclosing-type")
    private Name enclosingType;
    
    @XmlElement(name = "modifier")
    private List<Modifier> modifiers;

    @XmlElement(name = "type-parameter")
    private List<TypeParameter> typeParameters;
    
    @XmlElement(name = "interface")
    private List<Name> interfaces;

    private Name superClass;

    @XmlElement(name = "annotation")
    private List<Name> annotations;

    @XmlElement(name = "permitted")
    private List<Name> permittedSubtypes;

    @XmlElement(name = "known-subclass")
    private List<Name> knownSubtypes;

    private DocComponent doc;

    @XmlElement(name = "constructor")
    private List<ConstructorComponent> construcors;

    @XmlElement(name = "field") 
    private List<FieldComponent> fields;

    @XmlElement(name = "method")
    private List<MethodComponent> methods;

    public boolean addConstructor(ConstructorComponent constr) {
        if (construcors == null) construcors = new ArrayList<>();
        return this.construcors.add(constr);
    }

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


    public void setPackage(Name backage) {
        this.backage = backage;
    }

    public Name getPackage() {
        return backage;
    }

    public void setEnclosingType(Name enclosing) {
        enclosingType = enclosing;
    }

    public Name getEnclosingType() {
        return enclosingType;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<Name> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<Name> interfaces) {
        this.interfaces = interfaces;
    }

    public Name getSupperClass() {
        return superClass;
    }

    public void setSuperClass(Name sup) {
        this.superClass= sup;
    }

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

    public List<ConstructorComponent> getConstrucors() {
        return construcors;
    }

    public void setConstructors(List<ConstructorComponent> construcors) {
        this.construcors = construcors;
    }

    public List<TypeParameter> getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(List<TypeParameter> typeParameters) {
        this.typeParameters = typeParameters;
    }
}

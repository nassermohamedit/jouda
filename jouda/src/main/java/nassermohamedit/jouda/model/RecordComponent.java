package nassermohamedit.jouda.model;


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
public final class RecordComponent implements TypeComponent {

    @XmlElement(name = "name")
    private String name;
    
    private Name module;

    @XmlElement(name = "package")
    private Name backage;

    @XmlElement(name = "enclosing-type")
    private Name enclosingType;
    
    @XmlElement(name = "modifier")
    private List<Modifier> modifiers;

    @XmlElement(name = "canonical-constructor")
    private ConstructorComponent canonical; 
    
    private DocComponent doc;

    @XmlElement(name = "field") 
    private List<FieldComponent> fields;

    @XmlElement(name = "method")
    private List<MethodComponent> methods;

    @XmlElement(name = "annotation")
    private List<Name> annotations;

    @XmlElement(name = "constructor")
    private List<ConstructorComponent> construcors;

    @XmlElement(name = "type-parameter")
    private List<TypeParameter> typeParameters;

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

    @Override
    public void setEnclosingType(Name enclosing) {
        this.enclosingType = enclosing;
    }

    public Name getEnclosingType() {
        return enclosingType;
    }


    public Name getPackage() {
        return backage;
    }

    public void setPackage(Name backage) {
        this.backage = backage;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public ConstructorComponent getCanonical() {
        return canonical;
    }

    public void setCanonical(ConstructorComponent canonical) {
        this.canonical = canonical;
    }


    public void setInterfaces(List<Name> interfaces) {}

    public void setSuperClass(Name sup) {}

    public void setPermittedSubtypes(List<Name> permittedSubtypes) {}

    public void setKnownSubtypes(List<Name> knownSubtypes) {}

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

package nassermohamedit.jouda.model;


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class MethodComponent implements ExecutableComponent {
    
    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "modifier")
    private Modifiers modifiers;

    @XmlElement(required = true)
    private Name returnType;

    @XmlElement(name = "parameter")
    private List<Parameter> parameters;

    @XmlElement(name = "type-parameter")
    private List<TypeParameter> typeParameters;

    @XmlElement(name = "exception")
    private List<Name> exceptions;

    @XmlElement(name = "annotation")
    private List<Name> annotations;

    private DocComponent doc;
    
    @Override
    public boolean isRootComponent() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Modifiers getModifiers() {
        return modifiers;
    }

    public void setModifiers(Modifiers modifiers) {
        this.modifiers = modifiers;
    }

    public Name getReturnType() {
        return returnType;
    }

    public void setReturnType(Name returnType) {
        this.returnType = returnType;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<TypeParameter> getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(List<TypeParameter> typeParameters) {
        this.typeParameters = typeParameters;
    }

    public List<Name> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Name> exceptions) {
        this.exceptions = exceptions;
    }

    public List<Name> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Name> annotations) {
        this.annotations = annotations;
    }

    public DocComponent getDoc() {
        return doc;
    }

    public void setDoc(DocComponent doc) {
        this.doc = doc;
    }
}

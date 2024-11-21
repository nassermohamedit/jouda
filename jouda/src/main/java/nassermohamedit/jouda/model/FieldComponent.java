package nassermohamedit.jouda.model;


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class FieldComponent implements Component, HasModifiers, Annotatable, Documentable {

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "modifier")
    private Modifiers modifiers;

    @XmlElement(required = true)
    private Name type;

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

    public Name getType() {
        return type;
    }

    public void setType(Name type) {
        this.type = type;
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

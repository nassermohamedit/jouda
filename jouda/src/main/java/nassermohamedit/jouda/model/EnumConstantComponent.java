package nassermohamedit.jouda.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;


@XmlAccessorType(XmlAccessType.FIELD)
public class EnumConstantComponent implements Component, Documentable {
    
    private String name;

    private DocComponent doc;

    @XmlTransient
    private Name en;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocComponent getDoc() {
        return doc;
    }

    public void setDoc(DocComponent doc) {
        this.doc = doc;
    }

    @Override
    public boolean isRootComponent() {
        return false;
    }
}

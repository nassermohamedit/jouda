package nassermohamedit.jouda.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PackageComponent implements Component, Documentable {
    
    private String name;

    private Name module;

    private List<Name> elements;

    private DocComponent doc;

    public DocComponent getDoc() {
        return doc;
    }

    public void setDoc(DocComponent doc) {
        this.doc = doc;
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

    public List<Name> getElements() {
        return elements;
    }

    public void setElements(List<Name> elements) {
        this.elements = elements;
    }

    @Override
    public boolean isRootComponent() {
        return true;
    }

}

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
public class Parameter {

    @XmlElement(required = true)
    private Name type;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "annotation")
    private List<Name> annotations;

    public Parameter() {}

    public Parameter(String name, Name type, List<Name> annots) {
        this.name = name;
        this.type = type;
        this.annotations = annots;
    }

    public Name getType() {
        return type;
    }

    public void setType(Name type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Name> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Name> annotations) {
        this.annotations = annotations;
    }
}

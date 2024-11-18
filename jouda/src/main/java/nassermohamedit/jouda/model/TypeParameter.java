package nassermohamedit.jouda.model;


import java.util.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlType(propOrder = {})
@XmlAccessorType(XmlAccessType.FIELD)
public class TypeParameter {
    
    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "bound")
    private Set<Name> bounds;

    public void addBound(Name nameable) {
        if (bounds == null) bounds = new HashSet<>();
        this.bounds.add(nameable);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Name> getBounds() {
        return bounds;
    }

    public void setBounds(Set<Name> bounds) {
        this.bounds = bounds;
    }
}


package nassermohamedit.jouda.model;


import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlValue;


@XmlAccessorType(XmlAccessType.FIELD)
public class Name {

    @XmlValue
    private String name;

    public Name() {}

    public Name(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        int idx = name.lastIndexOf('.');
        return idx < 0 ? name : name.substring(idx + 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Name n)
            return name.equals(n.name);
        return false;
    }

    @Override
    public int hashCode() {
       return Objects.hashCode("Name:" + name); 
    }
}

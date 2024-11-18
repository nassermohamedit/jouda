package nassermohamedit.jouda.model;


import jakarta.xml.bind.annotation.XmlEnumValue;


public enum ClassKind {

    @XmlEnumValue("class")
    CLASS,

    @XmlEnumValue("interface")
    INTERFACE,

    @XmlEnumValue("enum")
    ENUM,

    @XmlEnumValue("record")
    RECORD,
}

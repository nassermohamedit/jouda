package nassermohamedit.jouda.model;

import jakarta.xml.bind.annotation.XmlEnumValue;

public enum Modifier {

    @XmlEnumValue("public")
    PUBLIC,

    @XmlEnumValue("protected")
    PROTECTED,

    @XmlEnumValue("private")
    PRIVATE,

    @XmlEnumValue("abstract")
    ABSTRACT,
    
    @XmlEnumValue("default")
    DEFAULT,

    @XmlEnumValue("static")
    STATIC,

    @XmlEnumValue("transient")
    TRANSIENT,

    @XmlEnumValue("scinchronized")
    SYNCHRONIZED,

    @XmlEnumValue("volatile")
    VOLATILE,

    @XmlEnumValue("final")
    FINAL,

    @XmlEnumValue("sealed")
    SEALED,

    @XmlEnumValue("non-sealed")
    NON_SEALED,

    @XmlEnumValue("native")
    NATIVE;
}

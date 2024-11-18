package nassermohamedit.jouda.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "documentation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Documentation {
    
    @XmlElements({
        @XmlElement(name = "package", type = PackageComponent.class),
        @XmlElement(name = "module", type = ModuleComponent.class),
        @XmlElement(name = "class", type = ClassComponent.class),
        @XmlElement(name = "interafce", type = InterfaceComponent.class),
        @XmlElement(name = "record", type = RecordComponent.class),
        @XmlElement(name = "enum", type = EnumComponent.class)
    })
    private Component topLevel; 

    public Documentation() {}
    
    public Documentation(Component c) {
        this.topLevel = c;
    }

    public void setTopLevel(Component c) {
        topLevel = c;
    }

    public Component getTopLevel() {
        return topLevel;
    }

}

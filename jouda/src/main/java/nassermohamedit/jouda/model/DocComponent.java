package nassermohamedit.jouda.model;


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlType(propOrder = {})
@XmlAccessorType(XmlAccessType.FIELD)
public class DocComponent implements Component {
    
    private String firstSentence;

    private String body;

    @XmlElement(name = "tag")
    private List<BlockTag> tags;

    @Override
    public boolean isRootComponent() {
        return false;
    }
}

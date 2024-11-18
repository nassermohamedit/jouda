package nassermohamedit.jouda.model;


import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlType(propOrder = {})
public abstract class BlockTag {
    
    public abstract String name();

    public abstract String toString();

    @Getter
    @Setter
    public static class Return extends BlockTag {

        private String description;
        
        @Override
        public String name() {
            return "@return";
        }

        @Override
        public String toString() {
            return name() + " " + description;
        }
    }

    @Getter
    @Setter
    public static class Param extends BlockTag {
        
        private String name;

        private String description;

        @Override
        public String name() {
            return "@param";
        }

        @Override
        public String toString() {
            return name() + " " + name + " " + description;
        }
    }

    @Getter
    @Setter
    public static class Exception extends BlockTag {
        
        private String className;

        private String description;

        @Override
        public String name() {
            return "@exception";
        }

        @Override
        public String toString() {
            return name() + " " + className + " " + description;
        }
    }
}

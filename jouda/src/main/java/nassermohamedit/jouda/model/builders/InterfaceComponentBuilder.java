package nassermohamedit.jouda.model.builders;

import javax.lang.model.element.TypeElement;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.InterfaceComponent;


public class InterfaceComponentBuilder extends TypeComponentBuilder<InterfaceComponent> {
    
    public InterfaceComponentBuilder(TypeElement e, Configuration config) {
        super(e, config);
    }

    @Override
    protected InterfaceComponent getComponent() {
        return new InterfaceComponent();
    }
}

package nassermohamedit.jouda.model.builders;


import javax.lang.model.element.TypeElement;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.ClassComponent;

public class ClassComponentBuilder extends TypeComponentBuilder<ClassComponent> {

    public ClassComponentBuilder(TypeElement e, Configuration config) {
        super(e, config);
    }

    @Override
    protected ClassComponent getComponent() {
        return new ClassComponent();
    }
}

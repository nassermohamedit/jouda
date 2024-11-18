package nassermohamedit.jouda.model.builders;

import javax.lang.model.element.TypeElement;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.RecordComponent;

public class RecordComponentBuilder extends TypeComponentBuilder<RecordComponent> {


    public RecordComponentBuilder(TypeElement e, Configuration config) {
        super(e, config);
    }

    @Override
    protected RecordComponent getComponent() {
        return new RecordComponent();
    }

}

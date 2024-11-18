package nassermohamedit.jouda.model.builders;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.Component;

public abstract class AbstractBuilder<T extends Component> implements Builder<T> {

    protected final Configuration config;

    public AbstractBuilder(Configuration config) {
        this.config = config;
    }
}

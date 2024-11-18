package nassermohamedit.jouda.model.builders;

import nassermohamedit.jouda.model.Component;

public interface Builder<T extends Component> {

    T build();
}

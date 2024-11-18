package nassermohamedit.jouda.model;

import java.util.Collection;

public interface Extendable {

    void setPermittedSubtypes(Collection<Name> subtypes);

    void setKnownSubTypes(Collection<Name> subtypes);
}

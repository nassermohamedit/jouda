package nassermohamedit.jouda.model;

import java.util.List;

public interface ExecutableComponent extends Component, HasModifiers, Annotatable, Documentable, TypeParameterizable {
    
    void setName(String name);

    void setParameters(List<Parameter> params);

    void setReturnType(Name ret);

    void setExceptions(List<Name> exc);

    void setAnnotations(List<Name> annots);
}

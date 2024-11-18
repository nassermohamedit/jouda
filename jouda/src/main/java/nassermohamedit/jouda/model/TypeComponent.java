package nassermohamedit.jouda.model;

import java.util.List;


public sealed interface TypeComponent extends Component, Annotatable, HasModifiers, TypeParameterizable, Documentable
    permits ClassComponent, InterfaceComponent, EnumComponent, RecordComponent {
    
    void setName(String name);

    void setPackage(Name backage);

    void setModule(Name module);

    void setEnclosingType(Name type);

    void setTypeParameters(List<TypeParameter> tp);

    void setSuperClass(Name sup);

    void setInterfaces(List<Name> interfaces);

    void setPermittedSubtypes(List<Name> subtypes);

    void setKnownSubtypes(List<Name> subtypes);

    void setConstructors(List<ConstructorComponent> contrs);

    void setFields(List<FieldComponent> fields);

    void setMethods(List<MethodComponent> methods);

    void setDoc(DocComponent doc);

    @Override
    default boolean isRootComponent() {
        return true;
    }

}

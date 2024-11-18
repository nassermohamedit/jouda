package nassermohamedit.jouda.model.builders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.EnumComponent;
import nassermohamedit.jouda.model.EnumConstantComponent;

public class EnumComponentBuilder extends TypeComponentBuilder<EnumComponent> {
    
    public EnumComponentBuilder(TypeElement e, Configuration config) {
        super(e, config);
    }


    @Override
    public void doBuild() {
        buildEnclosingPackageModule();
        buildModifiers();
        buildFields();
        buildDoc();
        buildMethods();
        buildEnumConstants();
    }

    private void buildEnumConstants() {
        Iterator<? extends Element> consts = config.getUtils().getEnumConstants(e).iterator();
        List<EnumConstantComponent> constants = new ArrayList<>();
        while (consts.hasNext()) {
            Element c = consts.next();
            EnumConstantComponent cc = new EnumConstantComponent();
            cc.setName(c.getSimpleName().toString());
            config.getBuildUtils().buildDocPart(c, cc);
            constants.add(cc);
        }
        comp.setConstants(constants);
    }

    @Override
    protected EnumComponent getComponent() {
        return new EnumComponent();
    }
}

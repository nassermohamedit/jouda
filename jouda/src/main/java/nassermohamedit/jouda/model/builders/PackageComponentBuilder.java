package nassermohamedit.jouda.model.builders;


import javax.lang.model.element.PackageElement;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.PackageComponent;
import nassermohamedit.jouda.util.BuildUtils;


public class PackageComponentBuilder extends AbstractBuilder<PackageComponent> {
    
    private PackageElement e;

    private PackageComponent comp;

    public PackageComponentBuilder(PackageElement e, Configuration config) {
        super(config);
        this.e = e;
    }

    @Override
    public PackageComponent build() {
        comp = new PackageComponent();
        BuildUtils buildUtils = config.getBuildUtils();
        comp.setName(e.getQualifiedName().toString());
        comp.setModule(buildUtils.toName(e.getEnclosingElement()));
        comp.setElements(e.getEnclosedElements().stream().map(buildUtils::toName).toList());
        buildUtils.buildDocPart(e, comp);
        return comp;
    }
}

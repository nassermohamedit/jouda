package nassermohamedit.jouda.model.builders;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.ModuleElement;
import javax.lang.model.element.ModuleElement.Directive;
import javax.lang.model.element.ModuleElement.ExportsDirective;
import javax.lang.model.element.ModuleElement.OpensDirective;
import javax.lang.model.element.ModuleElement.ProvidesDirective;
import javax.lang.model.element.ModuleElement.RequiresDirective;
import javax.lang.model.element.ModuleElement.UsesDirective;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.ModuleComponent;
import nassermohamedit.jouda.model.ModuleComponent.Exports;
import nassermohamedit.jouda.model.ModuleComponent.Opens;
import nassermohamedit.jouda.model.ModuleComponent.Provides;
import nassermohamedit.jouda.model.ModuleComponent.Requires;
import nassermohamedit.jouda.model.ModuleComponent.Uses;
import nassermohamedit.jouda.util.BuildUtils;

public class ModuleComponentBuilder extends AbstractBuilder<ModuleComponent> {

    private ModuleElement e;

    private ModuleComponent comp;

    private BuildUtils buildUtils;

    public ModuleComponentBuilder(ModuleElement e, Configuration config) {
        super(config);
        this.e = e;
    }

    @Override
    public ModuleComponent build() {
        comp = new ModuleComponent();
        buildUtils = config.getBuildUtils();
        List<Requires> requires = new ArrayList<>();
        List<Exports> exports = new ArrayList<>();
        List<Uses> uses = new ArrayList<>();
        List<Opens> opens = new ArrayList<>();
        List<Provides> provides = new ArrayList<>();
        for (Directive dir: e.getDirectives()) {
            switch (dir) {
                case ExportsDirective ed -> exports.add(toExport(ed)); 
                case UsesDirective ud -> uses.add(toUses(ud));
                case RequiresDirective rd -> requires.add(toRequire(rd));
                case OpensDirective od -> opens.add(toOpens(od));
                case ProvidesDirective pd -> provides.add(toProvides(pd));
                default -> throw new IllegalArgumentException();
            }
        }
        return comp;
    }

    private Provides toProvides(ProvidesDirective pd) {
        return new Provides(buildUtils.toName(pd.getService()));
    }

    private Opens toOpens(OpensDirective od) {
        return new Opens(buildUtils.toName(od.getPackage()));
    }

    private Requires toRequire(RequiresDirective rd) {
        return new Requires(buildUtils.toName(rd.getDependency()));
    }

    private Uses toUses(UsesDirective ud) {
        return new Uses(buildUtils.toName(ud.getService()));
    }

    private Exports toExport(ExportsDirective ed) {
        return new Exports(
                buildUtils.toName(ed.getPackage()),
                ed.getTargetModules().stream().map(buildUtils::toName).toList());
    }
}

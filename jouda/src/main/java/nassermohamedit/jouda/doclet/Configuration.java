package nassermohamedit.jouda.doclet;



import com.sun.source.util.DocTrees;

import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;
import jdk.javadoc.doclet.Doclet;
import nassermohamedit.jouda.util.BuildUtils;
import nassermohamedit.jouda.util.Utils;


public final class Configuration {

    Doclet doclet;
    
    DocletEnvironment docEnv;

    DocTrees docTrees;

    Utils utils;

    BuildUtils buildUtils;

    Reporter reporter;

    Configuration(Doclet doclet, Reporter reporter) {
        this.doclet = doclet;
        this.reporter = reporter;
    }

    void initConfiguration(DocletEnvironment docEnv) {
        this.docEnv = docEnv;
        docTrees = docEnv.getDocTrees();
        utils = new Utils(this);
        buildUtils = new BuildUtils(this);
    }

    public Utils getUtils() {
        return utils;
    }

    public DocTrees getDocTrees() {
        return docTrees;
    }

    public BuildUtils getBuildUtils() {
        return buildUtils;
    }
}

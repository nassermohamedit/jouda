package nassermohamedit.jouda.util;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Parameterizable;
import javax.lang.model.element.QualifiedNameable;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocTree;
import com.sun.source.util.DocTrees;

import nassermohamedit.jouda.doclet.Configuration;
import nassermohamedit.jouda.model.Annotatable;
import nassermohamedit.jouda.model.ClassComponent;
import nassermohamedit.jouda.model.ConstructorComponent;
import nassermohamedit.jouda.model.DocComponent;
import nassermohamedit.jouda.model.Documentable;
import nassermohamedit.jouda.model.ExecutableComponent;
import nassermohamedit.jouda.model.FieldComponent;
import nassermohamedit.jouda.model.HasModifiers;
import nassermohamedit.jouda.model.MethodComponent;
import nassermohamedit.jouda.model.Modifiers;
import nassermohamedit.jouda.model.Name;
import nassermohamedit.jouda.model.Parameter;
import nassermohamedit.jouda.model.TypeComponent;
import nassermohamedit.jouda.model.TypeParameter;
import nassermohamedit.jouda.model.TypeParameterizable;

public class BuildUtils {
    
    public final Configuration config;

    public final Utils utils;

    public BuildUtils(Configuration config) {
        this.config = config;
        this.utils = this.config.getUtils();
    }

    public void buildSuperClassPart(TypeElement e, ClassComponent comp) {
        TypeMirror sup = e.getSuperclass();
        comp.setSuperClass(toName(sup));
    }

    public void buildInterfacePart(TypeElement e, TypeComponent comp) {
        List<? extends TypeMirror> inters = e.getInterfaces();
        if (inters.isEmpty()) return;
        comp.setInterfaces(inters.stream()
                .map(this::toName)
                .toList());
    }

    public void buildConstructorPart(TypeElement e, TypeComponent comp) {
        List<? extends ExecutableElement> constructors = utils.getConstructors(e);
        comp.setConstructors(constructors.stream().map(this::buildConstructor).toList());
    }

    public void buildMethodPart(TypeElement e, TypeComponent comp) {
        List<? extends ExecutableElement> methods = utils.getMethods(e);
        comp.setMethods(methods.stream().map(this::buildMethod).toList());
    }

    public void buildFieldPart(TypeElement e, TypeComponent comp) {
        List<? extends Element> fields = utils.getFields(e);
        comp.setFields(fields.stream().map(this::buildField).toList());
    }

    public void setModifiers(Element e, HasModifiers comp) {
        Modifiers modifiers = new Modifiers();
        e.getModifiers().stream()
                .map(this::toModifier)
                .forEach(modifiers::set);
        comp.setModifiers(modifiers);
    }
    
    public void buildDocPart(Element e, Documentable comp) {
        comp.setDoc(buildDoc(e));
    }

    public ConstructorComponent buildConstructor(ExecutableElement ee) {
        ConstructorComponent constr = new ConstructorComponent();    
        setModifiers(ee, constr);
        setTypeParameters(ee, constr);
        setParameters(ee, constr);
        setDeclaredExceptions(ee, constr);
        setAnnatotaions(ee, constr);
        setDocComment(ee, constr);
        return constr;
    }

    public MethodComponent buildMethod(ExecutableElement ee) {
        MethodComponent method = new MethodComponent();
        method.setName(ee.getSimpleName().toString());
        setModifiers(ee, method);
        setTypeParameters(ee, method);
        setParameters(ee, method);
        setDeclaredExceptions(ee, method);
        setAnnatotaions(ee, method);
        setReturnType(ee, method);
        setDocComment(ee, method);
        return method;
    }

    public FieldComponent buildField(Element e) {
        if (!utils.isField(e)) {
            throw new IllegalArgumentException("Not a field: " + e);
        }
        FieldComponent field = new FieldComponent();
        field.setName(e.getSimpleName().toString());
        setModifiers(e, field);
        setType(e, field);
        setAnnatotaions(e, field);
        setDocComment(e, field);
        return field;
    }

    public void buildPermittedSubtypesPart(TypeElement e, TypeComponent comp) {
    }

    public void buildKnownSubtypesPart(TypeElement e, TypeComponent comp) {
    }

    
    public DocComponent buildDoc(Element e) {
        DocComponent doc = new DocComponent();
        DocCommentTree docs = config.getDocTrees().getDocCommentTree(e);
        if (docs == null) return null;
        setFirstSentence(docs, doc);
        setBody(docs, doc);
        setBlockTags(docs, doc);
        return doc;
    }

    public void setTypeParameters(Parameterizable ee, TypeParameterizable p) {
        List<? extends TypeParameterElement> tps = ee.getTypeParameters();
        if (tps.isEmpty()) return;
        p.setTypeParameters(tps.stream().map(this::toTypeParameter).toList());
    }


    public void setParameters(ExecutableElement ee, ExecutableComponent ec) {
        List<? extends VariableElement> params = ee.getParameters();
        if (params.isEmpty()) return;
        ec.setParameters(params.stream().map(this::toParameter).toList());
    }

    public void setReturnType(ExecutableElement ee, ExecutableComponent ec) {
        TypeMirror ret = ee.getReturnType();
        ec.setReturnType(toName(ret));
    }

    public void setDeclaredExceptions(ExecutableElement ee, ExecutableComponent ec) {
        List<? extends TypeMirror> throwables = ee.getThrownTypes();
        if (throwables.isEmpty()) return;
        ec.setExceptions(throwables.stream().map(this::toName).toList());
    }

    public void setAnnatotaions(Element e, Annotatable c) {
        List<? extends AnnotationMirror> annots = e.getAnnotationMirrors();
        if (annots.isEmpty()) return;
        c.setAnnotations(annots.stream()
                .map(AnnotationMirror::getAnnotationType)
                .map(this::toName)
                .toList());
    }

    public void setType(Element ve, FieldComponent f) {
        f.setType(toName(ve.asType()));
    }

    public void setDocComment(Element e, Documentable d) {
        DocComponent doc = new DocComponent();
        DocTrees trees = config.getDocTrees();
        System.out.println(e.getKind() + ":" + e.getSimpleName() + ":" + trees);
        DocCommentTree docs = trees.getDocCommentTree(e);
        if (docs == null) return;
        setFirstSentence(docs, doc);
        setBody(docs, doc);
        setBlockTags(docs, doc);
        d.setDoc(doc);
    }

    public void setFirstSentence(DocCommentTree docs, DocComponent d) {
        List<? extends DocTree> fsTrees = docs.getFirstSentence();
        if (fsTrees.size() == 0) return;
        String fs = join(fsTrees);
        d.setFirstSentence(fs);
    }

    public void setBody(DocCommentTree docs, DocComponent d) {
        Objects.requireNonNull(d);
        List<? extends DocTree> bodyTrees = docs.getBody();
        if (bodyTrees.size() == 0) return;
        String body = join(bodyTrees);
        d.setBody(body);
    }

    public void setBlockTags(DocCommentTree docs, DocComponent d) {
        // TODO
    }

    public String join(List<? extends DocTree> docTrees) {
        Objects.requireNonNull(docTrees);
        return docTrees.stream()
            .map(DocTree::toString)
            .collect(Collectors.joining());
    } 


    public nassermohamedit.jouda.model.Modifier toModifier(Modifier mod) {
        if (mod == null) return null;
        return nassermohamedit.jouda.model.Modifier.valueOf(
                mod.toString().toUpperCase()
        );
    }

    public TypeParameter toTypeParameter(TypeParameterElement tpe) {
        if (tpe == null) return null;
        TypeParameter tp = new TypeParameter();
        tp.setName(tpe.getSimpleName().toString());
        Iterator<? extends TypeMirror> bounds = tpe.getBounds().iterator();
        while (bounds.hasNext()) {
            Name nameable = toName(bounds.next());
            tp.addBound(nameable);
        }
        return tp;
    }

    public Name toName(Element e) {
        if (e == null) return null;
        String name = e.getSimpleName().toString();
        String qualifiedName = (e instanceof QualifiedNameable qn)?
            qn.getQualifiedName().toString():
            name;
        return new Name(qualifiedName);
    }

    public Name toName(TypeMirror tm) {
        if (tm == null) return null;
        String name = tm.toString();
        return new Name(name);
    }

    public Parameter toParameter(VariableElement ve) {
        if (ve == null) return null;
        String name = ve.getSimpleName().toString();
        List<Name> annots = ve.getAnnotationMirrors().stream()
            .map(AnnotationMirror::getAnnotationType).map(this::toName)
            .toList();
        Name type = toName(ve.asType());
        return new Parameter(name, type, annots);
    }
}


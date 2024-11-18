package nassermohamedit.jouda.util;

import java.util.List;
import java.util.function.Predicate;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import nassermohamedit.jouda.doclet.Configuration;

public final class Utils {

    private final Configuration config;

    public Utils(Configuration config) {
        this.config = config;
    }

    public boolean isAnnotated(TypeMirror e) {
        return !e.getAnnotationMirrors().isEmpty();
    }

    public boolean isAnnotationInterface(Element e) {
        return e.getKind() == ElementKind.ANNOTATION_TYPE;
    }

    public boolean isClass(Element e) {
        return e.getKind().isClass();
    }

    public boolean isInterface(Element e) {
        return e.getKind().isInterface();
    }

    public boolean isConstructor(Element e) {
         return e.getKind() == ElementKind.CONSTRUCTOR;
    }

    public boolean isEnum(Element e) {
        return e.getKind() == ElementKind.ENUM;
    }

    public boolean isField(Element e) {
        return e.getKind() == ElementKind.FIELD;
    }

    public boolean isPlainInterface(Element e) {
        return e.getKind() == ElementKind.INTERFACE;
    }

    public boolean isMethod(Element e) {
        return e.getKind() == ElementKind.METHOD;
    }

    public boolean isModule(Element e) {
        return e.getKind() == ElementKind.MODULE;
    }

    public boolean isPackage(Element e) {
        return e.getKind() == ElementKind.PACKAGE;
    }

    public boolean isAbstract(Element e) {
        return e.getModifiers().contains(Modifier.ABSTRACT);
    }

    public boolean isDefault(Element e) {
        return e.getModifiers().contains(Modifier.DEFAULT);
    }

    public boolean isFinal(Element e) {
        return e.getModifiers().contains(Modifier.FINAL);
    }

    public boolean isPackagePrivate(Element e) {
        var m = e.getModifiers();
        return !m.contains(Modifier.PUBLIC)
                && !m.contains(Modifier.PROTECTED)
                && !m.contains(Modifier.PRIVATE);
    }

    public boolean isPrivate(Element e) {
        return e.getModifiers().contains(Modifier.PRIVATE);
    }

    public boolean isProtected(Element e) {
        return e.getModifiers().contains(Modifier.PROTECTED);
    }

    public boolean isPublic(Element e) {
        return e.getModifiers().contains(Modifier.PUBLIC);
    }

    public boolean isStatic(Element e) {
        return e.getModifiers().contains(Modifier.STATIC);
    }


    public boolean isRecord(TypeElement e) {
        return e.getKind() == ElementKind.RECORD;
    }


    public boolean isExecutableElement(Element e) {
        return e.getKind().isExecutable();
    }

    public boolean isVariableElement(Element e) {
        return e.getKind().isVariable();
    }

    public boolean isTypeElement(Element e) {
        return e.getKind().isDeclaredType();
    }

    public List<? extends ExecutableElement> getConstructors(TypeElement te) { 
        return getMembers(
                te,
                m -> m.getKind() == ElementKind.CONSTRUCTOR,
                ExecutableElement.class);
    } 

     public List<? extends ExecutableElement> getMethods(TypeElement te) { 
        return getMembers(
                te,
                e -> e.getKind() == ElementKind.METHOD,
                ExecutableElement.class);
    }

    public List<? extends Element> getFields(TypeElement te) {
        return getMembers(
                te,
                m -> m.getKind() == ElementKind.FIELD,
                Element.class);
    } 

    public <T extends Element> List<T> getMembers(TypeElement e, Predicate<? super Element> filter, Class<T> clazz) {
        return e.getEnclosedElements().stream()
            .filter(m -> filter.test(m))
            .map(clazz::cast)
            .toList();
    }

    public List<? extends Element> getEnumConstants(TypeElement en) {
        if (!isEnum(en))
            throw new IllegalArgumentException("Not an enum: " + en);
        return getMembers(en, m -> m.getKind() == ElementKind.ENUM_CONSTANT, Element.class);
    }
}

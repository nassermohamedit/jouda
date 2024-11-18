package nassermohamedit.jouda.model.builders;

import static javax.lang.model.element.ElementKind.MODULE;
import static javax.lang.model.element.ElementKind.PACKAGE;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;

public class EnclosementIterator implements Iterator<Element> {

    private Element e;

    private boolean hasNext;

    public EnclosementIterator(Element e) {
        this.e = e;
        hasNext = e.getKind() == ElementKind.MODULE ? false : true;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public Element next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        e = e.getEnclosingElement();
        if (e.getKind() == ElementKind.MODULE) {
            hasNext = false;
        }
        return e;
    }
    
    public ElementKind kind() {
        return e.getKind();
    }

    public Element nextPackage() {
        ElementKind kind = e.getKind();
        if (kind == ElementKind.PACKAGE || kind == ElementKind.MODULE) {
            throw new NoSuchElementException();
        }
        while (e.getKind() != ElementKind.PACKAGE) {
            next();
        }
        return e;
    }

    public Element nextModule() {
        if (e.getKind() == ElementKind.MODULE) {
            throw new NoSuchElementException();
        }
        while (e.getKind() != ElementKind.MODULE) {
            next();
        }
        return e;
    }

    public Element newtTopLevelType() {
        ElementKind kind = e.getKind();
        if (kind == MODULE || kind == PACKAGE) {
            throw new NoSuchElementException();
        }
        TypeElement te = (TypeElement) e;
        while (te.getNestingKind() != NestingKind.TOP_LEVEL) {
            next();
        }
        return e;
    }
}

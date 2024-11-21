package nassermohamedit.jouda.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlValue;

import static nassermohamedit.jouda.model.Modifier.*;


@XmlAccessorType(XmlAccessType.NONE)
public class Modifiers {

    private static final int PUBLIC_V = 0b1;

    private static final int PROTECTED_V = 0b10;

    private static final int PRIVATE_V = 0b100;

    private static final int ABSTRACT_V = 0b1000;

    private static final int DEFAULT_V = 0b10000;

    private static final int FINAL_V = 0b100000;

    private static final int SEALED_V = 0b1000000;

    private static final int NON_SEALED_V = 0b10000000;

    private static final int SYNCHRONIZED_V = 0b100000000;

    private static final int VOLATILE_V = 0b1000000000;

    private static final int TRANSIENT_V = 0b10000000000;

    private static final int NATIVE_V = 0b100000000000;

    private static final int STATIC_V = 0b1000000000000;
    
    private int mask = 0;

    public Modifiers() {}
    
    public Modifiers(Collection<Modifier> modifiers) {
        setModifiers(modifiers);
    }

    public void setModifiers(Collection<Modifier> modifiers) {
     for (Modifier m : modifiers) {
            set(m);
        }
    }


    @XmlElement(name = "modifier")
    public Collection<Modifier> getModifiers() {
        var l = new ArrayList<Modifier>(7);
        if (isPublic()) l.add(PUBLIC); 
        else if (isProtected()) l.add(PROTECTED);
        else if (isPrivate()) l.add(PRIVATE);
        if (isAbstract()) l.add(ABSTRACT);
        else if (isDefault()) l.add(DEFAULT);
        if (isFinal()) l.add(FINAL);
        else if (isSealed()) l.add(SEALED);
        else if (isNonSealed()) l.add(NON_SEALED);
        if (isSynchronized()) l.add(SYNCHRONIZED);
        if (isVolatile()) l.add(VOLATILE);
        if (isTransient()) l.add(TRANSIENT);
        if (isNative()) l.add(NATIVE);
        return l;
    }


    public boolean isPublic() {
        return (mask & PUBLIC_V) != 0;
    }

    public boolean isProtected() {
        return (mask & PROTECTED_V) != 0;
    } 

    public boolean isPrivate() {
        return (mask & PRIVATE_V) != 0;
    }

    public boolean isAbstract() {
        return (mask & ABSTRACT_V) != 0;
    }

    public boolean isDefault() {
        return (mask & DEFAULT_V) != 0;
    }

    public boolean isFinal() {
        return (mask & FINAL_V) != 0;
    }

    public boolean isSealed() {
        return (mask & SEALED_V) != 0;
    }

    public boolean isNonSealed() {
        return (mask & NON_SEALED_V) != 0;
    }

    public boolean isSynchronized() {
        return (mask & SYNCHRONIZED_V) != 0;
    }

    public boolean isVolatile() {
        return (mask & VOLATILE_V) != 0;
    }

    public boolean isTransient() {
        return (mask & TRANSIENT_V) != 0;
    }

    public boolean isNative() {
        return (mask & NATIVE_V) != 0;
    }

    public boolean isStatic() {
        return (mask & STATIC_V) != 0;
    }


    public void setPublic() {
        if ((mask & (PRIVATE_V | PROTECTED_V)) != 0)
            throw new IllegalStateException("This modifier set contains one of {protected, private}");
		mask |= PUBLIC_V;
	}

    public void setProtected() {
        if ((mask & (PRIVATE_V | PUBLIC_V)) != 0)
            throw new IllegalStateException("This modifier set contains one of {private, public} ");
		mask |= PROTECTED_V;
	} 

    public void setPrivate() {
        if ((mask & (PROTECTED_V | PUBLIC_V)) != 0)
            throw new IllegalStateException("This modifier set contains one of {protected public}");
		mask |= PRIVATE_V;
	}

    public void setAbstract() {
        if (isDefault()) throw new IllegalStateException("Is default");
		mask |= ABSTRACT_V;
	}

    public void setDefault() {
        if (isAbstract()) throw new IllegalStateException("Is abstract");
		mask |= DEFAULT_V;
	}

    public void setFinal() {
        if (isSealed()) throw new IllegalStateException("Is sealed");
        if (isNonSealed()) throw new IllegalStateException("Is non-sealed");
		mask |= FINAL_V;
	}

    public void setSealed() {
        if (isFinal()) throw new IllegalStateException("Is final");
        if (isNonSealed()) throw new IllegalStateException("Is non-sealed");

		mask |= SEALED_V;
	}

    public void setNonSealed() {
        if (isFinal()) throw new IllegalStateException("Is final");
        if (isSealed()) throw new IllegalStateException("Is sealed");
		mask |= NON_SEALED_V;
	}

    public void setSynchronized() {
		mask |= SYNCHRONIZED_V;
	}

    public void setVolatile() {
		mask |= VOLATILE_V;
	}

    public void setTransient() {
		mask |= TRANSIENT_V;
	}

    public void setNative() {
		mask |= NATIVE_V;
	}

    public void setStatic() {
		mask |= STATIC_V;
	}

    public void set(Modifier m) {
        int x = mask | valueOf(m);
        if (!checkInvariants(x)) {
            //throw new IllegalStateException("Cannot set modifier " + m);
        }
        mask = x;
    }

    private static boolean checkInvariants(int x) {
        int t;
        if (((t = x & PRIVATE_V | PROTECTED_V | PUBLIC_V) & t - 1) != 0)
            return false;
        if (((t = x & ABSTRACT_V | DEFAULT_V) & t - 1) != 0)
            return false;
        if (((t = x & FINAL_V | SEALED_V | NON_SEALED_V) & t - 1) != 0)
            return false;
        return true;
    }
    
    private static int valueOf(Modifier m) {
        return switch (m) {
            case PUBLIC -> PUBLIC_V;
            case PROTECTED -> PROTECTED_V;
            case PRIVATE -> PRIVATE_V;
            case ABSTRACT -> ABSTRACT_V;
            case DEFAULT -> DEFAULT_V;
            case FINAL -> FINAL_V;
            case SEALED -> SEALED_V;
            case NON_SEALED -> NON_SEALED_V;
            case SYNCHRONIZED -> SYNCHRONIZED_V;
            case TRANSIENT -> TRANSIENT_V;
            case VOLATILE -> VOLATILE_V;
            case NATIVE -> NATIVE_V;
            case STATIC -> STATIC_V;
        };
    }
}

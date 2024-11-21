package nassermohamedit.jouda.model;

import java.util.Collection;
import java.util.EnumSet;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import static nassermohamedit.jouda.model.Modifier.*;


@XmlAccessorType(XmlAccessType.NONE)
public class Modifiers {

    private final EnumSet<Modifier> mods = EnumSet.noneOf(Modifier.class);

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
        return mods.clone();
    }


    public boolean isPublic() {
        return mods.contains(PUBLIC);
    }

    public boolean isProtected() {
        return mods.contains(PROTECTED);
    } 

    public boolean isPrivate() {
        return mods.contains(PRIVATE);
    }

    public boolean isAbstract() {
        return mods.contains(ABSTRACT);
    }

    public boolean isDefault() {
        return mods.contains(DEFAULT);
    }

    public boolean isFinal() {
        return mods.contains(FINAL);
    }

    public boolean isSealed() {
        return mods.contains(SEALED);
    }

    public boolean isNonSealed() {
        return mods.contains(NON_SEALED);
    }

    public boolean isSynchronized() {
        return mods.contains(SYNCHRONIZED);
    }

    public boolean isVolatile() {
        return mods.contains(VOLATILE);
    }

    public boolean isTransient() {
        return mods.contains(TRANSIENT);
    }

    public boolean isNative() {
        return mods.contains(NATIVE);
    }

    public boolean isStatic() {
        return mods.contains(STATIC);
    }


    public void setPublic() {
		mods.add(PUBLIC);
	}

    public void setProtected() {
		mods.add(PROTECTED);
	} 

    public void setPrivate() {
		mods.add(PRIVATE);
	}

    public void setAbstract() {
		mods.add(ABSTRACT);
	}

    public void setDefault() {
		mods.add(DEFAULT);
	}

    public void setFinal() {
		mods.add(FINAL);
	}

    public void setSealed() {
		mods.add(SEALED);
	}

    public void setNonSealed() {
		mods.add(NON_SEALED);
	}

    public void setSynchronized() {
		mods.add(SYNCHRONIZED);
	}

    public void setVolatile() {
		mods.add(VOLATILE);
	}

    public void setTransient() {
		mods.add(TRANSIENT);
	}

    public void setNative() {
		mods.add(NATIVE);
	}

    public void setStatic() {
		mods.add(STATIC);
	}

    public void set(Modifier m) {
    }

    private static boolean checkInvariants(int x) {
        // TODO
        return true;
    }
}

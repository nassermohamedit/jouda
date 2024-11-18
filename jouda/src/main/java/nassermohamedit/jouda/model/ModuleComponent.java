package nassermohamedit.jouda.model;


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class ModuleComponent implements Component, Documentable {
    
    private String name;

    private List<Requires> requires;

    private List<Exports> exports;

    private List<Provides> provides;

    private List<Uses> uses;

    private List<Opens> opens;

    private DocComponent doc;

    @Override
    public boolean isRootComponent() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Requires> getRequires() {
        return requires;
    }

    public void setRequires(List<Requires> requires) {
        this.requires = requires;
    }

    public List<Exports> getExports() {
        return exports;
    }

    public void setExports(List<Exports> exports) {
        this.exports = exports;
    }

    public List<Provides> getProvides() {
        return provides;
    }

    public void setProvides(List<Provides> provides) {
        this.provides = provides;
    }

    public List<Uses> getUses() {
        return uses;
    }

    public void setUses(List<Uses> uses) {
        this.uses = uses;
    }

    public List<Opens> getOpens() {
        return opens;
    }

    public void setOpens(List<Opens> opens) {
        this.opens = opens;
    }

    public DocComponent getDoc() {
        return doc;
    }

    public void setDoc(DocComponent doc) {
        this.doc = doc;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Exports {
        
        @XmlElement(name = "package")
        private Name backage;

        @XmlElement(name = "to")
        private List<Name> modules;

        public Exports() {}

        public Exports(Name backage, List<Name> modules) {
            this.backage = backage;
            this.modules = modules;
        }

        public Name gePBackage() {
            return backage;
        }

        public void setPackage(Name backage) {
            this.backage = backage;
        }

        public List<Name> getModules() {
            return modules;
        }

        public void setModules(List<Name> modules) {
            this.modules = modules;
        }
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Requires {
        
        @XmlValue
        private Name module;

        public Requires() {}
       
        public Requires(Name module) {
            this.module = module;
        }

         public Name getModule() {
            return module;
        }

        public void setModule(Name module) {
            this.module = module;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Uses {

        @XmlValue
        private Name service;
        
        public Uses() {}

        public Uses(Name service) {
            this.service = service;
        }

        public Name getService() {
            return service;
        }

        public void setService(Name service) {
            this.service = service;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Provides {

        @XmlValue
        private Name service;
        
        public Provides() {}

        public Provides(Name service) {
            this.service = service;
        }

        public Name getService() {
            return service;
        }

        public void setService(Name service) {
            this.service = service;
        }
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Opens {

        @XmlValue
        private Name backage;

        public Opens() {};

        public Opens(Name backage) {
            this.backage = backage;
        }

        public Name getPackage() {
            return backage;
        }

        public void setPackage(Name backage) {
            this.backage = backage;
        }
    }
}

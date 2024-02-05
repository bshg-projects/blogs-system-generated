package org.bshg.blogssystem.zutils.service;

public class Attribute {
    private String name;
    private String type;
    private Class complexType;

    public Attribute(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Attribute(String name) {
        this.name = name;
        this.type = "String";
    }

    public Attribute(String name, String type, Class complexType) {
        this.name = name;
        this.type = type;
        this.complexType = complexType;
    }

    public Attribute() {
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public Class getComplexType() {
        return this.complexType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setComplexType(Class complexType) {
        this.complexType = complexType;
    }
}

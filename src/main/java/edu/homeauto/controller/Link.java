package edu.homeauto.controller;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Link {

    private String rel;
    private String href;

    public Link() {}

    public Link(String rel, String href) {
        this.rel = rel;
        this.href = href;
    }

    @XmlAttribute
    public String getRel() {
        return rel;
    }

    @XmlAttribute
    public String getHref() {
        return href;
    }
}

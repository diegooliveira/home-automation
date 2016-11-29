package edu.homeauto.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement
public class ListResponse {

    private Collection<Link> links = new ArrayList<>();

    public void add(Link link) {
        links.add(link);
    }

    @XmlElementWrapper(name = "links")
    @XmlElement(name = "link")
    public Collection<Link> getLinks() {
        return links;
    }
}

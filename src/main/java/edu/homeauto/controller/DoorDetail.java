package edu.homeauto.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="door")
public class DoorDetail {

    private int id;
    private DoorStatus status;

    public DoorDetail() {}

    public DoorDetail(int id) {
        this.id = id;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    @XmlElement
    public DoorStatus getStatus() {
        return status;
    }

    public void setStatus(DoorStatus status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    private static enum DoorStatus {
        CLOSE,
        OPEN
    }

    @Override
    public String toString() {
        return "DoorDetail{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}

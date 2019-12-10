package org.oc.escalade.model;

import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ways")
public class Way {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wayId;
    private String name;
    private int length;
    private int nbOfLengths;
    private String quotation;

    @ManyToOne
    @JoinColumn(name = "sector_fk")
    private Sector sector;

    public int getWayId() {
        return wayId;
    }

    public void setWayId(int wayId) {
        this.wayId = wayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNbOfLengths() {
        return nbOfLengths;
    }

    public void setNbOfLengths(int nbOfLengths) {
        this.nbOfLengths = nbOfLengths;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

}

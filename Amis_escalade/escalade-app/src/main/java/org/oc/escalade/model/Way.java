package org.oc.escalade.model;

import javax.persistence.*;

@Entity
@Table(name = "ways")
public class Way {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int length;
    private int nbOfLengths;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "sector_fk")
    private Sector sector;

    public int getId() {
        return id;
    }

    public void setId(int wayId) {
        this.id = id;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

}

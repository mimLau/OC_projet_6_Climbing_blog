package org.oc.escalade.model;

import javax.persistence.*;

@Entity
@Table(name = "ways")
public class Way {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long length;
    private int nbOfLengths;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "sector_fk")
    private Sector sector;

    public Long getId() {
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

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
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

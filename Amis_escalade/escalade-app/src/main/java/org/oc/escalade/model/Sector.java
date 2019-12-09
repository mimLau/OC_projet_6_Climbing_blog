package org.oc.escalade.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sectors")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sectorId;
    private String name;
    private int nbOfWays;

    @ManyToOne
    @JoinColumn(name="site_fk")
    private Site site;

    @OneToMany(mappedBy = "sector")
    private List<Way> ways;


    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbOfWays() {
        return nbOfWays;
    }

    public void setNbOfWays(int nbOfWays) {
        this.nbOfWays = nbOfWays;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<Way> getWays() {
        return ways;
    }

    public void setWays(List<Way> ways) {
        this.ways = ways;
    }
}

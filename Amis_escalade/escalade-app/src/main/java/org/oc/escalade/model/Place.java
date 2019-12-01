package org.oc.escalade.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "places")
public class Place {

    private long placeId;
    private String country;
    private String city;

    @OneToMany(mappedBy = "place")
    private List<Site> sites;
}

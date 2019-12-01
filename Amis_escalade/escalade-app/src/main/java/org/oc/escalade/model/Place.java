package org.oc.escalade.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long placeId;
    private String country;
    private String city;

    @OneToMany(mappedBy = "place")
    private List<Site> sites;
}

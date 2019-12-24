package org.oc.escalade.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Topo topo;

    @ManyToOne
    private User userRequest;

    @Enumerated(EnumType.STRING)
    private Status status;
}

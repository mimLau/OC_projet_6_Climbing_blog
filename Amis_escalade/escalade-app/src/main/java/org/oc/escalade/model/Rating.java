package org.oc.escalade.model;

public enum Rating {

    UN("1"),
    DEUX("2"),
    TROIS("3"),
    QUATREA("4a"),
    QAUTREB("4b"),
    QUATREC("4c"),
    CINQA("5a"),
    CINQB("5b"),
    CINQC("5c"),
    SIXA("6a"),
    SIXB("6b"),
    SIXC("6c"),
    SEPTA("7a"),
    SEPTB("7b"),
    SEPTC("7c"),
    HUITA("8a"),
    HUITB("8b"),
    HUITC("8c"),
    NEUFA("9a"),
    NEUFAPLUS("9a+"),
    NEUFB("9b"),
    NEUFBPLUS("9b+");

    private String value;

    Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

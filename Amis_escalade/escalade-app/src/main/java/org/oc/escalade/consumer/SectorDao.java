package org.oc.escalade.consumer;

import org.oc.escalade.model.Sector;

public interface SectorDao {

    Sector addSector(Sector sector);
    Sector findSectorById(Long id);
}

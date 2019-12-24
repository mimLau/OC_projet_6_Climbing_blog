package org.oc.escalade.consumers;

import org.oc.escalade.models.Topo;

import java.util.List;

public interface TopoDao {

    List<Topo> getAllToposByUserId( Long userId );
    List<Topo> getAllTopos();
    Topo addTopo( Topo topo );
    void updateTopoState( Long topoId, boolean borrowed );
}

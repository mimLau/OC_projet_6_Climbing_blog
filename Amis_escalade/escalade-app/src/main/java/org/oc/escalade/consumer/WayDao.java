package org.oc.escalade.consumer;

import org.oc.escalade.model.Way;

import java.util.List;

public interface WayDao {
    Way addWay(Way way);
    List<Way> getAllWays();
}

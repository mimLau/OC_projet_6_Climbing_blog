package org.oc.escalade.consumers;


import org.oc.escalade.models.Length;

public interface LengthDao {
    Length addLength(Length length);
    Length findLengthById(Long id);
}

package org.mum.edu.ea.service;

import org.mum.edu.ea.domain.Position;

import java.util.Collection;
import java.util.List;

/**
 * Created by Zamuna on 8/11/2017.
 */
public interface IPostJobService {
    public Position createPosition(Position position);
    public Position updatePosition(Position position);
    public void deletePosition(Long id,Position position);
    public Position getPosition(Long id);
    public List<Position> getAllPosition();

}

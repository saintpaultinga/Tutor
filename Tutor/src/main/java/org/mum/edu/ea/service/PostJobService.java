package org.mum.edu.ea.service;

import org.mum.edu.ea.domain.Category;
import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.PositionCategory;
import org.mum.edu.ea.repository.IPostJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Zamuna on 8/11/2017.
 */
@Service
public class PostJobService implements IPostJobService {

    @Autowired
    IPostJob postJobRepo;

    @Override
    @Transactional
    public Position createPosition(Position position) {
        Position position1 = postJobRepo.save(position);
        return position1;
    }

    @Override  @Transactional
    public Position updatePosition(Position position) {
        Position pos=postJobRepo.save(position);
        return pos;
    }

    @Override  @Transactional
    public void deletePosition(Long id, Position position) {
        postJobRepo.delete(id);
    }

    @Override  @Transactional
    public Position getPosition(Long id) {
        return postJobRepo.findOne(id);
    }

    @Override  @Transactional
    public List<Position> getAllPosition() {
        return postJobRepo.findAll();
    }
}

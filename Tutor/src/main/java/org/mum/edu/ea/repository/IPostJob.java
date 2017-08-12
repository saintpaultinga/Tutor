package org.mum.edu.ea.repository;

import org.mum.edu.ea.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Created by Zamuna on 8/11/2017.
 */
public interface IPostJob extends JpaRepository<Position,Long> {
}

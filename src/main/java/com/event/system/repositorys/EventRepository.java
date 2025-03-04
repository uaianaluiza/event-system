package com.event.system.repositorys;

import com.event.system.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAll();

    Event getById(Long id);

    Event getByName(String name);
}

package com.event.system.repositorys;

import com.event.system.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> getAll();

    Event getById(Long id);

    Event getByName(String name);
}

package com.event.system.v2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventV2Repository extends JpaRepository<EventV2, Long> {

    List<EventV2> findAll();

    EventV2 getById(Long id);

    EventV2 getByName(String name);
}

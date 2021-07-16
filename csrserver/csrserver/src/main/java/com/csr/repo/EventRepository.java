package com.csr.repo;

import com.csr.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByEventName(String eventName);

    Event findByEventId(Long eventId);


}

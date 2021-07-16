package com.csr.service;

import com.csr.model.Event;

public interface EventService {
    //Create Event
    public Event createEvent(Event event) throws Exception;
    //Get event
    public Event getEvent(Long eventId);
}

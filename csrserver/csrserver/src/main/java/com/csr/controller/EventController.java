package com.csr.controller;

import com.csr.model.Event;
import com.csr.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/add")
public class EventController {
    @Autowired
    private EventService eventService;

    //Create event
    @PostMapping("/")
    public Event createEvent(@RequestBody Event event) throws Exception {

        return this.eventService.createEvent(event);


    }
    //Get event
    @GetMapping("/{eventId}")
    public Event getEvent(@PathVariable("eventId") Long eventId)
    {
        return this.eventService.getEvent(eventId);
    }


}

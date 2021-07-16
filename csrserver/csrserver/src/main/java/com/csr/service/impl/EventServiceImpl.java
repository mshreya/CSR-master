package com.csr.service.impl;

import com.csr.model.Event;
import com.csr.repo.ActivityRepository;
import com.csr.repo.EventRepository;
import com.csr.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
    public class EventServiceImpl implements EventService {
        @Autowired
        private EventRepository eventRepository;
        @Autowired
        private ActivityRepository activityRepository;


    @Override
    public Event createEvent(Event event) throws Exception {

        Event local = this.eventRepository.findByEventName(event.getEventName());
        if(local!= null)
        {
            System.out.println("Event is already present");
            throw new Exception("Event already present");
        }
        else {
          /*  for(EventActivity ea:eventActivities) {
                activityRepository.save(ea.getActivity());
            }
            event.getEventActivities().addAll(eventActivities);*/
            local = this.eventRepository.save(event);
        }
        return local;
    }
//Getting event by id
    @Override
    public Event getEvent(Long  eventId) {
        return this.eventRepository.findByEventId(eventId);
    }
}



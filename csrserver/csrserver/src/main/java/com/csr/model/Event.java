package com.csr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.OneToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="events")


public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    private String eventName;
    private String description;
    private Long maxTeamSize;
  //  @OneToMany(mappedBy = "event")
   // private Activity activity;
    private String date;


    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "event")
    @JsonIgnore
    private Set<Activity>activities;



    public Event() {
    }

    public Event(Long eventId, String eventName, String description, Long maxTeamSize, String date) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.maxTeamSize = maxTeamSize;
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(Long maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



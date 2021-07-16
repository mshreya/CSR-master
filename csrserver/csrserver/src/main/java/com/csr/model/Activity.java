package com.csr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
    @Table(name="Activity")
public class Activity {

    //Take event name from event interface
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long activityId;
    private String activityName;
    private String activityDescription;
    private Long maxNumber;
    //   @ManyToOne(fetch = FetchType.EAGER)
    // private Event event;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


    public Activity() {
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Long getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Long maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}


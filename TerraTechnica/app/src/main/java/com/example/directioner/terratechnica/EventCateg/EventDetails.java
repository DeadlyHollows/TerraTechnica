package com.example.directioner.terratechnica.EventCateg;

/**
 * Created by Directioner on 2/12/2017.
 */

public class EventDetails {

    private String eventName;
    private String venue;
    private String time;
    private int day;  // Day or Day 2 or both ...
    private String eventImage; // Contains the image of the event ...

    private String eventIntro;
    private String eventDesc;
    private String eventRules;

    public void setEventIntro(String eventIntro) {
        this.eventIntro = eventIntro;
    }

    public String getEventRules() {
        return eventRules;
    }

    public void setEventRules(String eventRules) {
        this.eventRules = eventRules;
    }


    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventDetails() {
    }

    public EventDetails(String name, String venue, String time, int day, String image, String intro, String desc, String rules) {

        this.eventName = name;
        this.venue = venue;
        this.time = time;
        this.day = day;
        this.eventImage = image;
        this.eventDesc = desc;
        this.eventIntro = intro;
        this.eventRules = rules;

    }


    public String getEventIntro() {
        return eventIntro;
    }
}

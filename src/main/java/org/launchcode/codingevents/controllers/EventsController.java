package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping(value = "events")
public class EventsController {

//    private static ArrayList<String> events = new ArrayList<>();
    private static HashMap<String,String> events = new HashMap<>();

    public static void setEvents(HashMap<String, String> events) {
        EventsController.events = events;
    }

    public static HashMap<String, String> getEvents() {
        events.put("ECGC", "East Coast Gaming Conference");
        events.put("GameJam", "Groups of participants are given 49 hours to create a game based on a theme");
        events.put("CodeJam","Put your coding skills to the test as you work your way through multiple rounds of algorithmic coding puzzles for the title of Code Jam Champ and $15,000 USD.");
        return events;
    }
    // Lives at /events
    @GetMapping("")
    public String displayAllEvents(Model model) {

        model.addAttribute("events", getEvents());
        model.addAttribute("title", "All Events");

        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create New Event");
        return "events/create";
    }

    // lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String event, @RequestParam String description) {
        events.put(event,description);
        return "redirect:";
    }


}

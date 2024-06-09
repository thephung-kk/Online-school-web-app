package com.phungnt.schoolwebapplication.controller;

import com.phungnt.schoolwebapplication.model.Holiday;
import com.phungnt.schoolwebapplication.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidaysController {

    @Autowired
    private HolidaysRepository holidaysRepository;
    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display,Model model) {
        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("federal")){
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festival",true);
        }
        Iterable<Holiday> holidays = holidaysRepository.findAll();
        List<Holiday> holidayList = StreamSupport
                .stream(holidays.spliterator(), false)
                .collect(Collectors.toList());
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidayList.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
//    List<Holiday> holidays = Arrays.asList(
//            new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
//            new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
//            new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
//            new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
//            new Holiday(" Sep 2 ", "Independence Day", Holiday.Type.FEDERAL),
//            new Holiday(" OCT 20 ", "Vietnamese Women's Day", Holiday.Type.FEDERAL),
//            new Holiday(" Nov 20 ", "Vietnamese Teacher's Day", Holiday.Type.FEDERAL)
//    );

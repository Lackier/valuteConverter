package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @RequestMapping(value = { "/convert" }, method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("sum", 0);
        return "convert";
    }

    @RequestMapping(value = { "/convert" }, method = RequestMethod.POST)
    public String convert(Model model, @RequestParam(value="sum", defaultValue="0") int sum,
                          @RequestParam(value="sumObtained", defaultValue="0") int sumObtained) {
        model.addAttribute("sumObtained", sum * 10);
        System.out.println(sum);
        return "convert";
    }

    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}

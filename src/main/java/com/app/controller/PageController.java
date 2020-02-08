package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @RequestMapping(value = {"/convert"}, method = RequestMethod.GET)
    public String show(Model model) {
        return "convert";
    }

    @RequestMapping(value = {"/convert"}, method = RequestMethod.POST)
    public String convert(Model model,
                          @RequestParam(value = "sum", required = false, defaultValue = "0") int sum) {

        if (sum != 0) {
            int sumObtained = sum * 10;
            model.addAttribute("sum", sum);
            model.addAttribute("sumObtained", sumObtained);
        }

        return "convert";
    }
}

package com.example.spwmvca01a1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IndexController {

    // Old style
    //@RequestMapping(path = "/index", method = RequestMethod.GET)
    @GetMapping("/index/{page}/category/{categoryName}/number/{pageNumber}")
    public String viewsIndex(
            @PathVariable String page,
            @PathVariable String categoryName,
            @PathVariable Integer pageNumber,
            @RequestParam (required = false, defaultValue = "")String query
    ){
        System.out.println("Page: " + page);
        System.out.println("CategoryName: " + categoryName);
        System.out.println("PageNumber: " + pageNumber);
        System.out.println("Query: " + query);
        return "index";
    }
}

package org.example.luyentap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String address)
    {
//        if(address==null)
//        {
//            address="";
//        }
         return "Hello World" +name +"-" +address;
    }
}

package org.example.luyentap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class DictionaryController {
    public static final Map<String,String> dictionary = new HashMap<String,String>();
     static {
         dictionary.put("word","thế giới");
         dictionary.put("hello","xinchao");

     }
     @RequestMapping("/dic")
    public String getTransation(@RequestParam(defaultValue = "") String text) {
      String translation = dictionary.get(text.trim().toLowerCase());
      if (translation == null) {
          return "Khôngtimfm thay ban ghi";

      }
      return translation;
    }
}

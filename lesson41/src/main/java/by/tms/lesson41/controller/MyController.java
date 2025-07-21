package by.tms.lesson41.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @Value("${app.bet.min:15}")
    private Integer min;
    @Value("${app.bet.max}")
    private Integer max;

    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @GetMapping
    public String test(){
        log.info("The meaning of properties: min = {}, max = {}" , min, max);
        return "test";
    }
}

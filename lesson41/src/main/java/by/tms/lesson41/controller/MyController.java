package by.tms.lesson41.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MyController {

    @Value("${app.bet.min:15}")
    private Integer min;
    @Value("${app.bet.max}")
    private Integer max;

    @GetMapping
    public String test(){
        log.info("The meaning of properties: min = {}, max = {}" , min, max);
        return "test";
    }
}

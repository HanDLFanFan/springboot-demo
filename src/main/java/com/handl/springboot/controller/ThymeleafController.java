package com.handl.springboot.controller;

import com.handl.springboot.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handl on 2017/8/24.
 */
@Controller
public class ThymeleafController {

    @RequestMapping("thymeleaf")
    public String thymeleaf(Model model){
        System.out.println("我来啦！！！");
        Person person = new Person("十二楼",16,"大唐");

        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("抬头看",17,"魔王");
        Person p2 = new Person("到处玩",18,"普陀");
        persons.add(p1);
        persons.add(p2);

        model.addAttribute("single",person);
        model.addAttribute("people",persons);

        return "thymeleaf";
    }

}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Spenser
 * @Date: 2018/6/15 16:08
 * @Description:
 */
@RestController
public class TT {

    @GetMapping("hello")
    public String Hello(){
        return "hello";
    }
}
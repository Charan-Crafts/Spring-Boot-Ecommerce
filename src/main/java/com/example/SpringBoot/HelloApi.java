package com.example.SpringBoot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @GetMapping("/api/hello")
    public String helloWorld(){
        return "Hello charan";
    }

    @PostMapping("/api/getName")
    public String getName(@RequestBody String name){
        System.out.println(name);
        return name;
    }
}

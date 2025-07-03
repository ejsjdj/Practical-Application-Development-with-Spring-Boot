package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String name() {
        return "Flature";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String variable1(@PathVariable String variable) {
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String variable2(@PathVariable("variable") String var) {
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=value&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String request1(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String request2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.forEach((key, value) -> sb.append(key + " : " + value + "\n"));

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String request3(MemberDto memberDto) {
        // return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }

}

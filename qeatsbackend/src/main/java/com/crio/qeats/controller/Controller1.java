package com.crio.qeats.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

  public String welcome() {
    return "Hello World";
  }
}
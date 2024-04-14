package org.maslov.nback.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {


  @GetMapping("/")
  public ModelAndView getIndex() {
    return new ModelAndView("index");
  }
}

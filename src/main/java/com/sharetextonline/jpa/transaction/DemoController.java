package com.sharetextonline.jpa.transaction;

import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoController {

  @Autowired
  private UserService userService;

  @Transactional
  @GetMapping("test")
  public String test(@RequestParam String name, @RequestParam Long sleep) {
    userService.insert(name,sleep);
    return "ok";
  }

  @Transactional
  @GetMapping("test2")
  public String test2(@RequestParam String name, @RequestParam Long sleep) {
    userService.insert2(name,sleep);
    return "ok";
  }


  @Transactional
  @GetMapping("list")
  public String list() {
    userService.list();
    return "ok";
  }


}

package com.rs1avanzadocontroladores.rs1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controllers {

  /*
  Example Request URL http://localhost:8080/user with JSON
  Post of the User and RES is the same User JSON
  Body: {"name":"Andrés","email":"andres@andres.com ", "age": 31 }
  */
  @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
  public User postUser(@RequestBody User user) {
    System.out.println("PostUser");
    return user;
  }
  /*
  Example Request URL http://localhost:8080/user/12345
  Response = Hi user n. 12345
   */
  @GetMapping("/user/{id}")
  // cambiar nombre de variable
  // public String getUserId(@PathVariable("id") String numberId)
  public String getUserId(@PathVariable String id) {
    System.out.println("getUser PathVariable");
    return "Hi user n. " + id;
  }
  /*
  Get id in Request Params
  Example Request URL http://localhost:8080/user?id=1234
  Res= Hi user n. 1234
   */
  @GetMapping("/user")
  public String getParamId(@RequestParam String id) {
    System.out.println("getUser RequestParam");
    return "Hi user n. " + id;
  }

  /*
  Put with various params
  Example Request URL http://localhost:8080/user/put?name=andres&age=31&city=madrid
  Res= Parameters: [name=andres, age=31, city=madrid]
   */
  @PutMapping("/user/put")
  public String putUser(@RequestParam Map<String, String> params) {
    System.out.println("putUser RequestParam");
    return "Parameters: " + params.entrySet();
  }
}

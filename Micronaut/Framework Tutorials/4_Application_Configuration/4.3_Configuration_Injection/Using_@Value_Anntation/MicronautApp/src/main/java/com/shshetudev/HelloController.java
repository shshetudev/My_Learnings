package com.shshetudev;

import io.micronaut.http.annotation.Controller;

// The controller' default path is : /hello
// to get the vale see: application.properties
@Controller("${hello.controller.path:/hello}")
public class HelloController {
}

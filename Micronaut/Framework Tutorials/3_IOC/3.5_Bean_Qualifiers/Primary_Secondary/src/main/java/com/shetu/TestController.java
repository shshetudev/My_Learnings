package com.shetu;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/testPrimary")
public class TestController {
  protected final ColorPicker colorPicker;

  public TestController(ColorPicker colorPicker) {
    this.colorPicker = colorPicker;
  }

  @Get
  public String index(){
    return colorPicker.color();
  }
}

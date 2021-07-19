package com.shshetudev.unittest.Overview;

public class CalcService {
  private AddService addService;

  public CalcService(AddService addService) {
    this.addService = addService;
  }
  public int calc(int num1, int num2){
    System.out.println("**___ CalcService calc executed ___**");
    return addService.add(num1, num2);
  }
}

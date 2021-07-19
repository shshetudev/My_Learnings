package com.shshetudev.unittest.Mockito_Inliner;

public class FooWithStatics {
  public static Long noParameters(){
    return System.currentTimeMillis();
  }
  public static String oneParameter(String param1){
    return param1.toUpperCase();
  }
}

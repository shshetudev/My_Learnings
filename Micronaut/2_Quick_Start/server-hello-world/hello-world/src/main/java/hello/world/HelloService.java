package hello.world;

import javax.inject.Singleton;

@Singleton
public class HelloService {

  public void hello(){
    System.out.println("Hello World");
  }
}

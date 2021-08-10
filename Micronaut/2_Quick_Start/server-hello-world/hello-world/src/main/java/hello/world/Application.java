package hello.world;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import javax.inject.Inject;

public class Application {
@Inject
private static HelloService helloService;
  public static void main(String[] args) {
    try (ApplicationContext context = ApplicationContext.run()) {
      HelloService hService = context.getBean(HelloService.class);
      hService.hello();
      // do something with your bean
    }
    Micronaut.run(Application.class, args);
  }
}

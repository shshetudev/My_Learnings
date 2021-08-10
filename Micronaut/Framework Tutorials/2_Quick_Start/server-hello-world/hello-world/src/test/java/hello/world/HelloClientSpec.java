package hello.world;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloClientSpec {

  @Inject
  private HelloClient client;

  @Test
  public void testHelloWorldResponse(){
    assertEquals("Hello World", client.hello().blockingGet());
  }

}

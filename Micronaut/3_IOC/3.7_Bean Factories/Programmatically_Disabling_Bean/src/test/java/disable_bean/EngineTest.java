package disable_bean;

import com.example.disable_bean.Engine;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@MicronautTest
public class EngineTest {
  @Inject
  Engine engine;
  private static final Logger LOG = LoggerFactory.getLogger(EngineTest.class);
}

package net.jgp.labs.java.lab100_hello_world;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloWorldAppTest {

  @Test
  void testStart() {
    HelloWorldApp app = new HelloWorldApp();
boolean status=    app.start(1);
assertEquals(true, status, "Should've been true");
  }

}

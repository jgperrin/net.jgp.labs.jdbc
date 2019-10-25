package net.jgp.labs.java.lab100_hello_world;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * What does it do?
 * 
 * @author jgp
 */
public class HelloWorldApp {
  private static final Logger log =
      LoggerFactory.getLogger(HelloWorldApp.class);

  /**
   * main() is your entry point to the application.
   * 
   * @param args
   */
  public static void main(String[] args) {
    HelloWorldApp app = new HelloWorldApp();
    app.start(args.length);
  }

  /**
   * The processing code.
   */
  protected boolean start(int argCount) {
    log.debug("-> start({})", argCount);
    return true;
  }
}

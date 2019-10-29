package net.jgp.labs.jdbc.lab400_metadata_dump;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.jgp.labs.jdbc.lab400_metadata_dump.MetadataDumpApp;

class MetadataDumpAppTest {

  @Test
  void testStart() {
    MetadataDumpApp app = new MetadataDumpApp();
boolean status=    app.start(1);
assertEquals(true, status, "Should've been true");
  }

}

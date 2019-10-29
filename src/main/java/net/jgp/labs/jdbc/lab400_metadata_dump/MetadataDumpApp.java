package net.jgp.labs.jdbc.lab400_metadata_dump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * What does it do?
 * 
 * @author jgp
 */
public class MetadataDumpApp {
  private static final Logger log =
      LoggerFactory.getLogger(MetadataDumpApp.class);

  /**
   * main() is your entry point to the application.
   * 
   * @param args
   */
  public static void main(String[] args) {
    MetadataDumpApp app = new MetadataDumpApp();
    app.start(0);
  }

  /**
   * The processing code.
   */
  protected boolean start(int argCount) {
    log.debug("-> start({})", argCount);

    String databaseURL =
        "jdbc:ucanaccess:///Users/jgp/Documents/Jean-Georges/Work/AAP/Projects/1909 B2C OCC/Data/AAIA_VCdb2009_Access2007_20190927/AAIA VCdb2009 Access2007 Complete VCDB 20190927.accdb";

    try {
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    } /* often not required for Java 6 and later (JDBC 4.x) */
    

    
    try (Connection connection = DriverManager.getConnection(databaseURL)) {

      
      String sql = "SELECT * FROM LegacyVehicle";

      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery(sql);

      while (result.next()) {
        int id = result.getInt("LegacyVehicleId");
        String make = result.getString("Make");
        String model = result.getString("Model");
        String submodel = result.getString("Submodel");

        System.out
            .println(id + ", " + make + ", " + model + ", " + submodel);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
    }

    return true;
  }
}

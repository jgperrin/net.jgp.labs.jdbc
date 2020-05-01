package net.jgp.labs.jdbc.lab400_postgresql_metadata_dump;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lists all tables in a specific database
 * 
 * @author jgp
 */
public class PostgresSqlListTablesApp {
	private static final Logger log = LoggerFactory.getLogger(PostgresSqlListTablesApp.class);

	/**
	 * main() is your entry point to the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PostgresSqlListTablesApp app = new PostgresSqlListTablesApp();
		app.start();
	}

	/**
	 * The processing code.
	 */
	protected boolean start() {
		log.debug("-> start()");

//		String database = "spark_labs";
		String database = "VCdb";
		String username = "postgres";
		String password = "Spark<3Java";
		String url = "jdbc:postgresql://localhost/";

		Connection connection;
		try {
			connection = DriverManager.getConnection(url + database, username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}

		DatabaseMetaData metadata;
		try {
			metadata = connection.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

		String[] types = { "TABLE", "VIEW" };

		ResultSet tablesRs;
		try {
			tablesRs = metadata.getTables(null, null, "%", types);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		try {
			while (tablesRs.next()) {
				log.info("Table/view name ... {}", tablesRs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return true;
	}
}

package website.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Pour une raison inconnu il faut préciser le package du controller

@SpringBootApplication(scanBasePackages = "website.controllers")
public class Main {

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);

		try
		{
			/* Register database jdbc driver class. */
			Class.forName("com.mysql.jdbc.Driver");

			/* Create database connection url. */
			String mysqlConnUrl = "jdbc:mysql://localhost:3306/cyberattacks";

			/* db user name. */
			String mysqlUserName = "root";

			/* db password. */
			String mysqlPassword = "";

			/* Get the Connection object. */
			Connection conn = null;
			conn = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);

			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();



			// Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
			String strSelect = "select name, id, location, industry  from company";
			System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging

			ResultSet rset = stmt.executeQuery(strSelect);

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			//  For each row, retrieve the contents of the cells with getXxx(columnName).
			System.out.println("The records selected are:");
			int rowCount = 0;
			while(rset.next()) {   // Move the cursor to the next row, return false if no more row
				String name = rset.getString("name");
				String location = rset.getString("location");
				String industry = rset.getString("industry");
				int    id   = rset.getInt("id");
				System.out.println(id + ", " + name + ", " + location +", "+ industry);
				++rowCount;
			}
			System.out.println("Total number of records = " + rowCount);


			System.out.print("Database is connected !");
			conn.close();

		}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:"+e);
		}

	}

}

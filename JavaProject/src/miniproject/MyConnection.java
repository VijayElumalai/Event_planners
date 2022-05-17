package miniproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
	static Connection con;
	public static Connection getMyConnection() throws FileNotFoundException, IOException, SQLException
	{
		if(con==null)
		{
			Properties p=new Properties();
			p.load(new FileInputStream(new File("C:\\Users\\VIJAY E\\eclipse-workspace\\Mini Java Project\\src\\miniproject\\db.properties")));
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			
			con=DriverManager.getConnection(url,username,password);
			return con;
		}
		else
		{
			return con;
			
		}
	}

}

import java.sql.*;  

class Test{  
public static void main(String args[]){  
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/BAYMAX","root","");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from patientdetails");  
		while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getInt(2));  
		con.close();  
	}catch(Exception e){ System.out.println(e);}  
}  
}  
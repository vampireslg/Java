import java.sql.*;

public class Code15_1{
    public static void main(String[] args){
	Connection con;
	Statement sql;
	ResultSet rs;
	try{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}catch (ClassNotFoundException e){
	    System.out.println(""+e);
	}

	try{
	    con = DriverManager.getConnection("jdbc:odbc:/home/gaoang/s.s", "","");
	    sql = con.createStatement();
	    rs = sql.executeQuery(" SELECT * FROM C");

	    con.close();
	}catch(SQLException e){}
    }
}
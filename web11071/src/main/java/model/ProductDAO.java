package model;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

//將連線資料庫的程式都放在這個位置
public class ProductDAO {
	 public ArrayList getProductList() {
	        //Mysql DB Connection URL
	        String url = "jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&characterEncoding=utf-8";
	        String username = "root";
	        String password = "1234";
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        ArrayList list = new ArrayList();
	String query = "SELECT productCode  as  code , quantityInStock  as  quantity, productDescription  as  description,  buyPrice  as  price  FROM  Products  where buyPrice>=90.0 "; 
	        try {    
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(url,username,password);
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                Product ur = new Product();
	                ur.setCode(rs.getString("code"));
	                ur.setQuantity(rs.getInt("quantity"));
	                ur.setDescription(rs.getString("description"));
	                ur.setPrice(rs.getString("price"));
	                list.add(ur);
	            }
	            rs.close();
	            conn.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return list;
	    }
	}

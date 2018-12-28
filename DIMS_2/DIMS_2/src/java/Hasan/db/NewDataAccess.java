/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hasan.db;


import Hasan.Models.Area;
import Hasan.Models.Depository;
import Hasan.Models.Employee;
import Hasan.Models.Job;
import Hasan.Models.Products;
import Hasan.Models.Retailer;
import Hasan.Models.type;
import Hasan.Models.orderproduct;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author samsung
 */
public class NewDataAccess 
{
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "hm";
    String password = "1234";

    Connection conn = null;
    public NewDataAccess()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

public Employee existanceOfUser(int userid,int password)
    {
        try
        {
            Employee employee_info = new Employee();
            String query = "select * from employee where employee_id = ? and password = ?";
            String query1 = "select job_title from job where job_id = ?";
            String query2 = "select area_name from area where area_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userid);
            stmt.setInt(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                employee_info.setEmployee_id(rs.getInt("employee_id"));
                employee_info.setJob_id(rs.getInt("job_id"));
                
                employee_info.setArea_id(rs.getInt("area_id"));
                employee_info.setJob_id(rs.getInt("job_id"));
               // employee_info.setManager_id(rs.getInt("manager_id"));
                employee_info.setFirst_name(rs.getString("first_name"));
                employee_info.setLast_name(rs.getString("last_name"));
                employee_info.setPassword(password);
                employee_info.setHire_date(rs.getString("hire_date"));
                employee_info.setSalary(rs.getInt("salary"));
                
                PreparedStatement stmt1 = conn.prepareStatement(query1);
                stmt1.setInt(1, employee_info.getJob_id());
                ResultSet rs1 = stmt1.executeQuery();
                if(rs1.next())employee_info.setJob_title(rs1.getString("job_title"));
                PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt2.setInt(1, employee_info.getArea_id());
                ResultSet rs2 = stmt2.executeQuery();
                if(rs2.next())employee_info.setArea_name(rs2.getString("area_name"));
                return employee_info;
            }
            return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
               
        
    }

    public int InsertEmployee(int job_id,int area_id,int manager_id,String first_name, String last_name, int password, int salary) {
        try
        {
            String query2 ="{? =call GenereteNewEmployee_ID}";
            CallableStatement statement = conn.prepareCall(query2);
            statement.registerOutParameter(1, java.sql.Types.INTEGER);  
            statement.execute();   
            int id = statement.getInt(1);  
            String query = "insert into employee(job_id,area_id,manager_id,first_name,last_name,password,salary,employee_id) values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1,job_id);
            stmt.setInt(2,area_id);
            stmt.setInt(3,manager_id);
            stmt.setString(4,first_name);
            stmt.setString(5,last_name);
            stmt.setInt(6,password);
            stmt.setInt(7,salary);
            stmt.setInt(8,id);
            int  rs = stmt.executeUpdate();
            if(rs!=0)
            {
                return id;
            }
            return -1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    
    public Vector<Depository> getDepository(int userid)
    {
        try{
            Vector<Depository> Depository_info = new Vector<Depository>(2);
            String query = "select * from depository where employee_id = ?";
            String query1 = "select product_name,price,type_id from product where product_id = ?";
            //String query2 = "select type_name from type where type_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,userid );
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Depository obj=new Depository();
                obj.setPRODUCT_ID(rs.getInt("product_id"));
                obj.setSTOCK_AMOUNT(rs.getInt("STOCK_AMOUNT"));
                PreparedStatement stmt1 = conn.prepareStatement(query1);
                //PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt1.setInt(1, obj.getPRODUCT_ID());
                ResultSet rs1 = stmt1.executeQuery();
                if(rs1.next()){
                    obj.setPRODUCT_NAME(rs1.getString("PRODUCT_NAME"));
                    obj.setPRICE(rs1.getInt("price"));
                    obj.setTYPE_ID(rs1.getInt("type_id"));
                }
                Depository_info.addElement(obj);
            }
            return Depository_info;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean UpdateDepository(int product_id,int employee_id, int quantity) {
        try
        {
            String query = "update depository set stock_amount = ? where employee_id = ? and product_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,quantity);
            stmt.setInt(2,employee_id);
            stmt.setInt(3,product_id);
           
            int  rs = stmt.executeUpdate();
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public Vector<Employee> getMPOList(int userid)
    {
        try{
            Vector<Employee> e=new Vector<Employee>(2);
            String query = "select * from employee where manager_id= ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,userid);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee a=new Employee();
                a.setEmployee_id(rs.getInt("employee_id"));
                a.setPassword(rs.getInt("password"));
                a.setFirst_name(rs.getString("first_name"));
                a.setLast_name(rs.getString("last_name"));
                a.setArea_id(rs.getInt("area_id"));
                a.setSalary(rs.getInt("salary"));
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
    }

    public Vector<orderproduct> getorderlist(int employee_id) {
        try{
            Vector<orderproduct> e=new Vector<orderproduct>(2);
            String query = "select * from orderproduct where employee_id = ?";
            String query1 = "select product_name,price from product where product_id = ?"; 
            String query2 = "select retailer_name from retailer where retailer_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,employee_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                orderproduct a=new orderproduct();
                a.setEMPLOYEE_ID(rs.getInt("employee_id"));
                a.setPRODUCT_ID(rs.getInt("product_id"));
                a.setQUANTITY(rs.getInt("quantity"));
                a.setRETAILER_ID(rs.getInt("retailer_id"));
                a.setORDER_DATE(rs.getString("order_date"));
                PreparedStatement stmt1 = conn.prepareStatement(query1);
                //PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt1.setInt(1, a.getPRODUCT_ID());
                ResultSet rs1 = stmt1.executeQuery();
                if(rs1.next()){
                    a.setProduct_name(rs1.getString("product_name"));
                    a.setPrice(rs1.getInt("price"));
                }
                PreparedStatement stmt2 = conn.prepareStatement(query2);
                //PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt2.setInt(1, a.getRETAILER_ID());
                ResultSet rs2 = stmt2.executeQuery();
                if(rs2.next()){
                    a.setRetailer_name(rs2.getString("retailer_name"));
                }
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Vector<Retailer> getRetailerList(int area_id) {
       try{
            Vector<Retailer> e=new Vector<Retailer>(2);
            String query = "select * from retailer where area_id= ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,area_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Retailer a=new Retailer();
                a.setArea_id(rs.getInt("area_id"));
                a.setRetailer_id(rs.getInt("retailer_id"));
                a.setRetailer_name(rs.getString("retailer_name"));
                a.setAddress(rs.getString("address"));
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Vector<Products> getProductList() {
         //To change body of generated methods, choose Tools | Templates.
         try{
            Vector<Products> e=new Vector<Products>(2);
            String query = "select * from Product";
            PreparedStatement stmt = conn.prepareStatement(query);
            //stmt.setInt(1,area_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Products a=new Products();
                a.setProduct_id(rs.getInt("product_id"));
                a.setProduct_name(rs.getString("product_name"));
                a.setPrice(rs.getInt("price"));
                a.setType_id(rs.getInt("type_id"));
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean UpdateOrderProduct(int employee_id, int retailer_id, int product_id, int quantity) {
       try
        {
            String query = "insert into orderproduct (retailer_id,employee_id,product_id,quantity) values(?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,retailer_id);
            stmt.setInt(2,employee_id);
            stmt.setInt(3,product_id);
            stmt.setInt(4,quantity);
            int  rs = stmt.executeUpdate();
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Vector<Retailer> getOrderRetailerlist(int employee_id) {
        try{
            Vector<Retailer> e=new Vector<Retailer>(2);
            String query = "select distinct retailer_id from orderproduct where employee_id= ?";
            String query2 = "select retailer_name from retailer where retailer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,employee_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Retailer a=new Retailer();
                a.setRetailer_id(rs.getInt("retailer_id"));
                PreparedStatement stmt2 = conn.prepareStatement(query2);
                //PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt2.setInt(1, a.getRetailer_id());
                ResultSet rs2 = stmt2.executeQuery();
                if(rs2.next()){
                    a.setRetailer_name(rs2.getString("retailer_name"));
                }
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean UpdateOrderProductList(int employee_id, int retailer_id, int product_id, int quantity) {
    try
        {
            String query = "update orderproduct set quantity = ? where employee_id = ? and retailer_id= ? and product_id=?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(3,retailer_id);
            stmt.setInt(2,employee_id);
            stmt.setInt(4,product_id);
            stmt.setInt(1,quantity);
            int  rs = stmt.executeUpdate();
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }   

    public Vector<orderproduct> getorderlist1(int employee_id, int retailer_id) {
        try{
            Vector<orderproduct> e=new Vector<orderproduct>(2);
            String query = "select * from orderproduct where employee_id = ? and retailer_id = ?";
            String query1 = "select product_name,price from product where product_id = ?"; 
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,employee_id);
            stmt.setInt(2,retailer_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                orderproduct a=new orderproduct();
                a.setEMPLOYEE_ID(rs.getInt("employee_id"));
                a.setPRODUCT_ID(rs.getInt("product_id"));
                a.setQUANTITY(rs.getInt("quantity"));
                a.setRETAILER_ID(rs.getInt("retailer_id"));
                a.setORDER_DATE(rs.getString("order_date"));
                a.setStatus(rs.getInt("status"));
                PreparedStatement stmt1 = conn.prepareStatement(query1);
                //PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt1.setInt(1, a.getPRODUCT_ID());
                ResultSet rs1 = stmt1.executeQuery();
                if(rs1.next()){
                    a.setProduct_name(rs1.getString("product_name"));
                    a.setPrice(rs1.getInt("price"));
                }
              
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean DeleteOrderProductList(int employee_id, int retailer_id , int product_id) {
        try{
            String query="delete from orderproduct where employee_id = ? and retailer_id = ? and product_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(2,retailer_id);
            stmt.setInt(1,employee_id);
            stmt.setInt(3,product_id);
            int  rs = stmt.executeUpdate();
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public int InsertEmployeeDM(int job_id, int area_id, String first_name, String last_name, int password, int salary) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            String query2 ="{? =call GenereteNewEmployee_ID}";
            CallableStatement statement = conn.prepareCall(query2);
            statement.registerOutParameter(1, java.sql.Types.INTEGER);  
            statement.execute();   
            int id = statement.getInt(1);       
            String query = "insert into employee (job_id,area_id,first_name,last_name,password,salary,employee_id) values(?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,job_id);
            stmt.setInt(2,area_id);
            //stmt.setInt(3,manager_id);
            stmt.setString(3,first_name);
            stmt.setString(4,last_name);
            stmt.setInt(5,password);
            stmt.setInt(6,salary);
            stmt.setInt(7,id);
            int  rs = stmt.executeUpdate(); 
            
            if(rs!=0)
            {
            String query1 ="{call Depository_Update(?)}";
            CallableStatement statement1 = conn.prepareCall(query1);
            statement1.setInt(1,id);  
            statement1.execute();   
                return id;
            }
            return -1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean InsertProduct(String product_name, int price, int type_id) {
      try{  //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     String query = "insert into product (product_name,price,type_id) values(?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,product_name);
            stmt.setInt(2,price);
            //stmt.setInt(3,manager_id);
            stmt.setInt(3,type_id);
            int  rs = stmt.executeUpdate(); 
            
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean UpdateProductTable(int product_id, String product_name, int price) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            String query = "update product set price = ?,product_name = ? where product_id=?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(3,product_id);
            stmt.setInt(1,price);
            stmt.setString(2,product_name);
            //stmt.setInt(1,quantity);
            int  rs = stmt.executeUpdate();
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Vector<Employee> getDMList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
            Vector<Employee> e=new Vector<Employee>(2);
            String query = "select * from employee where job_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            //stmt.setInt(1,userid);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Employee a=new Employee();
                a.setEmployee_id(rs.getInt("employee_id"));
                a.setPassword(rs.getInt("password"));
                a.setFirst_name(rs.getString("first_name"));
                a.setLast_name(rs.getString("last_name"));
                a.setArea_id(rs.getInt("area_id"));
                a.setSalary(rs.getInt("salary"));
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean UpdateDM(int employee_id, int password, String first_name, String last_name, int area_id, int salary) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try
        {
            String query = "update employee set password = ? ,salary = ? ,first_name = ? ,last_name = ?, area_id = ? where employee_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,password);
            stmt.setInt(2,salary);
            stmt.setString(3,first_name);
            stmt.setString(4,last_name);
            stmt.setInt(5,area_id);
            stmt.setInt(6,employee_id);
            //stmt.setInt(1,quantity);
            int  rs = stmt.executeUpdate();
            System.out.println(rs+"hi");
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    
    }

    public int InsertRetailer( String retailer_name, String address, int area_id)  {
     try{    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String query2 ="{? =call GenereteNewRetailer_ID}";
            CallableStatement statement = conn.prepareCall(query2);
            statement.registerOutParameter(1, java.sql.Types.INTEGER);  
            statement.execute();   
            int id = statement.getInt(1);       
         
         
            String query = "insert into retailer (retailer_id,retailer_name,address,area_id) values(?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.setString(2,retailer_name);
            stmt.setString(3,address);
            stmt.setInt(4,area_id);
            int  rs = stmt.executeUpdate(); 
            
            if(rs!=0)
            {
                return id;
            }
            return -1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    
    }

    public int InsertJob( String job_title) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
        
        String query2 ="{? =call GenereteNewJob_ID}";
            CallableStatement statement = conn.prepareCall(query2);
            statement.registerOutParameter(1, java.sql.Types.INTEGER);  
            statement.execute();   
            int id = statement.getInt(1);       
         
        String query = "insert into job (job_id,job_title) values(?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.setString(2,job_title);
            //stmt.setInt(3,type_id);
            int  rs = stmt.executeUpdate(); 
            
            if(rs!=0)
            {
                return id;
            }
            return -1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public int InsertArea( String area_name) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
        
        String query2 ="{? =call GenereteNewArea_ID}";
            CallableStatement statement = conn.prepareCall(query2);
            statement.registerOutParameter(1, java.sql.Types.INTEGER);  
            statement.execute();   
            int id = statement.getInt(1);       
         
        String query = "insert into area (area_id,area_name) values(?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.setString(2,area_name);
            //stmt.setInt(3,type_id);
            int  rs = stmt.executeUpdate(); 
            
            if(rs!=0)
            {
                return id;
            }
            return -1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    
    }

    public int InsertType(String type_name) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
        
        String query2 ="{? =call GenereteNewType_ID}";
            CallableStatement statement = conn.prepareCall(query2);
            statement.registerOutParameter(1, java.sql.Types.INTEGER);  
            statement.execute();   
            int id = statement.getInt(1);       
         
        String query = "insert into type (type_id,type_name) values(?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.setString(2,type_name);
            //stmt.setInt(3,type_id);
            int  rs = stmt.executeUpdate(); 
            
            if(rs!=0)
            {
                return id ;
            }
            return -1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    
    }

   

    public Vector<Job> getJobList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
            Vector<Job> e=new Vector<Job>(2);
            String query = "select * from job";
            PreparedStatement stmt = conn.prepareStatement(query);
            //stmt.setInt(1,userid);
            //stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Job a=new Job();
                a.setJob_id(rs.getInt("job_id"));
                
                a.setJob_title(rs.getString("job_title"));
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    
    }

    public Vector<Area> getAreaList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
            Vector<Area> e=new Vector<Area>(2);
            String query = "select * from area";
            PreparedStatement stmt = conn.prepareStatement(query);
            //stmt.setInt(1,userid);
            //stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Area a=new Area();
                a.setArea_id(rs.getInt("area_id"));
                
                a.setArea_name(rs.getString("area_name"));
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    
    }

    public Vector<type> getTypeList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
            Vector<type> e=new Vector<type>(2);
            String query = "select * from type";
            PreparedStatement stmt = conn.prepareStatement(query);
            //stmt.setInt(1,userid);
            //stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                type a=new type();
                a.setType_id(rs.getInt("type_id"));
                
                a.setType_name(rs.getString("type_name"));
                e.addElement(a);
            }
            return e;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    
    }

    public boolean UpdateStatusOrderProductList(int employee_id, int retailer_id, int product_id, int quantity, int status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try
        {
            String query = "update orderproduct set quantity = ?, status = ? where employee_id = ? and product_id = ? and retailer_id =?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,quantity);
            stmt.setInt(3,employee_id);
            stmt.setInt(4,product_id);
           stmt.setInt(2,status);
           stmt.setInt(5,retailer_id);
            int  rs = stmt.executeUpdate();
            if(rs!=0)
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    
    }

    

}
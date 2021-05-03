/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servlets.Employee;
import servlets.Products;
import servlets.Purchase;


/**
 *
 * @author ASUS
 */
public class DataAccess {
    String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "project";
    String password = "123";
    String firstName="";
    String lastName="";
    public boolean connect=true;
    Connection conn = null;
    public boolean insertProduct=true;
    PrintWriter pq = new PrintWriter("F:\\some.txt"); 
        
    public DataAccess()throws FileNotFoundException{
        PrintWriter ps = new PrintWriter("F:\\some.txt"); 
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) ps.write("Connection successfully hhhestablished.");
            else {ps.write("Could not establish connection");
            this.connect=false;
            }
            ps.flush();
            
        }
        catch(Exception e)
        {
            this.connect=false;
            ps.write("Functioning");
            e.printStackTrace(ps);
            ps.flush();
            ps.close();
            
        }
    }
    public DataAccess(String username,String password) throws FileNotFoundException
    {
        PrintWriter ps = new PrintWriter("F:\\some.txt"); 
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) ps.write("Connection successfully hhhestablished.");
            else {ps.write("Could not establish connection");
            this.connect=false;
            }
            ps.flush();
            
        }
        catch(Exception e)
        {
            this.connect=false;
            ps.write("Functioning");
            e.printStackTrace(ps);
            ps.flush();
            ps.close();
            
        }
    }
    public List<String> getEmployeeNames()
    {
        List<String> employeeNames = new ArrayList<String>();
        String selectStatement = "select first_name,last_name from employees";
        try
        {    
            PreparedStatement stmt=conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String name = first + " " + last;
                employeeNames.add(name);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return employeeNames;
    }
    
    public int createAccount(int productId, String CATEGORY, int PRICE, 
            String PRODUCT_NAME,int Quantity)
    {
        try
        {
            String insertCommand = "insert into product values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            stmt.setInt(1, productId);
            stmt.setString(2,CATEGORY);
            stmt.setInt(3, PRICE);
            stmt.setString(4,PRODUCT_NAME);
            stmt.setInt(5, Quantity);
            int count = stmt.executeUpdate();
            pq.write(count);
            pq.flush();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    
    public String getProductName(int productId){
           try
        {
            String insertCommand = "select product_name from product where PRODUCT_ID=?";
           //String insertCommand = "update product set price = ? where PRODUCT_ID=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            stmt.setInt(1,productId);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                String count=rs.getString("product_name");
                return count;
            }
            return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public int updateproductprice(int productId,int PRICE)
    {
        try
        {
            String insertCommand = "update product set PRICE = ? where PRODUCT_ID=?";
           //String insertCommand = "update product set price = ? where PRODUCT_ID=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            stmt.setInt(1, PRICE);
            stmt.setInt(2,productId);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int deleteemployee(int employeeId)
    {
        try
        {
            String insertCommand = "delete from employee where EMPLOYEE_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            stmt.setInt(1, employeeId);
            int count = stmt.executeUpdate();
            pq.write(count);
            pq.flush();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updateproductquantity(int productId,int quantity)
    {
        try
        {
            String insertCommand = "update product set QUANTITY = QUANTITY+ ? where PRODUCT_ID=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            stmt.setInt(1,quantity);
            stmt.setInt(2,productId);
            int count = stmt.executeUpdate();
            pq.write(count);
            pq.flush();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public List<Employee> viewEmployee(){
        List<Employee> result=new ArrayList<Employee>();
        
        String Command="select employee_id,name,address,to_char(join_date,'DD/MM/YYYY')PDATE,salary,phone from employee";
        try{
         PreparedStatement stmt=conn.prepareStatement(Command);
         ResultSet rs=stmt.executeQuery();
         while(rs.next()){
           int employeeId=rs.getInt("employee_id");
           String name=rs.getString("name");
           String address=rs.getString("address");
           String joinDate=rs.getString("PDATE");
           int salary=rs.getInt("salary");
           String phone=rs.getString("phone");
           Employee employee=new Employee(employeeId,name,address,joinDate,salary,phone);
           result.add(employee);
         }
            return result;
        }
            catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Products> viewProduct(){
        List<Products> result=new ArrayList<Products>();
        
        String Command="select product_id,category,price,product_name,quantity from product";
        try{
         PreparedStatement stmt=conn.prepareStatement(Command);
         ResultSet rs=stmt.executeQuery();
         while(rs.next()){
           int productId=rs.getInt("product_id");
           String category=rs.getString("category");
           int price=rs.getInt("price");
           String productName=rs.getString("product_name");
           int quantity=rs.getInt("quantity");
           Products product=new Products(productId,price,category,productName,quantity);
           result.add(product);
         }
            return result;
        }
            catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<String> getCategory(){
        List<String> result=new ArrayList<String>();
        String Command="select category from product";
        try{
            PreparedStatement stmt=conn.prepareStatement(Command);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                int done=1;
                String category=rs.getString("category");
                for(String x:result){
                    if(category.equalsIgnoreCase(x)==true){done=0; break;}
                }
                if(done==1) result.add(category);
            }
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public int getLatestCustomer(){
        try{
                String Command="select max(customer_id) e from customer";
                PreparedStatement stmt=conn.prepareStatement(Command);
                ResultSet rs=stmt.executeQuery();
                if(rs.next()){
                    int id=rs.getInt("e");
                    return id;
                }
                else return 0;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int getCustomer(String customerName){
        String Command="select customer_id from customer where name=?";
         try{
            PreparedStatement stmt=conn.prepareStatement(Command);
            stmt.setString(1,customerName);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                int id=rs.getInt("customer_id");
                return id;
            }
            else {
                return 0;
            }
         }
         catch(Exception e){
             e.printStackTrace();
             return 0;
         }
    
    }
    public int getSupplier(String supplierName){
         String Command="select supplier_id from supplier where name=?";
         try{
            PreparedStatement stmt=conn.prepareStatement(Command);
            stmt.setString(1,supplierName);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                int id=rs.getInt("supplier_id");
                return id;
            }
            else {
                return 0;
            }
         }
         catch(Exception e){
             e.printStackTrace();
             return 0;
         }
    }
    public int getLatestSupplier(){
        try{      
            int count=0;
            String check= "SELECT MAX(SUPPLIER_ID) E FROM SUPPLIER";
            PreparedStatement stmt1 = conn.prepareStatement(check);
            ResultSet s=stmt1.executeQuery();
                    if(s.next()){
                        count=s.getInt("E");
                        return count;
                    }
                    else return 0;
                    
        }
        catch(Exception e){
                    e.printStackTrace();
                    return 0;
        }
    }
    public int getProduct(String name){
        try{
            String Command="select product_id from product where product_name=?";
            PreparedStatement stmt=conn.prepareStatement(Command);
            stmt.setString(1,name);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                int id=rs.getInt("product_id");
                return id;
            }
            else return 0; 
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public List<Products> allProducts(){
         List<Products> result=new ArrayList<Products>();
         try{
        String Command="select product_id,category,price,product_name,quantity from product";
       
         PreparedStatement stmt=conn.prepareStatement(Command);
         ResultSet rs=stmt.executeQuery();
         while(rs.next()){
           int productId=rs.getInt("product_id");
           String category=rs.getString("category");
           int price=rs.getInt("price");
           String productName=rs.getString("product_name");
           int quantity=rs.getInt("quantity");
           Products product=new Products(productId,price,category,productName,quantity);
           result.add(product);
        }
            return result;
        }
            catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Products> searchProductWithCateogory(String Category){
         List<Products> result=new ArrayList<Products>();
            
        try{
        String Command="select product_id,category,price,product_name,quantity from product where category = ?";
       
         PreparedStatement stmt=conn.prepareStatement(Command);
         stmt.setString(1,Category);
         ResultSet rs=stmt.executeQuery();
         while(rs.next()){
           int productId=rs.getInt("product_id");
           String category=rs.getString("category");
           int price=rs.getInt("price");
           String productName=rs.getString("product_name");
           int quantity=rs.getInt("quantity");
           Products product=new Products(productId,price,category,productName,quantity);
           result.add(product);
        }
            return result;
        }
            catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Purchase> searchpurchase(String first_date,String second_date){
         List<Purchase> result=new ArrayList<Purchase>();
            
        try{
        String Command="select purchase_id, product_id,pquantity,to_char(purchase_date,'DD/MM/YYYY')PDATE,customer_id from purchase where purchase_date between ? and ?";       
         PreparedStatement stmt=conn.prepareStatement(Command);
         stmt.setDate(1,java.sql.Date.valueOf(first_date));
         stmt.setDate(2,java.sql.Date.valueOf(second_date));
         ResultSet rs=stmt.executeQuery();
         while(rs.next()){
           int purchaseId=rs.getInt("purchase_id");
           int productId=rs.getInt("product_id");
           int quantity=rs.getInt("pquantity");
           String purchaseDate=rs.getString("PDATE");
           int customerId=rs.getInt("customer_id");
           Purchase row=new Purchase(purchaseId,productId,quantity,purchaseDate,customerId);
           result.add(row);
        }
            return result;
        }
            catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public int getLatestProduct(){
        try{      
            int count=0;
            String check= "SELECT MAX(PRODUCT_ID) E FROM PRODUCT";
            PreparedStatement stmt1 = conn.prepareStatement(check);
            ResultSet s=stmt1.executeQuery();
                    if(s.next()){
                        count=s.getInt("E");
                        return count;
                    }
                    else return 0;
                    
        }
        catch(Exception e){
                    e.printStackTrace();
                    return 0;
        }
    }
    public int getLatestPurchase(){
        try{      
            int count=0;
            String check= "SELECT MAX(PURCHASE_ID) E FROM PURCHASE";
            PreparedStatement stmt1 = conn.prepareStatement(check);
            ResultSet s=stmt1.executeQuery();
                    if(s.next()){
                        count=s.getInt("E");
                        return count;
                    }
                    else return 0;
                    
        }
        catch(Exception e){
                    e.printStackTrace();
                    return 0;
        }
    }
     public int getLatestEmployee(){
        try{      
            int count=0;
            String check= "SELECT MAX(EMPLOYEE_ID) E FROM EMPLOYEE";
            PreparedStatement stmt1 = conn.prepareStatement(check);
            ResultSet s=stmt1.executeQuery();
                    if(s.next()){
                        count=s.getInt(1);
                        return count;
                    }
                    else return 0;
                    
        }
        catch(Exception e){
                    e.printStackTrace();
                    return 0;
        }
    }
     
    public int CreatePurchase(int purchaseId,int productId,int quantity,String purchaseDate,int customerId)
            {
                try{
                    String check= "select quantity from product where product_id = ?";
                    PreparedStatement stmt1 = conn.prepareStatement(check);
                    stmt1.setInt(1,productId);
                    ResultSet s = stmt1.executeQuery();
                    if(s.next()){
                        int q = s.getInt("quantity");
                        if(q<quantity){return 0;}
                    }
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                
                
        try{
        String InsertCommand="insert into purchase values(?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(InsertCommand);
        stmt.setInt(1,purchaseId);
        stmt.setInt(2,productId);
        stmt.setInt(3,quantity);
        stmt.setDate(4,java.sql.Date.valueOf(purchaseDate));
        stmt.setInt(5,customerId);
        int count=stmt.executeUpdate();
       // pq.write(count);
      //  pq.flush();
        return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
            }
        public int CreateSupplier(int supplierId,String name,String location,int branchId,int productId)
         {
        try{
        String InsertCommand="insert into supplier values(?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(InsertCommand);
        stmt.setInt(1,supplierId);
        stmt.setString(2,name);
        stmt.setString(3,location);
        stmt.setInt(4,branchId);
        stmt.setInt(5,productId);
        int count=stmt.executeUpdate();
        return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        }
        public int getamount(String first_date,String second_date){
            try{
                int count=5;
                String command= "select sum(p1.pquantity*p2.price) total from purchase p1 join product p2 on(p1.product_id=p2.product_id) where p1.purchase_date between ? and ?";
                PreparedStatement stmt=conn.prepareStatement(command);
                stmt.setDate(1,java.sql.Date.valueOf(first_date));
                stmt.setDate(2,java.sql.Date.valueOf(second_date));
                ResultSet rs=stmt.executeQuery();
                while(rs.next()){
                    count = rs.getInt("total");
                }
                return count;
            }
            catch(Exception e){
            e.printStackTrace();
            return 0;
            }
        }
    
    /*
    public static void main(String args[]){
        DataAccess db=new DataAccess();
        //        db.createAccount(firstName, lastName, username, password);

    }
   */
    public boolean existUser(String username,String password)
    {
        try
        {
            String query = "select * from account where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
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
    public int insertCustomer(int customerId, String name,String phone,String email,String address){
        try{
            
        String InsertCommand="insert into customer values(?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(InsertCommand);
        stmt.setInt(1,customerId);
        stmt.setString(2,name);
        stmt.setString(3,phone);
        stmt.setString(4,email);
        stmt.setString(5,address);
         int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        
    }
    public int insertEmployee(int employeeId,String name,String address,String joinDate,int salary,String phone){
        try{
        String InsertCommand="insert into employee values(?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(InsertCommand);
        stmt.setInt(1,employeeId);
        stmt.setString(2,name);
        stmt.setString(3,address);
        stmt.setDate(4,java.sql.Date.valueOf(joinDate));
        stmt.setInt(5,salary);
        stmt.setString(6,phone);
         int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean LoginUser(String username,String password){
        return true;
    }
    
/*
//Call function sample:
    
    String sql = "{ ? = call FUNCT_PERSON(?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/
    
 /*
    String sql = "{ call PROC_PERSON(?,?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/ 
}

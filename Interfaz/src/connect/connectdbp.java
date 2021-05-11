/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author andres
 */
public class connectdbp {
 

   public static DefaultTableModel showAuthors()throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        
        
        String data [] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Name");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_author.show_authors()}");



        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        ResultSet r =(ResultSet) stmt.getObject(1);
        while(r.next()){
                 
               data [0] = r.getString("id_author");
               data [1] = r.getString("name");
                 
                
                 
                 modelo.addRow(data);
             
                 
                
                 
                 
             }
        

        return modelo;
   }
    public static String getPassword(String pusername)throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_person.getPersonPassword(?)}");
        
         stmt.registerOutParameter(1, OracleTypes.VARCHAR);
         stmt.setString(2,pusername);
         stmt.execute();
         String r = (String) stmt.getString(1);
         System.out.println(r);
         return r;
        
    }
    
        public static String encryptPassword(String ppassword)throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_person.PasswordEncryption(?)}");
        
         stmt.registerOutParameter(1, OracleTypes.VARCHAR);
         stmt.setString(2,ppassword);
         stmt.execute();
         String r = (String) stmt.getString(1);
         System.out.println(r);
         return r;
        
    }
    
    public static void InsertUser(Integer pid, String pname, String plastName, String pbirthdate, String pemail,String pusername, String ppassword)throws SQLException, ParseException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{= call control_person.insert_user(?,?,?,?,?,?,?)}");
         stmt.setInt(1,pid);
         stmt.setString(2,pname);
         stmt.setString(3,plastName);
         stmt.setString(4,pbirthdate);
         stmt.setString(5,pemail);
         stmt.setString(6,pusername);
         stmt.setString(7,ppassword);
         stmt.execute();
    }
    
    public static void InsertAuthor(String pname)throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{= call control_author.insert_author(?)}");
         stmt.setString(1,pname);
    
         stmt.execute();
    }
    
        public static void UpdateAuthor(int pid,String pname)throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{= call control_author.update_author_name(?,?)}");
         stmt.setInt(1,pid);
         stmt.setString(2,pname);
         
        
    
         stmt.execute();
    }
        
        public static void DeleteAuthor(int pid)throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{= call control_author.remove_author(?)}");
         stmt.setInt(1,pid);
         
        
    
         stmt.execute();
    }
    
        public static DefaultTableModel showCalification()throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        
        
        String data [] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Score");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_calification.show_calification()}");



        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        ResultSet r =(ResultSet) stmt.getObject(1);
        while(r.next()){
                 
               data [0] = r.getString("id_calification");
               data [1] = r.getString("score");
                 
                
                 
                 modelo.addRow(data);
             
                 
                
                 
                 
             }
        

        return modelo;
    }
        
    
        public static DefaultTableModel showEditorial()throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        
        
        String data [] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Editorial");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_editorial.show_editorial()}");



        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        ResultSet r =(ResultSet) stmt.getObject(1);
        while(r.next()){
                 
               data [0] = r.getString("id_editorial");
               data [1] = r.getString("description");
                 
                
                 
                 modelo.addRow(data);
             
                 
                
                 
                 
             }
        

        return modelo;
    }
        
        
        
       public static DefaultTableModel showgenre()throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        
        
        String data [] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Genre");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_genre.show_genre()}");



        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        ResultSet r =(ResultSet) stmt.getObject(1);
        while(r.next()){
                 
               data [0] = r.getString("id_genre");
               data [1] = r.getString("description");
               System.out.println(r.getString("id_genre")); 
               System.out.println(r.getString("description"));

                 
                
                 
                 modelo.addRow(data);
             
                 
                
                 
                 
             }
        

        return modelo;
    }
       
        public static DefaultTableModel showphone()throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        
        
        String data [] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Phone");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_phone.show_phone()}");



        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        ResultSet r =(ResultSet) stmt.getObject(1);
        while(r.next()){
                 
               data [0] = r.getString("id_phone");
               data [1] = r.getString("phone_number");
                 
                
                 
                 modelo.addRow(data);
             
                 
                
                 
                 
             }
        

        return modelo;
    }
        
        
        
    public static DefaultTableModel showrelationship()throws SQLException{   
        String host = "jdbc:oracle:thin:@localhost:1521:dbp";
        String uName = "PE";
        String uPass = "PE";
        
        
        String data [] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("relationship");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmt = con.prepareCall("{ ?= call control_phone.show_phone()}");



        stmt.registerOutParameter(1, OracleTypes.CURSOR);
        stmt.executeQuery();
        ResultSet r =(ResultSet) stmt.getObject(1);
        while(r.next()){
                 
               data [0] = r.getString("id_relationship");
               data [1] = r.getString("description");
                 
                
                 
                 modelo.addRow(data);
             
                 
                
                 
                 
             }
        

        return modelo;
    }
 }
   
   
   
    


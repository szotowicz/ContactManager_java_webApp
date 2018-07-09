/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikołaj
 */
@Stateless
public class ContactListDAO {

    private String host = "jdbc:derby://localhost:1527/ContactManagerDB";
    private String user = "root";
    private String pass = "root";
    private DataSource dataSource;
    
    public int getSize(){
        int id = 0;
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            
            //index calculation
            String sql = "SELECT * FROM CONTACTLIST";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            
            try {   
                while (rs.next()) {
                    id++;                    
                }
            } catch (SQLException ex) {
                System.err.println(">>>" + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.err.println(">>>getSize>>>"+ex.getMessage());
        }
        return id;
    }
    
    public void addContact(Person person){
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            int id = getSize();
            
            String sql = "INSERT INTO CONTACTLIST VALUES("+(id+1)+", '"+person.getEmailOwner()+"', '"+person.getName()+"', '"
                    +person.getLastName()+"', '"+person.getEmail()+"', '"+person.getCategory()+"', '"
                    +person.getSubcategory()+"', '"+person.getPhoneNumber()+"', '"+person.getBirthDate()+"')";
            
            connection.createStatement().execute(sql);
            connection.close();
        } catch (SQLException ex) {
            System.err.println(">>>addContact>>>"+ex.getMessage());
        }
    }
    
    public void editContact(Person person){
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            
            String sql = "UPDATE CONTACTLIST SET NAME='"+person.getName()+"', LASTNAME='"+person.getLastName()
                    +"', EMAIL='"+person.getEmail()+"', CATEGORY='"+person.getCategory()
                    +"', SUBCATEGORY='"+person.getSubcategory()+"', PHONENUMBER='"+person.getPhoneNumber()
                    +"', BIRTHDATE='"+person.getBirthDate()+"' WHERE IDCONTACT="+person.getIdContact();
            
            connection.createStatement().execute(sql);
            
            connection.close();
        } catch (SQLException ex) {
            System.err.println(">>>editContact>>>"+ex.getMessage());
        }
    }
    
    public void deleteContact(Person person){
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            String sql = "DELETE FROM CONTACTLIST WHERE IDCONTACT="+person.getIdContact();
        
            connection.createStatement().execute(sql);
            System.err.println(">>>delet>>>"+sql);

              //set the correct id person.getIdContact()
            sql = "UPDATE CONTACTLIST SET IDCONTACT="+person.getIdContact()+" WHERE IDCONTACT="+(getSize()+1);
            connection.createStatement().execute(sql);
            System.err.println(">>>poprawa>>>"+sql);
            
            connection.close();
        } catch (SQLException ex) {
            System.err.println(">>>editContact>>>"+ex.getMessage());
        }
    }
    
    public Person getContact(int id){
        
        Person person = new Person();
        
        try { 
            Connection connection = DriverManager.getConnection(host, user, pass);
            
            String sql = "SELECT * FROM CONTACTLIST WHERE IDCONTACT="+id;
            ResultSet rs = connection.createStatement().executeQuery(sql);
            try {
                if(rs.next()){
                    person.setIdContact(rs.getInt("IDCONTACT"));
                    person.setEmailOwner(rs.getString("EMAILOWNER"));
                    person.setName(rs.getString("NAME"));
                    person.setLastName(rs.getString("LASTNAME"));
                    person.setEmail(rs.getString("EMAIL"));
                    person.setCategory(rs.getString("CATEGORY"));
                    person.setSubcategory(rs.getString("SUBCATEGORY"));
                    person.setPhoneNumber(rs.getString("PHONENUMBER"));
                    person.setBirthDate(rs.getString("BIRTHDATE"));
                }
            } catch (SQLException ex) {
                System.err.println(">>>"+ex.getMessage());
            }
            
            connection.close();
            
        } catch (SQLException ex) {
            System.err.println(">>>"+ex.getMessage());
        }
        
        return person;
        
    }
    
    public ArrayList<Person> getAllContacts(String owner){
        ArrayList<Person> contactList = new ArrayList<Person>();
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            String sql = "SELECT * FROM CONTACTLIST WHERE EMAILOWNER='"+owner+"'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            
            try {
                while (rs.next()) {
                    Person person = new Person();
                    person.setIdContact(rs.getInt("IDCONTACT"));
                    person.setEmailOwner(rs.getString("EMAILOWNER"));
                    person.setName(rs.getString("NAME"));
                    person.setLastName(rs.getString("LASTNAME"));
                    person.setEmail(rs.getString("EMAIL"));
                    person.setCategory(rs.getString("CATEGORY"));
                    person.setSubcategory(rs.getString("SUBCATEGORY"));
                    person.setPhoneNumber(rs.getString("PHONENUMBER"));
                    person.setBirthDate(rs.getString("BIRTHDATE"));

                    contactList.add(person);
                }
            } catch (SQLException ex) {
                System.err.println(">>>" + ex.getMessage());
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println(">>>"+ex.getMessage());
        }
        
        return contactList;
        
    }
    
    public ArrayList<User> getAllUsers(){
        ResultSet resultSet = null;
        ArrayList<User> usersList = new ArrayList<User>();
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            resultSet = connection.createStatement().executeQuery("SELECT * FROM USERS");
            try {
                while (resultSet.next()) {
                    User user = new User();
                    user.setEmail(resultSet.getString("EMAIL"));
                    user.setName(resultSet.getString("NAME"));
                    user.setLastName(resultSet.getString("LASTNAME"));
                    user.setPassword(resultSet.getString("PASSWORD"));

                    usersList.add(user);
                }
            } catch (SQLException ex) {
                System.err.println(">>>" + ex.getMessage());
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println(">>>"+ex.getMessage());
        }
        
        return usersList;
    }
    
    public void addUser(User newUser){
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            connection.createStatement().execute("INSERT INTO USERS VALUES('"+newUser.getEmail()+"', '"
                         +newUser.getName()+"', '"+newUser.getLastName()+"', '"+newUser.getPassword()+"')");
            
            connection.close();
        } catch (SQLException ex) {
            System.err.println(">>>"+ex.getMessage());
        }
        
    }
    
    public int signIn(User u){
        try {
            Connection connection = DriverManager.getConnection(host, user, pass);
            String sql = "SELECT * FROM USERS WHERE EMAIL='"
                    +u.getEmail()+"' AND PASSWORD='"+u.getPassword()+"'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            
            if(rs.next()){
                if(u.getEmail().equals(rs.getString("EMAIL")))
                    return 1;
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println(">>>"+ex.getMessage());
        }
        return 0;
    }
    
    
    
}

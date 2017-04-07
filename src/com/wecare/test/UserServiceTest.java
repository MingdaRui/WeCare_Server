package com.wecare.test;

import static org.junit.Assert.assertEquals;

import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.client.FindIterable;
import com.wecare.model.user.Admin;
import com.wecare.model.user.Users;
import com.wecare.model.userservice.AdminService;
import com.wecare.model.userservice.CustomerService;
import com.wecare.model.userservice.UserService;

public class UserServiceTest {

	UserService instance;
	AdminService adminInstance;
	
	 public UserServiceTest() {
		instance = new UserService();
		adminInstance = new AdminService();
	 }
	
	 
	@BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
	 
	
	@Before
    public void setUp() {
        instance = new CustomerService();
    }

    @After
    public void tearDown() {
        instance = null;
    }
    
    @Test
    public void test0() {

    	Users admin = new Users("test5", "test123445");
    	
    	Document newdoc = adminInstance.insert(admin);
    	boolean expResult = true;
    	boolean result = false;
    	if(newdoc != null){
    		result = true;
    	}
    	
        assertEquals(expResult, result);	
    }
    
    @Test
    public void test1() {

    	Admin admin = new Admin("test5", "test123445");
    	
    	Document newdoc = adminInstance.insert(admin);
    	boolean expResult = true;
    	boolean result = false;
    	if(newdoc == null){
    		result = true;
    	}
    	
        assertEquals(expResult, result);	
    }
    
    /**
     * Test of findUserByUsernamePassword method
     */
    @Test
    public void test2() {
        boolean expResult = true;
       
        Document document = instance.findUserByUsernamePassword("test5","test123445","admin");
        boolean result = false;
        if(document != null){
    		result = true;
    	}
        assertEquals(expResult, result);
    }

    @Test
    public void test3() {
        boolean expResult = false;
       
        Document document = instance.findUserByUsernamePassword("gyhgjh","test123445","admin");
        boolean result = false;
        if(document != null){
    		result = false;
    	}
        assertEquals(expResult, result);
    }
    @Test
    public void test4() {
    	boolean expResult = true;
       
    	FindIterable<Document> docs = instance.searchByUsers("admin");
    	boolean result = false;
        if(docs != null){
    		result = true;
    	}
        assertEquals(expResult, result);
    }

  

}

package com.wecare.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wecare.model.user.Customer;
import com.wecare.model.userservice.CustomerService;
import com.wecare.util.DateUtil;

public class CustomerServiceTest {
	CustomerService instance;
	Customer customer = new Customer();
	Customer customer2 = null;
	
	 public CustomerServiceTest() {
		 initValue();
	 }
	
	 public void initValue(){
		 customer2 = new Customer("test2", "test", "test@gmail.com", "40", "f", DateUtil.getConvertStringToDate("1991-01-01"), "Ireland", 170,50,45,0.5); 
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
    
    /**
     * Test of checkEmptyUsernamePassword method, of class CustomerService.
     */
    @Test
    public void testcheckEmpty_inUsernameEmptyValue() {
        boolean expResult = true;
        customer.setUsername("");
        customer.setPassword("test");
        customer.setEmail("test");
        
        boolean result = instance.checkEmptyUsernamePassword(customer);
        assertEquals(expResult, result);
    }

    @Test
    public void testcheckEmpty_inPasswordEmptyValue() {
    	boolean expResult = true;
        customer.setUsername("test");
        customer.setPassword("");
        customer.setEmail("test");
        
        boolean result = instance.checkEmptyUsernamePassword(customer);
        assertEquals(expResult, result);
    }

    @Test
    public void testcheckEmpty_inEmailEmptyValue() {
    	boolean expResult = true;
        customer.setUsername("test");
        customer.setPassword("test");
        customer.setEmail("");
        
        boolean result = instance.checkEmptyUsernamePassword(customer);
        assertEquals(expResult, result);
    }

    @Test
    public void testcheckEmpty_inFullValue() {
    	boolean expResult = false;
        customer.setUsername("test");
        customer.setPassword("test");
        customer.setEmail("test");
        
        boolean result = instance.checkEmptyUsernamePassword(customer);
        assertEquals(expResult, result);
    }
    /**
     * Test of insert method, of class CustomerService.
     */
    @Test
    public void testInsert_inFullValue() {
    	boolean expResult = true;
    	boolean result = false;
        Document doc = instance.insert(customer2);
        if(doc != null){
        	result = true;
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInsert_inExistingUsernameCase() {
        Document result = instance.insert(customer2);
        assertEquals(null, result);
    }
    

}

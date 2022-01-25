/*
 * package application;
 

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class THAppTest {
	Model model=new Model(); //Instantiate model class
	String username="abc123"; //used for testAddUserName()
	//item and quantity are used to test testAddItem(), testGetNumberOfItemsInventory(), and testSubtractItem()
	String item="paper";
	String quantity ="5";
	
	//signify the beginning of the test
	@BeforeClass
	public static void setupClass() throws Exception {
		System.out.println("Before the class");
	}
	
	//signify the end of the test
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("After the class");
	}
	
	//Open the data file to read the data first and store the data into hashmap from Model class
	@Before
	public void setUp() throws Exception {
		model.properties.load(new FileInputStream("data.properties"));
		for(Object key: model.properties.stringPropertyNames()){
			model.h.put((String) key, model.properties.get(key).toString());
			}
		}
	
	//test string to string
	@Test()
	public void testAddItem() throws FileNotFoundException, IOException {
		assertEquals("Item: "+ item+" has been added", model.addItem(item, quantity));
		System.out.println("testAddItem() is successfully executed");
	}
	
	//test string to string
	@Test()
	public void testGetNumberOfItemsnInventory() throws FileNotFoundException, IOException {
		assertEquals("Item: "+item+"\t\tQuantity: "+ model.h.get(item), model.getNumberOfItemsInventory(item));
		System.out.println("testGetNumberOfItemsInventory() is successfully executed");
		
	}
	
	//test string to string
	@Test()
	public void testSubtractItem() throws FileNotFoundException, IOException {
		assertEquals("Item "+item+" has been removed", model.subtractItem(item, quantity));
		System.out.println("testSubtractItem() is successfully executed");
	}
	
	//test true or false value
	@Test
	public void testAddUserName() {
		assertTrue(model.addUserName(username));
		System.out.println("testAddUserName() is successfully executed");
	}

	//print "Done" after each successful test
	@After 
	public void finish() {
		System.out.println("Done");
	}
	
	

}
*/

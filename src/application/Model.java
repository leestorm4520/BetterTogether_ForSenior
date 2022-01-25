package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Model extends User{
	
  private static HashMap<String, User> h=new HashMap<String, User>();
  private Properties properties=new Properties();
  File file= new File("data.properties");
  Alert a=new Alert(AlertType.NONE);
  
  
 //LogInController 
  public boolean userFormatValidation(String id, String password){
    Pattern p1=Pattern.compile("[a-zA-Z0-9]{8,15}");
    Matcher m1=p1.matcher(id);
    Pattern p2=Pattern.compile("[a-zA-Z0-9]{8,15}");                          
    Matcher m2=p2.matcher(password);
    
    if(!m1.find() || !m2.find()){
      a.setAlertType(AlertType.ERROR);
      a.setContentText("Either user id or password is not in the correct format");
      a.show();
     return false;
    }
    else return true;
  }
                               
  public boolean userExistenceValidation(String id, String password) throws IOException{
	  file.createNewFile();
    FileInputStream reader=new FileInputStream(file);
    properties.load(reader);
    reader.close();
    for(String object: properties.stringPropertyNames()){
      h.put(object, (User) properties.get(object));
    }
   
    if(h.containsKey(id) && password.equals(h.get(id).getPassword())){
    	a.setAlertType(AlertType.CONFIRMATION);
    	String string="Successfully signed in as "+id;
    	a.setContentText(string);
    	a.show();
    	return true;
    }
    else {
    	a.setAlertType(AlertType.ERROR);
    	a.setContentText("User id or password is inccorect");
    	a.show();
    	return false;
    }
    
  }
  
  public boolean userForgetPassword(String id, String perAnswer) throws IOException {
	  file.createNewFile();
	  FileInputStream reader=new FileInputStream(file);
	  properties.load(reader);
	  reader.close();
	  for(String object: properties.stringPropertyNames()){
	      h.put(object, (User) properties.get(object));
	  }
	  
	  if(perAnswer.equals(h.get(id).getPerAnswer())) return true;
	  else {
		  a.setAlertType(AlertType.WARNING);
	  	  a.setContentText("Incorrect! Please enter again!");
	  	  a.show();
	  	  return false;
  }
  
}
	  
public void changePassword(String id, String password) {
	
}
 
  
  //MenuController
  
  //CreatePostcontroller
public void writePost(String id, String post) throws IOException {
	FileInputStream reader=new FileInputStream(file);
	 properties.load(reader);
	  reader.close();
	  for(String object: properties.stringPropertyNames()){
	      h.put(object, (User) properties.get(object));
	  }
	  ArrayList previousComment=new ArrayList();
	  
	  h.get(id).posts.put(post, null);	  
	  
	  properties.putAll(h);
	  System.out.println(h);
		FileOutputStream writer= new FileOutputStream(file, true);
		properties.store(writer, null);
}



  
  
  //ReactPostController
public User ranUser() throws IOException{
	FileInputStream reader=new FileInputStream(file);
	 properties.load(reader);
	  reader.close();
	  for(String object: properties.stringPropertyNames()){
	      h.put(object, (User) properties.get(object));
	  }
		 ArrayList<String> keyAsArray= new ArrayList<String>(h.keySet());
		 Random r= new Random();
		return h.get(keyAsArray.get(r.nextInt(keyAsArray.size())));
	  
}

public String ranPost(User user) {
	ArrayList<String> keyAsArray= new ArrayList<String>(user.posts.keySet());
	Random r=new Random();
	return user.posts.get(keyAsArray.get(r.nextInt(keyAsArray.size())));
	}

public static <T, E> T getKeyByValue(Map<T, E> m, E value) {
    for (Entry<T, E> entry : m.entrySet()) {
        if (Objects.equals(value, entry.getValue())) {
            return entry.getKey();
        }
    }
    return null;
}

public void updateComment(String comment, String post, User user) throws IOException {
	FileInputStream reader=new FileInputStream(file);
	 properties.load(reader);
	  reader.close();
	  for(String object: properties.stringPropertyNames()){
	      h.put(object, (User) properties.get(object));
	  }

	h.get(user.getId()).posts.replace(post, user.posts.get(post), comment);
	properties.putAll(h);
	System.out.println(h);
	FileOutputStream writer= new FileOutputStream(file, true);
	properties.store(writer, null);

}
}


















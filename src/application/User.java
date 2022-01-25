package application;

import java.util.ArrayList;
import java.util.HashMap;

public class User{
  private String id;
  private String password;
  private String perQuestion;
  private String perAnswer;
  HashMap<String, String> posts=new HashMap<String, String>();
  
  
  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPerAnswer() {
	return perAnswer;
}
public void setPerAnswer(String perAnswer) {
	this.perAnswer = perAnswer;
}

public HashMap<String, String> getPosts() {
	return posts;
}
public void setPosts(HashMap<String, String> posts) {
	this.posts = posts;
}
}
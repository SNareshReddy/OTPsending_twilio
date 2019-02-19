package com.naresh.example.springbootrestapiandroid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	private long id;
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
   }
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
       public long getId() {
       return id;
   }
   
   
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void setId(long id) {
	this.id = id;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
}
   

}

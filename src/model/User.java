package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class User {
	

	@Id
	@Column(name="user_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
    private String name;
    //private Boolean termsAccepted; // just validate, no need for this in db
    
    //private String password1;
    //private String email;
    //private String phone;
    //private String city;
    
    public User(){
    }
    public User(String fullName){
    	name = fullName;
    }
 
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return name;
    } 
    public void setName(String name) {
        this.name = name;
    }
 
    /*
    public String getPassword1() {
        return password1;
    }
 
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 	*/
}
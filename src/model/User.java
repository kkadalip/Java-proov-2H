package model;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SortNatural;

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
    
    @OneToMany //@ManyToOne // (cascade={CascadeType.ALL})
    @JoinColumn(name = "sector_id") // not parent_sector duh
    private Set<Sector> user_sectors = new HashSet<>();

    
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
 
	public Set<Sector> getUser_sectors() {
		return user_sectors;
	}
	public void setUser_sectors(Set<Sector> user_sectors) {
		this.user_sectors = user_sectors;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		//System.out.println(" user tostring ");
		String result = "";
		result += " User ID: " + this.getId();
		result += " User Name: " + this.getName();
		return result;
	}
	
}
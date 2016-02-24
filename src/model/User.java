package model;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SortNatural;

@Entity
@Table(name="user")
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
    
    // http://stackoverflow.com/questions/11746499/solve-failed-to-lazily-initialize-a-collection-of-role-exception
    @ManyToMany //(fetch = FetchType.EAGER) //@ManyToOne // (cascade={CascadeType.ALL}) // @OneToMany(fetch = FetchType.LAZY, mappedBy = "user???")
    @JoinColumn(name = "sector_id") // not parent_sector duh
    private Set<Sector> user_sectors = new HashSet<>();
    // @Column(name="agreedToTerms")
    private Boolean agreedToTerms;
	
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
	
    public Boolean getAgreedToTerms() {
		return agreedToTerms;
	}
	public void setAgreedToTerms(Boolean agreedToTerms) {
		this.agreedToTerms = agreedToTerms;
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
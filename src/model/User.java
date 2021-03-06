package model;

import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;
//import java.util.SortedSet;
//import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.MapKeyColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.Null;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
//import org.hibernate.annotations.Type;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.SortNatural;

//import com.sun.istack.internal.NotNull;
//import com.sun.istack.internal.Nullable;

@Entity
@Table(name="user")
public class User {

	// <generator class="native" /> ???
	// GenerationType.IDENTITY
	//@GeneratedValue(generator="increment")
	//@GenericGenerator(name="increment", strategy = "increment")
	@Id
	@Column(name="user_id") // id
	//@Type(type = "long")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="user_name")
	//@Type(type = "string")
    private String name;
	
    @Column(name="agreedToTerms")
    //@Type(type = "boolean") // (type="yes_no")
    private Boolean agreedToTerms;

    @Column(name="user_sectors")
    @ManyToMany(fetch = FetchType.LAZY) // EAGER // TODO IMPROVE with a separate method in DAO? //@ManyToOne // (cascade={CascadeType.ALL}) // @OneToMany(fetch = FetchType.LAZY, mappedBy = "user???")
    @Cascade(value = { CascadeType.ALL })
    @JoinColumn(name = "sector_id") // not parent_sector duh // <key column="sector_id"
    //fix? @Nullable
    private Set<Sector> user_sectors = new HashSet<>();

    @Column(name="dateAdded")
    //@Type(type = "java.time.LocalDateTime")
    private LocalDateTime dateAdded; // important because agreement may have changed
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
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
		//return super.toString();
		String result = "";
		result += " User ID: " + this.getId();
		result += " User Name: " + this.getName();
		return result;
	}
	
}







// IF EAGER LOADING IS ENABLED, OTHERWISE LAZY INIT ERROR! (Need to load with separate method or use EAGER)
//	public String[] getUser_sectors_stringArray() {
//		
//		List<String> selectedSectors = new ArrayList<String>();
//		for(Sector sector : user_sectors){
//			selectedSectors.add(sector.getId().toString());
//		}
//		String[] selectedSectors_stringArray = new String[selectedSectors.size()];
//		selectedSectors.toArray(selectedSectors_stringArray);
//		return selectedSectors_stringArray;
//	}
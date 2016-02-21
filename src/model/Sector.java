package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sector")
public class Sector {

	@Id
	@Column(name="sector_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne // (cascade={CascadeType.ALL})
    @JoinColumn(name = "sector_id") // not parent_sector duh
    private Sector parentSector;

//	@ManyToOne
//    @JoinColumn(name = "user_id")
//	private int parent_sector_id;
	
//    public Sector(){
//    }
    
    //public Sector(String sectorName, Long user_id){
//    public Sector(String sectorName){
//    	name = sectorName;
//    }

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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Sector getParentSector() {
		return parentSector;
	}
	public void setParentSector(Sector parentSector) {
		this.parentSector = parentSector;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		System.out.println("sector tostring");
		String result = "";
		result += " ID: " + this.getId();
		result += " Name: " + this.getName();
		User sector_user = this.getUser();
		if(sector_user != null){
			result += " Sector user: " + sector_user.toString();
		}else{
			result += " Sector user: null";
		}
		Sector parent_sector = this.getParentSector();
		if(parent_sector != null){
			result += " Parent sector: " + this.getParentSector().toString();
		}else{
			result += " Parent sector: null";
		}
		 // recursively goes through
		return result;
	}
 
    
//	public int getParent_sector_id() {
//		return parent_sector_id;
//	}
//	public void setParent_sector_id(int parent_sector_id) {
//		this.parent_sector_id = parent_sector_id;
//	}
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "EVENT_DATE")
//	public Date getDate() {
//	    return date;
//	}
	
	
}
package model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;

@Entity
@Table(name = "sector")
//public class Sector {
// static class??
public class Sector implements Comparable<Sector> {

	@Id
	@Column(name="sector_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	private String name;
    
	/*
	//@ManyToOne
	@OneToMany // changed, haven't used this yet // (fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
	private Set<User> users;
	    //private User user;
	*/
	
 /*   @OneToMany //@ManyToOne // (cascade={CascadeType.ALL})
    @JoinColumn(name = "sector_id") // not parent_sector duh
    private Set<Sector> child_sectors; */
    
//  @SortComparator(WhateverComparator.class) // http://docs.jboss.org/hibernate/orm/5.1/userguide/html_single/Hibernate_User_Guide.html#collections-sorted-set
  // another way @Sort(type=SortType.COMPARATOR, comparator=TimeComparator.class)
  //@OrderBy("name")
    @OneToMany //@ManyToOne // (cascade={CascadeType.ALL})
    @JoinColumn(name = "sector_id") // not parent_sector duh
    //@OrderBy("name") // @OrderBy currently works only on collections having no association table. http://docs.jboss.org/ejb3/app-server/HibernateAnnotations/reference/en/html_single/index.html#entity-mapping-association-collections
    //@OrderBy(clause = "name asc")
    @SortNatural
//    private Set<Sector> child_sectors = new HashSet<>();
    private SortedSet<Sector> child_sectors = new TreeSet<>(); // TreeSet is only appropriate if you need the Set sorted, either by the Object's implementation of Comparable or by a custom Comparator passed to the TreeSet's constructor.
	
    //private Sector parentSector;

//	@ManyToOne
//    @JoinColumn(name = "user_id")
//	private int parent_sector_id;
    
//	public Sector getParentSector() {
//		return parentSector;
//	}
//	public void setParentSector(Sector parentSector) {
//		this.parentSector = parentSector;
//	}
    
    // CONSTRUCTORS
    public Sector(){
    }
	public Sector(String sectorName){
    	name = sectorName;
    }
//  public Sector(String sectorName, Long user_id){
//  public Sector(String sectorName, Sector sector_parentSector){
//  	name = sectorName;
//  	parentSector = sector_parentSector;
//  }
	
//	public Set<Sector> getChild_sectors() {
//		return child_sectors;
//	}
//
//	public void setChild_sectors(Set<Sector> child_sectors) {
//		this.child_sectors = child_sectors;
//	}

    public SortedSet<Sector> getChild_sectors() {
		return child_sectors;
	}
	public void setChild_sectors(SortedSet<Sector> child_sectors) {
		this.child_sectors = child_sectors;
	}

	//    public Sector(String sectorName, Set<Sector> sector_childSectors){
	public Sector(String sectorName, SortedSet<Sector> sector_childSectors){
    	name = sectorName;
    	child_sectors = sector_childSectors;
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
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		System.out.println("sector tostring");
		String result = "";
		result += " ID: " + this.getId();
		result += " Name: " + this.getName();
//		User sector_user = this.getUser();
//		if(sector_user != null){
//			result += " Sector user: " + sector_user.toString();
//		}else{
//			result += " Sector user: null";
//		}
		/*
		Set<User> users = this.getUsers();
		if(users != null){
			for (User user : users) {
				result += user.toString();
			}
		}else{
			result += " Users: null";
		}*/
		Set<Sector> child_sectors = this.getChild_sectors();
		if(child_sectors != null){
			for (Sector child_sector : child_sectors) {
				result += child_sector.toString();
			}
		}else{
			result += " Child sector: null";
		}
		/*
		Sector parent_sector = this.getParentSector();
		if(parent_sector != null){
			result += " Parent sector: " + this.getParentSector().toString();
		}else{
			result += " Parent sector: null";
		}
		*/
		 // recursively goes through
		  
		return result;
	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

 
    
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
	
	// compares names
	// TODO FIX
	@Override
    public int compareTo(Sector o) {
		System.out.println("[Sector][compareTo] this name: " + this.name + " comparing to " + o.getName());
        return this.name.compareTo( o.getName() );
    }
	
//    @Override
//    public int compareTo(Phone o) {
//        return number.compareTo( o.getNumber() );
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if ( this == o ) {
//            return true;
//        }
//        if ( o == null || getClass() != o.getClass() ) {
//            return false;
//        }
//        Phone phone = (Phone) o;
//        return Objects.equals( number, phone.number );
//    }

	
//	public static class WhateverComparator implements Comparator<Sector> {
//	    @Override
//	    public int compare(Sector o1, Sector o2) {
//	        return o2.compareTo( o1 );
//	    }
//	}


}


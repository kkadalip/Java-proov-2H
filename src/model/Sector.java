package model;

//import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
//import javax.persistence.OrderBy;
import javax.persistence.Table;
//import javax.validation.constraints.Null;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.OrderBy;
//import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;
//import org.hibernate.annotations.Type;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.sun.istack.internal.Nullable;


@Entity
@Table(name="sector")
//public class Sector {
// static class??
public class Sector implements Comparable<Sector> {

	// GenerationType.IDENTITY
	//@GeneratedValue(generator="increment")
	//@GenericGenerator(name="increment", strategy = "increment")
	@Id
	@Column(name="sector_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Type(type = "long")
	private Long id;

	//@Type(type = "string")
	@Column(name="name") // sector_name
	private String name;

	@ManyToMany //@ManyToOne // (cascade={CascadeType.ALL}) // @OneToMany(fetch = FetchType.LAZY, mappedBy = "user???")
	@Cascade(value={CascadeType.ALL})
	@JoinColumn(name="user_id") // <key column="user_id"
	@Nullable
	private Set<User> sector_users = new HashSet<>();

	//@SortComparator(WhateverComparator.class) // http://docs.jboss.org/hibernate/orm/5.1/userguide/html_single/Hibernate_User_Guide.html#collections-sorted-set
	//another way @Sort(type=SortType.COMPARATOR, comparator=TimeComparator.class)
	//@OrderBy("name")
	//@OrderBy("name") // @OrderBy currently works only on collections having no association table. http://docs.jboss.org/ejb3/app-server/HibernateAnnotations/reference/en/html_single/index.html#entity-mapping-association-collections
	//@OrderBy(clause = "name asc")
	//private Set<Sector> child_sectors = new HashSet<>();
	//@JoinColumn(name = "sector_id")
	//@JoinColumn(name = "parent_sector", referencedColumnName = "sector_id")
	// org.hibernate.HibernateException: org.hibernate.AnnotationException: Associations marked as mappedBy must not define database mappings like @JoinTable or @JoinColumn: model.Sector.child_sectors
	@OneToMany(fetch=FetchType.EAGER) //, mappedBy="") //cascade = CascadeType.ALL, (fetch=FetchType.EAGER) //@ManyToOne // (cascade={CascadeType.ALL})
	@Cascade(value={CascadeType.ALL})
	@OrderBy(value="name")
	@SortNatural
	@JoinColumn(name="fk_sector_id") // <key column="sector_id"
	@Nullable
	private SortedSet<Sector> child_sectors = new TreeSet<>(); // TreeSet is only appropriate if you need the Set sorted, either by the Object's implementation of Comparable or by a custom Comparator passed to the TreeSet's constructor.




	/*   @OneToMany //@ManyToOne // (cascade={CascadeType.ALL})
    @JoinColumn(name = "sector_id") // not parent_sector duh
    private Set<Sector> child_sectors; */

	public Set<User> getSector_users() {
		return sector_users;
	}
	public void setSector_users(Set<User> sector_users) {
		this.sector_users = sector_users;
	}


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
	@Transactional
	public String toString() {
		//return super.toString();
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

		/*
		 * NOT USING ATM:
		Set<Sector> child_sectors = this.getChild_sectors();

		// fetch = FetchType.EAGER to use this, atm using lazy
		if(child_sectors != null){
			for (Sector child_sector : child_sectors) {
				result += child_sector.toString();
			}
		}else{
			result += " (No child sectors)";
		}
		 */

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

	//	@Temporal(TemporalType.TIMESTAMP)
	//	@Column(name = "EVENT_DATE")
	//	public Date getDate() {
	//	    return date;
	//	}

	@Override
	public int compareTo(Sector o) {
		//System.out.println("[Sector][compareTo] this name: " + this.name + " comparing to " + o.getName());
		return this.name.compareTo( o.getName() );
	}
}

















/*
//@ManyToOne
@OneToMany // changed, haven't used this yet // (fetch=FetchType.EAGER)
@JoinColumn(name = "user_id")
private Set<User> users;
    //private User user;
 */


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

package manytoone;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
//	@OneToMany(mappedBy = "item", 
//			cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
//	@OnDelete(
//			action = OnDeleteAction.CASCADE
//			)
	@OneToMany(mappedBy = "item", 
	cascade = {CascadeType.PERSIST})
//	@BatchSize(size = 10)
	//@Fetch(FetchMode.SUBSELECT)
	@Fetch(FetchMode.JOIN)
	protected Set<Bid> bids = new HashSet<Bid>(); 

	
	public Item() {
		
	}

	public Item(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
}

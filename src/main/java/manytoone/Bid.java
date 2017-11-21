package manytoone;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Bid {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private long count;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="ITEM_ID", nullable = false)
	protected Item item;

	public Bid(){
		
	}
	public Bid(long l, Item someItem) {
		this.setCount(l);
		this.item = someItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	
}

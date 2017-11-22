package onetoone;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	protected Long id;
	
	protected String name;
	@OneToOne(fetch = FetchType.LAZY,
			optional = false)
	@PrimaryKeyJoinColumn
	protected Address shippingAddress;
	protected User(){
		
	}
	public User(Long id, String username){
		this.id = id;
		this.name = username;
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
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}

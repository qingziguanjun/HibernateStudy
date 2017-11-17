package collectionmapping.annotation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * hibernate实战第七章的内容
 * @author sy
 *
 */
@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	private String name;
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
	//实际上只加这一句就可以，hibernate会自动帮忙我生成默认配置
	// create table Item_images (Item_id integer not null, images varchar(255)) engine=InnoDB
	//alter table Item_images add constraint FKiuocmn79jsijxvmviawwjmi2n foreign key (Item_id) references item_set (id)
	//通过下面注解，我们可以自定义表名，关联字段名，和值对应列表
	/**映射set列表,不允许重复
	@ElementCollection
	@CollectionTable(name="IMAGE",
	joinColumns = @JoinColumn(name="id"))
	@Column(name="FILENAME")
	protected Set<String> images = new HashSet<String>();
	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}
	*/
	
	@ElementCollection
	@org.hibernate.annotations.CollectionId(columns = { @Column(name="image_id") }, 
	generator = "identity", type = @Type(type="string"))
	protected List<String> images = new ArrayList<String>();

	

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}



	
	
}

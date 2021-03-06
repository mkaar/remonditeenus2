package ee.ttu.remonditeenus.model;

import javax.persistence.*;

@Entity
@Table(name="so_status_type")
public class ServiceOrderStatusType {

	private int id;
	
	private String name;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="so_status_type")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="type_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

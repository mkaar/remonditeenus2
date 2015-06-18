package ee.ttu.remonditeenus.model;

import javax.persistence.*;

@Entity
@Table(name="service_action_status_type")
public class ServiceActionStatusType {

	private Integer id;
	private String name;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="service_action_status_type")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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

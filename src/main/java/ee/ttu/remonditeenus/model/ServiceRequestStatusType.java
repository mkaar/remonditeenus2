package ee.ttu.remonditeenus.model;

import javax.persistence.*;

@Entity
@Table(name="service_request_status_type")
public class ServiceRequestStatusType {

	private int id;
	
	private String name;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="service_request_status_type")
	public int getId() {
		return id;
	}
	
	@Column(name="type_name")
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

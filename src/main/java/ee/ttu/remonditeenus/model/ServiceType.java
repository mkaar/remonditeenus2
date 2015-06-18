package ee.ttu.remonditeenus.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="service_type")
public class ServiceType {

	private Integer id;
	private ServiceUnitType serviceUnitType;
	private String typeName;
	private Double price;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="service_type")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="service_unit_type_fk")
	@JsonIgnore
	public ServiceUnitType getServiceUnitType() {
		return serviceUnitType;
	}
	
	public void setServiceUnitType(ServiceUnitType serviceUnitType) {
		this.serviceUnitType = serviceUnitType;
	}
	
	@Column(name="type_name")
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Column(name="service_price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}

package ee.ttu.remonditeenus.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="service_device")
public class ServiceDevice {

	private int id;
	
	private Device device;
	
	private ServiceDeviceStatusType serviceDeviceStatusType;
	
	private ServiceOrder serviceOrder;
	
	private List<ServicePart> parts;
	
	private List<ServiceAction> actions;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="service_device")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="serviceDevice")
	@LazyCollection(LazyCollectionOption.FALSE)
	@NotFound(action= NotFoundAction.IGNORE)
	public List<ServicePart> getParts() {
		return parts;
	}
	
	public void setParts(List<ServicePart> parts) {
		this.parts = parts;
	}
	
	@OneToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="serviceDevice")
	@LazyCollection(LazyCollectionOption.FALSE)
	@NotFound(action= NotFoundAction.IGNORE)
	public List<ServiceAction> getActions() {
		return actions;
	}
	
	public void setActions(List<ServiceAction> actions) {
		this.actions = actions;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, optional=true)
	@JoinColumn(name = "service_order_fk")
	public ServiceOrder getServiceOrder() {
		return serviceOrder;
	}
	
	public void setServiceOrder(ServiceOrder serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="device_fk")
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="service_device_status_type_fk")
	public ServiceDeviceStatusType getServiceDeviceStatusType() {
		return serviceDeviceStatusType;
	}

	public void setServiceDeviceStatusType(
			ServiceDeviceStatusType serviceDeviceStatusType) {
		this.serviceDeviceStatusType = serviceDeviceStatusType;
	}

}

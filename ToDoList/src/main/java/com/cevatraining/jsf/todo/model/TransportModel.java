 package com.cevatraining.jsf.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(schema="transport")
@NamedQueries({ @NamedQuery(name = TransportModel.FIND_ALL, query = "SELECT t FROM TransportModel t order by t.id") })
@XmlRootElement

public class TransportModel {
	
	
	
	public static final String FIND_ALL = "TransportModel.findAll";
	@Id
	@Column
	@GeneratedValue
	private String id;
	
	@Column
	private String vehicleType;
	
	@Column
	private String vehicleNumber;
	
	@Column
	private String driverName;
	
	@Column
	private String vehicleMode;
	
	@Transient
	private boolean edit = false;
	
	
	public TransportModel(String vehicleType, String vehicleNumber, String driverName, String vehicleMode) {
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.driverName = driverName;
		this.vehicleMode = vehicleMode;
	}

	public TransportModel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getVehicleMode() {
		return vehicleMode;
	}

	public void setVehicleMode(String vehicleMode) {
		this.vehicleMode = vehicleMode;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	@Override
	public String toString() {
		return "TransportModel [id=" + id + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber
				+ ", driverName=" + driverName + ", vehicleMode=" + vehicleMode + "]";
	}


	
	

}

package com.cevatraining.jsf.todo.model;

import java.util.Date;
import java.util.List;

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
@Table(schema="datePicker")
@NamedQueries({ @NamedQuery(name = DatePickerModel.FIND_ALL, query = "SELECT t FROM DatePickerModel t order by t.id") })
@XmlRootElement
public class DatePickerModel {
	
	public static final String FIND_ALL = "DatePickerModel.findAll";
	@Id
	@Column
	@GeneratedValue
	private String id;
	
	@Column
	private String vehicleType;
	
	@Column
	 private String vehicleName;
	
	@Column
	private String vehicleNumber;
	
	@Column
	private String driverName;
	
	@Column
	private String vehicleMode;
	
	@Column
	private Date vehicleRegistrationDate;
	
	
	
   
	
	@Column
	private List<String> companiesList;
	
	
	@Transient
	private boolean edit = false;
	
	

	public DatePickerModel(String id, String vehicleType, String vehicleName, String vehicleNumber, String driverName,
			String vehicleMode, Date vehicleRegistrationDate) {

		this.id = id;
		this.vehicleType = vehicleType;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.driverName = driverName;
		this.vehicleMode = vehicleMode;
		this.vehicleRegistrationDate = vehicleRegistrationDate;
	}

	public DatePickerModel() {
	}
	
	public Date getVehicleRegistrationDate() {
	    return vehicleRegistrationDate;
		
	}

	public void setVehicleRegistrationDate(Date vehicleRegistrationDate) {
		this.vehicleRegistrationDate = vehicleRegistrationDate;
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

	public List<String> getCompaniesList() {
		return companiesList;
	}

	public void setCompaniesList(List<String> companiesList) {
		this.companiesList = companiesList;
	}

	

	public String getVehicleName() {
		return vehicleName;
	}




	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
/*	public static String datePattern() {
		return "dd/MM/yyyy";
	 }

	public static String customFormatDate(Date vehicleRegistrationDate) {
		if (vehicleRegistrationDate != null) {
		    DateFormat format = new SimpleDateFormat(datePattern());
		    return format.format(vehicleRegistrationDate);
		 }
		return "";
	}
*/
	@Override
	public String toString() {
		return "DatePickerModel [id=" + id + ", vehicleType=" + vehicleType + ", vehicleName=" + vehicleName
				+ ", vehicleNumber=" + vehicleNumber + ", driverName=" + driverName + ", vehicleMode=" + vehicleMode
				+ ", vehicleRegistrationDate=" + vehicleRegistrationDate + "]";
	}




	






}

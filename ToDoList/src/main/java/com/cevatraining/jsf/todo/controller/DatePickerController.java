package com.cevatraining.jsf.todo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyDataModel;

import com.cevatraining.jsf.todo.lazyDataModel.DatePickerLazyModel;
import com.cevatraining.jsf.todo.model.DatePickerModel;
import com.cevatraining.jsf.todo.service.impl.DatePickerServiceImpl;

@ManagedBean(name = "datePicker")
@ViewScoped
public class DatePickerController {
	
	private boolean editDisabled = true;

	private List<DatePickerModel> transports;
	private DatePickerModel transport;
	private DatePickerModel newTransport;
	private DatePickerModel transportEdit;
	
	private DualListModel<String> dataDeleteById;
	

	private Map<String, Map<String, String>> vehicleData = new HashMap<>();
	private String vehicleType;
	private String vehicleName;
	private Map<String, String> vehicleTypes;
	private Map<String, String> vehicleNames;
	
	
	
	private UIForm form;
	private UIForm tableForm;
	private UICommand addCommand;
	

	private LazyDataModel<DatePickerModel> datePickerDataModel;
	
	List<String> sourceList = new ArrayList<>();
	List<String> targetList = new ArrayList<>();
	
	
	
	@Inject
	private DatePickerServiceImpl datePickerService;
	

	public DatePickerController() {
		transports = new ArrayList<DatePickerModel>();
		newTransport = new DatePickerModel();
		
		
	}
	
	@PostConstruct
	public void init() {
		datePickerDataModel = new DatePickerLazyModel(datePickerService);
		transports = datePickerService.findAll();
		newTransport = new DatePickerModel();
		
		dataDeleteById = new DualListModel<>(sourceList,targetList);
		for (DatePickerModel pickList : transports) {
			sourceList.add(String.valueOf(pickList.getId()));
			
		}
		
		vehicleTypes = new HashMap<>();
		vehicleTypes.put("Car", "Car");
		vehicleTypes.put("Bike", "Bike");
		vehicleTypes.put("Scooty", "Scooty");
		vehicleTypes.put("Auto", "Auto");	
		vehicleTypes.put("Bus", "Bus");
		vehicleTypes.put("Truck", "Truck");
		vehicleTypes.put("Tractor", "Tractor");
		vehicleTypes.put("Van", "Van");
		

	    Map<String, String> sampleData = new HashMap<>();
	    sampleData.put("BMW", "BMW");
	    sampleData.put("Ferrari", "Ferrari");
	    sampleData.put("Mercedez Benz", "Mercedez Benz");
	    sampleData.put("Hyundai", "Hyundai");
	    sampleData.put("Toyota", "Toyota");
	    sampleData.put("Kia", "Kia");
	    sampleData.put("Renault", "Renault");
	    sampleData.put("Honda", "Honda");
	    vehicleData.put("Car", sampleData);

	    sampleData = new HashMap<>();
	    sampleData.put("Royal Enfiled", "Royal Enfiled");
	    sampleData.put("Yamaha R15", "Yamaha R15");
	    sampleData.put("Java Perak", "Java Perak");
	    sampleData.put("Bajaj Pulsar", "Bajaj Pulsar");
	    sampleData.put("Honda Unicorn", "Honda Unicorn");
	    sampleData.put("Hero Glamour", "Hero Glamour");
	    sampleData.put("RX100", "RX100");
	    sampleData.put("Honda Shine", "Honda Shine");
	    sampleData.put("Bajaj Chetak", "Bajaj Chetak");
	    sampleData.put("Hero Deluxe", "Hero Deluxe");
	    sampleData.put("Hero CD100", "Hero CD100");
	    sampleData.put("Bajaj Discovery", "Bajaj Discovery");
	    vehicleData.put("Bike", sampleData);

	    sampleData = new HashMap<>();
	    sampleData.put("Vespa", "Vespa");
	    sampleData.put("Honda Activa 6G", "Honda Activa 6G");
	    sampleData.put("Suzuki Access", "Suzuki Access");
	    sampleData.put("Bajaj Fascino", "Bajaj Fascino");
	    sampleData.put("TVS Jupitor", "TVS Jupitor");
	    sampleData.put("Honda Dio", "Honda Dio");
	    sampleData.put("TVS Pep Plus", "TVS Pep Plus");
	    sampleData.put("Ola Electric", "Ola Electric");
	    vehicleData.put("Scooty", sampleData);
	    
	    sampleData = new HashMap<>();
	    sampleData.put("Mahindra", "Mahindra");
	    sampleData.put("Bajaj Auto", "Bajaj Auto");
	    sampleData.put("TVS Auto", "TVS Auto");
	    sampleData.put("Paiggio", "Paiggio");
	    vehicleData.put("Auto", sampleData);
	    
	    sampleData = new HashMap<>();
	    sampleData.put("Mahindra", "Mahindra");
	    sampleData.put("Volvo Buses", "Volvo Buses");
	    sampleData.put("Ashok Leyland", "Ashok Leyland");
	    sampleData.put("Tata Motors", "Tata Motors");
	    sampleData.put("BharatBenz", "BharatBenz");
	    sampleData.put("Eicher Motors", "Eicher Motors");
	    vehicleData.put("Bus", sampleData);
	    
	    sampleData = new HashMap<>();
	    sampleData.put("Tata Motors", "Tata Motors");
	    sampleData.put("Ashok Leyland", "Ashok Leyland");
	    sampleData.put("Mahindra", "Mahindra");
	    sampleData.put("Hindustan Motors", "Hindustan Motors");
	    sampleData.put("BharatBenz", "BharatBenz");
	    sampleData.put("Eicher Motors", "Eicher Motors");
	    vehicleData.put("Truck", sampleData);
	    
	    sampleData = new HashMap<>();
	    sampleData.put("Mahindra", "Mahindra");
	    sampleData.put("Sonalika Tractors", "Sonalika Tractors");
	    sampleData.put("Swaraj Tractors", "Swaraj Tractors");
	    sampleData.put("John Deere", "John Deere");
	    sampleData.put("Force Motors", "Force Motors");
	    vehicleData.put("Tractor", sampleData);
	    
	    sampleData = new HashMap<>();
	    sampleData.put("Tata Motors", "Tata Motors");
	    sampleData.put("BharatBenz", "BharatBenz");
	    sampleData.put("Eicher Motors", "Eicher Motors");
	    sampleData.put("Ashok Leyland", "Ashok Leyland");
	    vehicleData.put("Van", sampleData);
	
	}

	public List<DatePickerModel> addNew() {
		newTransport.setVehicleType(vehicleType);
		newTransport.setVehicleName(vehicleName);
		datePickerService.createVehicle(newTransport);
		dataDeleteById.getSource().add(newTransport.getId());
		transports = datePickerService.findAll();
		vehicleType = null;
		vehicleName= null;
		newTransport = new DatePickerModel();
		return transports;	
	}
	
	
	public void deleteDetails() {
		datePickerService.deleteTransport(transport);
		sourceList.remove(transport.getId());
		transports = datePickerService.findAll();
		
	}
	
	
	public void DeleteDataUsingPickList() {
		List<String> deleteIds = dataDeleteById.getTarget();
		datePickerService.DeleteDataUsingPickList(deleteIds);
		dataDeleteById.getTarget().clear();
	}
	

	
	
	public void updateTransport(RowEditEvent event) {
		DatePickerModel vehicleEdit = (DatePickerModel) event.getObject();
		vehicleEdit.setVehicleType(vehicleType);
		vehicleEdit.setVehicleName(vehicleName);
		datePickerService.updateTransportDetails(vehicleEdit);
	        FacesMessage msg = new FacesMessage("Vehicle Details Edited", String.valueOf(vehicleEdit.getId()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
	 public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getClass()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	 
	 public void onCellEdit(CellEditEvent event) {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	        DataTable dataTable = (DataTable) event.getSource();
	        DatePickerModel  transportEdit   =(DatePickerModel) dataTable.getRowData();
	        datePickerService.updateTransportDetails(transportEdit);

	        if (newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
		}
	
	
	public List<DatePickerModel> updateDetails() {
		datePickerService.updateTransportDetails(newTransport);
		transports = datePickerService.findAll();
		newTransport = new DatePickerModel();
		setEditDisabled(false);
		transport.setEdit(false);
		return transports;
	}
	

	public List<DatePickerModel> getTransports() {
		return transports;
	}

	public void setTransports(List<DatePickerModel> transports) {
		this.transports = transports;
	}

	public DatePickerModel getTransport() {
		return transport;
	}

	public void setTransport(DatePickerModel transport) {
		this.transport = transport;
	}

	public DatePickerModel getNewTransport() {
		return newTransport;
	}

	public void setNewTransport(DatePickerModel newTransport) {
		this.newTransport = newTransport;
	}
	
	 
	public DatePickerModel getTransportEdit() {
		return transportEdit;
	}

	public void setTransportEdit(DatePickerModel transportEdit) {
		this.transportEdit = transportEdit;
	}

	public boolean isEditDisabled() {
		return editDisabled;
	}

	public void setEditDisabled(boolean editDisabled) {
		this.editDisabled = editDisabled;
	}

	public UIForm getForm() {
		return form;
	}

	public void setForm(UIForm form) {
		this.form = form;
	}

	public UIForm getTableForm() {
		return tableForm;
	}

	public void setTableForm(UIForm tableForm) {
		this.tableForm = tableForm;
	}

	public UICommand getAddCommand() {
		return addCommand;
	}

	public void setAddCommand(UICommand addCommand) {
		this.addCommand = addCommand;
	}

	public LazyDataModel<DatePickerModel> getDatePickerDataModel() {
		return datePickerDataModel;
	}

	 public Map<String, Map<String, String>> getVehicleData() {
		return vehicleData;
	}

	public void setVehicleData(Map<String, Map<String, String>> vehicleData) {
		this.vehicleData = vehicleData;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Map<String, String> getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(Map<String, String> vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	public Map<String, String> getVehicleNames() {
		return vehicleNames;
	}

	public void setVehicleNames(Map<String, String> vehicleNames) {
		this.vehicleNames = vehicleNames;
	}

	
	
	public DualListModel<String> getDataDeleteById() {
		return dataDeleteById;
	}

	public void setDataDeleteById(DualListModel<String> dataDeleteById) {
		this.dataDeleteById = dataDeleteById;
	}

	public void onTransportChange() {
	        if (vehicleType != null && !"".equals(vehicleType)) {
	            vehicleNames = vehicleData.get(vehicleType);
	        }
	        else {
	            vehicleNames = new HashMap<>();
	        }
	    }
	
	


}

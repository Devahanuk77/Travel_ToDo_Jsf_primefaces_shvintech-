package com.cevatraining.jsf.todo.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

import com.cevatraining.jsf.todo.lazyDataModel.TransportLazyDataModel;
import com.cevatraining.jsf.todo.model.TransportModel;
import com.cevatraining.jsf.todo.service.impl.TransportServiceImpl;


@ManagedBean(name = "vehiclePrime")
@ViewScoped
public class TransportPrime implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean editDisabled = true;

	private List<TransportModel> transports;
	private TransportModel transport;
	private TransportModel newTransport;
	private TransportModel transportEdit;
	
	private UIForm form;
	private UIForm tableForm;
	private UICommand addCommand;
	
	private LazyDataModel<TransportModel> transportDataModel;
	

	@Inject
	private TransportServiceImpl transportService;
	

	public TransportPrime() {
		transports = new ArrayList<TransportModel>();
		newTransport = new TransportModel();
		
	}
	
	@PostConstruct
	public void init() {
		transportDataModel = new TransportLazyDataModel(transportService);
		transports = transportService.findAll();
		newTransport = new TransportModel();
		
	}

	public LazyDataModel<TransportModel> getTransportDataModel(){
		return transportDataModel;
	}

	public List<TransportModel> addNew() {
		transportService.createVehicle(newTransport);
		transports = transportService.findAll();
		newTransport = new TransportModel();
		return transports;	
	}
	
	
	public void updateTransport(RowEditEvent event) {
		 TransportModel vehicleEdit = (TransportModel) event.getObject();
		 transportService.updateTransportDetails(vehicleEdit);
	        FacesMessage msg = new FacesMessage("Vehicle Details Edited", String.valueOf(vehicleEdit.getId()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
	 public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getClass()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
	
	public void deleteDetails() {
		transportService.deleteTransport(transport);
		transports = transportService.findAll();
	}

	public List<TransportModel> getTransports() {
		return transports;
	}

	public void setTransports(List<TransportModel> transports) {
		this.transports = transports;
	}

	public TransportModel getTransport() {
		return transport;
	}

	public void setTransport(TransportModel transport) {
		this.transport = transport;
	}

	public TransportModel getNewTransport() {
		return newTransport;
	}

	public void setNewTransport(TransportModel newTransport) {
		this.newTransport = newTransport;
	}
	
	 
	public TransportModel getTransportEdit() {
		return transportEdit;
	}

	public void setTransportEdit(TransportModel transportEdit) {
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
}

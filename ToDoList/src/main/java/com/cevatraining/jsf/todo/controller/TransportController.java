package com.cevatraining.jsf.todo.controller;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.cevatraining.jsf.todo.model.TransportModel;
import com.cevatraining.jsf.todo.service.impl.TransportServiceImpl;



@ManagedBean(name = "vehicle")
@ViewScoped
public class TransportController {
	
	private boolean editDisabled = true;

	private List<TransportModel> transports;
	private TransportModel transport;
	private TransportModel newTransport;
	private TransportModel transportEdit;
	

	@Inject
	private TransportServiceImpl transportService;
	

	public TransportController() {
		transports = new ArrayList<TransportModel>();
		newTransport = new TransportModel();
		
	}
	
	@PostConstruct
	public void init() {
		transports = transportService.findAll();
	}
	
	public List<TransportModel> addNew() {
		transportService.createVehicle(newTransport);
		transports = transportService.findAll();
		newTransport = new TransportModel();
		return transports;	
	}
	
	
	public void deleteDetails() {
		transportService.deleteTransport(transport);
		transports = transportService.findAll();
	}
	
	
	public List<TransportModel> updateDetails() {
		transportService.updateTransportDetails(newTransport);
		transports = transportService.findAll();
		newTransport = new TransportModel();
		setEditDisabled(false);
		transport.setEdit(false);
		return transports;
	}
	
	
	public String edit() {
		setEditDisabled(true);
		transport.setEdit(true);
		transportEdit = new TransportModel();
		transportEdit.setId(transport.getId());
		transportEdit.setVehicleType(transport.getVehicleType());
		transportEdit.setVehicleNumber(transport.getVehicleNumber());
		transportEdit.setEdit(false);
		transportEdit.setDriverName(transport.getDriverName());
		transportEdit.setVehicleMode(transport.getVehicleMode());
		return null;
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
	
	
}

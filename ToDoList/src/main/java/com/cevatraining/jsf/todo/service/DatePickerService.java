package com.cevatraining.jsf.todo.service;

import java.util.List;

import com.cevatraining.jsf.todo.model.DatePickerModel;


public interface DatePickerService {
	
	
	public  DatePickerModel createVehicle(DatePickerModel transport);
	   public  List<DatePickerModel> findAll();
	    public void deleteTransport(DatePickerModel transport);
	    public DatePickerModel updateVehicleDetails(DatePickerModel transportModel);
	    public List<DatePickerModel> getEmployeeList(int start, int size);
	    public int getTransportTotalCount();

}

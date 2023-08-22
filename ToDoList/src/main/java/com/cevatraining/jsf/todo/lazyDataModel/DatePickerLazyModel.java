package com.cevatraining.jsf.todo.lazyDataModel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.cevatraining.jsf.todo.model.DatePickerModel;
import com.cevatraining.jsf.todo.service.impl.DatePickerServiceImpl;

@SuppressWarnings("serial")
public class DatePickerLazyModel extends LazyDataModel<DatePickerModel> {
	
	private DatePickerServiceImpl datePickerService;
	
	  public DatePickerLazyModel(DatePickerServiceImpl datePickerService){
		  this.datePickerService = datePickerService;
		  
		  
	    }

	@Override
	public List<DatePickerModel> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<DatePickerModel> list = datePickerService.getEmployeeList(first, pageSize, sortField, sortOrder, filters);
		this.setRowCount(datePickerService.getFilterRowCount(filters));
		return list;
	}

}

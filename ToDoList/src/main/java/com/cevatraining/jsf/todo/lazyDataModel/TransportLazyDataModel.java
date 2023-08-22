package com.cevatraining.jsf.todo.lazyDataModel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.cevatraining.jsf.todo.model.TransportModel;
import com.cevatraining.jsf.todo.service.impl.TransportServiceImpl;

public class TransportLazyDataModel extends LazyDataModel<TransportModel> {
	

	private TransportServiceImpl transportService;
	
	  public TransportLazyDataModel(TransportServiceImpl transportService){
		  this.transportService = transportService;
		  
		  
	    }

	@Override
	public List<TransportModel> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		
		List<TransportModel> list = transportService.getTransportList(first, pageSize, sortField, sortOrder, filters);
			this.setRowCount(transportService.getFilterRowCount(filters));
		return list;
	}
	 


	  
	  


	  
	  
	
	  
	  
    
	    
	
	

}

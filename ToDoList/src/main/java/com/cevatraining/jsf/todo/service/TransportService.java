package com.cevatraining.jsf.todo.service;

import java.util.List;

import com.cevatraining.jsf.todo.model.TransportModel;



public interface TransportService {
  public  TransportModel createVehicle(TransportModel transport);
   public  List<TransportModel> findAll();
    public void deleteTransport(TransportModel transport);
    public TransportModel updateVehicleDetails(TransportModel transportModel);
    public List<TransportModel> getEmployeeList(int start, int size);
    public int getTransportTotalCount();
}

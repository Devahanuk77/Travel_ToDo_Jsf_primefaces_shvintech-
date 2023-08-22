package com.cevatraining.jsf.todo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.primefaces.model.SortOrder;

import com.cevatraining.jsf.todo.model.DatePickerModel;

@Stateful
public class DatePickerServiceImpl {
	
	
	
	 @PersistenceContext(unitName = "datePicker", type = PersistenceContextType.EXTENDED)
	    private EntityManager em;



	    @SuppressWarnings("unused")
		private EntityManager getEntityManager() {
	        try {
	            EntityManagerFactory factory = Persistence.createEntityManagerFactory("datePickerLocal");
	            em = factory.createEntityManager();
	            return em;
	        } catch (Exception e) {
	            System.out.println("Exception in getEntityManager() " + e);
	            return null;
	        }
	    }

	    public DatePickerModel createVehicle(DatePickerModel transport) {
	        em.persist(transport);
	        em.flush();
	        return transport;
	    }

	    public List<DatePickerModel> findAll() {
	        try {
	            TypedQuery<DatePickerModel> typedQuery = em.createNamedQuery(DatePickerModel.FIND_ALL, DatePickerModel.class);
	            return typedQuery.getResultList();
	        }
	        	catch (Exception e) {
	            System.out.println("Exception in findAll() " + e);
	            return null;
	        }
	    }
	    
	    public void DeleteDataUsingPickList(List<String> data) {
	    	
	    	for (String ids : data) {
	    		DatePickerModel objectData= em.find(DatePickerModel.class, ids);
	    		try {
	    			
	    			if(objectData != null) {
		    			em.remove(objectData);
		    		}
	    			
	    		}catch (Exception e) {
					System.out.println(e);
				}
	    		
	    		
				
			}
	    	
	    }
	    
	    
	    
	    public void deleteTransport(DatePickerModel model) {
	    	try {
	    			em.remove(model);
	    			em.flush();
	    	}
	    		catch(Exception e) {
	    		System.out.println("Exception in deleteTransport()"+e);
	    	}
	    }
	    
	    public DatePickerModel updateTransportDetails(DatePickerModel transportModel) {
			try {
				DatePickerModel mergedTransport = em.merge(transportModel);
				em.flush();
					return mergedTransport;
			}
				catch (Exception e) {
				System.out.println("Exception in editTransport()" + e);
				return null;
			}
		}
	    
	    public List<DatePickerModel> getEmployeeList(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters){
	    	CriteriaBuilder cbld = em.getCriteriaBuilder();
	    	CriteriaQuery<DatePickerModel> criteriaQuery = cbld.createQuery(DatePickerModel.class);
	    	Root<DatePickerModel> root = criteriaQuery.from(DatePickerModel.class);
	    	
	    	CriteriaQuery<DatePickerModel> select = criteriaQuery.select(root);
	   
	    	if(sortField != null) {
	    		criteriaQuery.orderBy(sortOrder == SortOrder.DESCENDING ? cbld.asc(root.get(sortField)): cbld.desc(root.get(sortField)));
	    	}
	    	
	    	if(filters != null && filters.size() >0) {
	    		List<Predicate> predicates = new ArrayList<>();
	    		for(Map.Entry<String, Object> entry : filters.entrySet()) {
	    			String field = entry.getKey();
	    			Object value = entry.getValue();
	    			if(value == null) {
	    				continue;
	    			}
	    			
	    				Expression<String> expression = root.get(field).as(String.class);
	    			Predicate p =cbld.like(cbld.lower(expression), "%" + value.toString().toLowerCase() + "%");
	    			predicates.add(p);
	    		}
	    		if(predicates.size() > 0) {
	    			criteriaQuery.where(cbld.and(predicates.toArray(new Predicate[predicates.size()])));
	    		}
	    	}
	    
	    	
	    	TypedQuery<DatePickerModel> query = em.createQuery(select);
	        query.setFirstResult(start);
	        query.setMaxResults(size);
	        List <DatePickerModel> list = query.getResultList();
	        return list;	
	    }
	    
	    public int getTransportTotalCount() {
	        Query query = em.createQuery("SELECT COUNT(tm.id) From DatePickerModel tm");
	        return ((Long)query.getSingleResult()).intValue();
	    }
	    
	    
	    
	    
	    public int getFilterRowCount(Map<String, Object> filters) {
	    	CriteriaBuilder cbld = em.getCriteriaBuilder();
	    	CriteriaQuery<Long> criteriaQuery = cbld.createQuery(Long.class);
	    	Root<DatePickerModel> root = criteriaQuery.from(DatePickerModel.class);
	    	CriteriaQuery<Long> select = criteriaQuery.select(cbld.count(root));
	    	
	    	if(filters != null && filters.size() >0) {
	    		List<Predicate> predicates = new ArrayList<>();
	    		for(Map.Entry<String, Object> entry : filters.entrySet()) {
	    			String field = entry.getKey();
	    			Object value = entry.getValue();
	    			if(value == null) {
	    				continue;
	    			}
	    			
	    			Expression<String> expression = root.get(field).as(String.class);
	    			Predicate p =cbld.like(cbld.lower(expression), "%" + value.toString().toLowerCase() + "%");
	    			predicates.add(p);
	    		}
	    		if(predicates.size() > 0) {
	    			criteriaQuery.where(cbld.and(predicates.toArray(new Predicate[predicates.size()])));
	    		}	
	    	}
	    	
	    	Long count = em.createQuery(select).getSingleResult();
	    	return count.intValue();
	    	
	    }

}

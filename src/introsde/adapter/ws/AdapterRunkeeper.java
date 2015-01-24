package introsde.adapter.ws;

import introsde.adapter.model.Profile;
import introsde.adapter.model.Activities;
import introsde.adapter.model.Weights;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding
public interface AdapterRunkeeper {
	
	
	@WebMethod(operationName="getFitnessActivities")
    @WebResult(name="fitnessActivities") 
    public Activities getFitnessActivities(@WebParam(name="accessToken") String accessToken);
	
	@WebMethod(operationName="getWeight")
    @WebResult(name="weight") 
    public Weights getWeight(@WebParam(name="accessToken") String accessToken);
	

	
	@WebMethod(operationName="getUser")
    @WebResult(name="user") 
    public Profile getUser(@WebParam(name="accessToken") String accessToken);
 
   }
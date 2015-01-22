package hospital.web.controller;

import hospital.facade.DiagnosisFacade;
import hospital.facade.PatientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* Created on 28.12.2014.
*
* @author Crazy Bobik
*         (.)(.)
*         =)
*/
@Controller
public class DiagnosisController {

    @Autowired
    private DiagnosisFacade diagnosisFacade;

    @Autowired
    private PatientFacade patientFacade;

    @RequestMapping(value = "/patients/{patientId}/diagnosis/new", method = RequestMethod.GET)
    public String prepareAddForm(){
        
        return null;
    }
    
    @RequestMapping(value = "/patients/{patientId}/diagnosis/new", method = RequestMethod.POST)
    public String processAddForm(){
        
        return null;
    } 
    
    @RequestMapping(value = "/patients/{patientId}/diagnosis/edit", method = RequestMethod.GET)
    public String prepareEditForm(){
        
        return null;
    }
    
    @RequestMapping(value = "/patients/{patientId}/diagnosis/edit", method = RequestMethod.POST)
    public String processEditForm(){
        
        return null;
    }
    
    @RequestMapping("/patient/{patientId}/diagnosis/delete")
    public String deleteDiagnosis(){
        
        return null;
    }
}

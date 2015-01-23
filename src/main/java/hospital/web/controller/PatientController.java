package hospital.web.controller;

import hospital.facade.InsurerFacade;
import hospital.facade.PatientFacade;
import hospital.view.PatientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 26.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */
@Controller
public class PatientController {
    
    @Autowired
    private PatientFacade patientFacade;
    
    @Autowired
    private InsurerFacade insurerFacade;
    
    @RequestMapping("/patients")
    public String showAllPatients(ModelMap map){
        map.addAttribute("patientList", patientFacade.getPatients());
        
        return "patients/patients";
    }
    
    @RequestMapping(value = "/patients/new", method = RequestMethod.GET)
    public String prepareAddForm(ModelMap map){
        PatientView patientView = new PatientView();
        patientView.setPatientId(0L);
        
        map.addAttribute("patient", patientView);
        map.addAttribute("insurers", insurerFacade.getInsurers());
        
        return "patients/editOrAddPatient";
    }
    
    @RequestMapping(value = "/patients/new", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute("patient") PatientView patient){
        patientFacade.addPatient(patient);
        
        return "redirect:/patients";
    }
    
    @RequestMapping("/patients/{patientId}")
    public String showPatient(@PathVariable("patientId") Long patientId, ModelMap map){
        map.addAttribute("patient", patientFacade.getPatient(patientId));
        
        return "patients/patient";
    }
    
    @RequestMapping(value = "/patients/{patientId}/edit", method = RequestMethod.GET)
    public String prepareEditForm(@PathVariable("patientId") Long patientId, ModelMap map){
        map.addAttribute("patient", patientFacade.getPatient(patientId));
        map.addAttribute("insurers", insurerFacade.getInsurers());
        
        return "patients/editOrAddPatient";
    }
    
    @RequestMapping(value = "/patients/{patientId}/edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute("patient") PatientView patient){
        patientFacade.updatePatient(patient);
        
        return "redirect:/patients/{patientId}";
    }
    
    @RequestMapping("patients/{patientId}/delete")
    public String deletePatient(@PathVariable("patientId") Long patientId){
        patientFacade.deletePatient(patientFacade.getPatient(patientId));
        
        return "redirect:/patients";
    }
}

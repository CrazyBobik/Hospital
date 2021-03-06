package hospital.web.controller;

import hospital.facade.DoctorFacade;
import hospital.facade.GraphikFacade;
import hospital.facade.PatientFacade;
import hospital.view.GraphikView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* Created on 09.01.2015.
*
* @author Crazy Bobik
*         (.)(.)
*         =)
*/

@Controller
public class GraphikController {

    @Autowired
    private GraphikFacade graphikFacade;

    @Autowired
    private PatientFacade patientFacade;

    @Autowired
    private DoctorFacade doctorFacade;
    
    @RequestMapping(value = "/graphiks/new", method = RequestMethod.GET)
    public String prepareAddGraphik(ModelMap map){
        map.addAttribute("patients", patientFacade.getPatients());
        map.addAttribute("doctors", doctorFacade.getDoctors());
        
        return "graphiks/addGraphik";
    }
    
    @RequestMapping(value = "/graphiks/new", method = RequestMethod.POST)
    public String processAddGraphik(@ModelAttribute("graphik") GraphikView graphik){
        graphikFacade.addGraphik(graphik);
        
        return "graphiks/addOK";
    }
    
    @RequestMapping(value = "/patients/{patientId}/graphiks")
    public String showGraphiksForPatient(@PathVariable Long patientId, ModelMap map){
        map.addAttribute("patient", patientFacade.getPatient(patientId));
        
        return "graphiks/graphiksForPatient";
    }
    
    @RequestMapping("/patients/{patientId}/graphiks/{graphikId}/delete")
    public String deleteGraphik(@PathVariable Long graphikId){
        graphikFacade.deleteGraphik(graphikFacade.getGraphik(graphikId));
        
        return "redirect:/patients/{patientId}/graphiks";
    }
    
    @RequestMapping("/doctors/{doctorId}/graphiks")
    public String showGraphiksForDoctor(@PathVariable Long doctorId, ModelMap map){
        map.addAttribute("doctor", doctorFacade.getDoctor(doctorId));
        
        return "graphiks/graphiksForDoctor";
    }
}

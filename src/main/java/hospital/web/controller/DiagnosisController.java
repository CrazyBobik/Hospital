package hospital.web.controller;

import hospital.facade.DiagnosisFacade;
import hospital.facade.DoctorFacade;
import hospital.facade.PatientFacade;
import hospital.view.DiagnosisView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private DoctorFacade doctorFacade;

    @RequestMapping(value = "/patients/{patientId}/diagnosis/new", method = RequestMethod.GET)
    public String prepareAddForm(@PathVariable("patientId") Long patientId, ModelMap map){
        DiagnosisView d = new DiagnosisView();
        d.setDiagnosisId(0L);
        
        map.addAttribute("diagnosis", d);
        map.addAttribute("patient", patientFacade.getPatient(patientId));
        map.addAttribute("doctors", doctorFacade.getDoctors());
        
        return "diagnosises/editOrAddDiagnosis";
    }
    
    @RequestMapping(value = "/patients/{patientId}/diagnosis/new", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute("diagnosis") DiagnosisView diagnosis){
        diagnosisFacade.addDiagnosis(diagnosis);
        
        return "redirect:/patients/{patientId}";
    } 
    
    @RequestMapping(value = "/patients/{patientId}/diagnosis/{diagnosisId}/edit", method = RequestMethod.GET)
    public String prepareEditForm(@PathVariable("diagnosisId") Long diagnosisId, 
                                  @PathVariable("patientId") Long patientId, ModelMap map){
        map.addAttribute("diagnosis", diagnosisFacade.getDiagnosis(diagnosisId));
        map.addAttribute("patient", patientFacade.getPatient(patientId));
        map.addAttribute("doctors", doctorFacade.getDoctors());
        
        return "diagnosises/editOrAddDiagnosis";
    }
    
    @RequestMapping(value = "/patients/{patientId}/diagnosis/{diagnosisId}/edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute("diagnosis") DiagnosisView diagnosis){
        diagnosisFacade.updateDiagnosis(diagnosis);
        
        return "redirect:/patients/{patientId}";
    }
    
    @RequestMapping("/patients/{patientId}/diagnosis/{diagnosisId}/delete")
    public String deleteDiagnosis(@PathVariable("diagnosisId") Long diagnosisId){
        diagnosisFacade.deleteDiagnosis(diagnosisFacade.getDiagnosis(diagnosisId));
        
        return "redirect:/patients/{patientId}";
    }
}

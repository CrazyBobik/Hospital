package hospital.web.controller;

import hospital.facade.DiagnosisFacade;
import hospital.facade.DoctorFacade;
import hospital.facade.PatientFacade;
import hospital.view.DiagnosisView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private DiagnosisFacade diagnosisFacade;
    
    @Autowired
    private DoctorFacade doctorFacade;
    
    @RequestMapping("/patient")
    public String patientPage(@RequestParam(value = "patientId", required = false) Long id, 
                              @RequestParam(value = "diagnosisId", required = false) Long dId,
                              @RequestParam(value = "graphik", required = false) Object graphik,
                              @RequestParam(value = "del", required = false) Object del, 
                              @RequestParam(value = "edit", required = false) Object edit, 
                              @RequestParam(value = "add", required = false) Object add, ModelMap map){
        
        if (graphik != null){
            map.addAttribute("target", patientFacade.getPatient(id));
            
            return "graphik";
        } else if (del != null){
            try {
                diagnosisFacade.deleteDiagnosis(diagnosisFacade.getDiagnosis(dId));
            } catch (Exception e){
               
            }
        } else if (edit != null) {
            try {
                map.addAttribute("diagnosis", diagnosisFacade.getDiagnosis(dId));
                map.addAttribute("doctors", doctorFacade.getDoctors());
                map.addAttribute("patients", patientFacade.getPatients());
                
                return "editDiagnosis";
            } catch (Exception e){
                
            }
        } else if (add != null) {
            map.addAttribute("doctors", doctorFacade.getDoctors());
            map.addAttribute("patients", patientFacade.getPatients());
            
            DiagnosisView d = new DiagnosisView();
            d.setPatientId(id);
            d.setDiagnosisId(0l);
            map.addAttribute("diagnosis", d);
            
            return "editDiagnosis";
        }
        
        map.addAttribute("patient", patientFacade.getPatient(id));
        
        return "patient";
    }
}

package hospital.web.controller;

import hospital.facade.DiagnosisFacade;
import hospital.facade.PatientFacade;
import hospital.view.DiagnosisView;
import hospital.view.PatientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
    
    @RequestMapping("/patient")
    public String patientPage(@RequestParam(value = "patientId", required = false) Long id, 
                              HttpServletRequest request, ModelMap map){

        if (request.getAttribute("del") != null){
            DiagnosisView diagnosisView = diagnosisFacade.getDiagnosis((Long) request.getAttribute("diagnosisId"));
            diagnosisFacade.deleteDiagnosis(diagnosisView);
            return "main";
        }
        PatientView view = patientFacade.getPatient(id);
        map.addAttribute("patient", view);
        
        return "patient";
    }
}

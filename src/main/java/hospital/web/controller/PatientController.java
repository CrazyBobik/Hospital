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
                              @RequestParam(value = "ids", required = false) String ids,
                              @RequestParam(value = "del", required = false) Object del, ModelMap map){

        Long patientId;
        if (del != null){
            String[] stringId = ids.split("and");
            DiagnosisView diagnosisView = diagnosisFacade.getDiagnosis(Long.parseLong(stringId[0]));
            diagnosisFacade.deleteDiagnosis(diagnosisView);
            patientId = Long.parseLong(stringId[1]);
        } else {
            patientId = id;
        }
        PatientView view = patientFacade.getPatient(patientId);
        map.addAttribute("patient", view);
        
        return "patient";
    }
}

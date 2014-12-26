package hospital.web.controller;

import hospital.facade.PatientFacade;
import hospital.view.PatientView;
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
    
    @RequestMapping("/patient")
    public String patientPage(@RequestParam(value = "patientId") String id, ModelMap map){
        PatientView view = patientFacade.getPatient(Long.parseLong(id));
        map.addAttribute("patient", view);
        
        return "patient";
    }
}

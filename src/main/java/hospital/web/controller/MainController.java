package hospital.web.controller;

import hospital.facade.PatientFacade;
import hospital.view.PatientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created on 25.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */
@Controller
public class MainController {
    
    @Autowired
    private PatientFacade patientFacade;
    
    @RequestMapping("/main")
    public String printAllPatients(ModelMap model){

        List<PatientView> list = patientFacade.getPatients();
        model.addAttribute("patientList", list);
        
        return "main";
    }
}

package hospital.web.controller;

import hospital.facade.DoctorFacade;
import hospital.facade.GraphikFacade;
import hospital.facade.PatientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/addgraphik")
    public String add(ModelMap map){
        
        return "editGraphik";
    }
}

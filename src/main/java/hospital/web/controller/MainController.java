package hospital.web.controller;

import hospital.entity.Patient;
import hospital.facade.InsurerFacade;
import hospital.facade.PatientFacade;
import hospital.view.PatientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @Autowired
    private InsurerFacade insurerFacade;
    
    @RequestMapping("/main")
    public String printAllPatients(@RequestParam(value = "patientId", required = false) Long patientId,
                                   @RequestParam(value = "del", required = false) Object del,
                                   @RequestParam(value = "edit", required = false) Object edit,
                                   @RequestParam(value = "add", required = false) Object add, ModelMap map){

        if (del != null){
            try {
                patientFacade.deletePatient(patientFacade.getPatient(patientId));
            } catch (Exception e){
                
            }
        } else if (edit != null){
            try {
                map.addAttribute("patient", patientFacade.getPatient(patientId));
                map.addAttribute("insurers", insurerFacade.getInsurers());
                
                return "editPatient";
            } catch (Exception e){
                
            }
        } else if (add != null){
            PatientView p = new PatientView();
            p.setPatientId(0L);
            map.addAttribute("patient", p);
            map.addAttribute("insurers", insurerFacade.getInsurers());
            
            return "editPatient";
        }

        map.addAttribute("patientList", patientFacade.getPatients());
        
        return "main";
    }
    
    @RequestMapping("/editPatient")
    public String edit(@RequestParam(value = "patientId") Long patientId,
                       @RequestParam(value = "fio") String fio,
                       @RequestParam(value = "address", required = false) String address,
                       @RequestParam(value = "contacts", required = false) String contacts,
                       @RequestParam(value = "insurerId", required = false) String insurerId,
                       @RequestParam(value = "ok", required = false) Object ok, ModelMap map){

        if (patientId != null && ok != null){
            PatientView p = new PatientView();
            p.setPatientId(patientId);
            p.setFio(fio);
            if (address.equals("")){
                p.setAddress(null);
            } else {
                p.setAddress(address);
            }
            if (contacts.equals("")){
                p.setContacts(null);
            } else {
                p.setContacts(contacts);
            }
            if (!insurerId.equals("not")) {
                p.setInsurerId(Long.parseLong(insurerId));
            } else {
                p.setInsurerId(null);
            }

            if (patientId > 0){
                patientFacade.updatePatient(p);
            } else {
                patientFacade.addPatient(p);
            }
        }

        map.addAttribute("patientList", patientFacade.getPatients());

        return "main";
    }
}

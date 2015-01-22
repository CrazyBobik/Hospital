//package hospital.web.controller;
//
//import hospital.facade.InsurerFacade;
//import hospital.facade.PatientFacade;
//import hospital.view.PatientView;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * Created on 25.12.2014.
// *
// * @author Crazy Bobik
// *         (.)(.)
// *         =)
// */
//@Controller
//public class MainController {
//
//    @Autowired
//    private PatientFacade patientFacade;
//
//    @Autowired
//    private InsurerFacade insurerFacade;
//
//    @RequestMapping("/main")
//    public String printAllPatients(@RequestParam(value = "patientId", required = false) Long patientId,
//                                   @RequestParam(value = "del", required = false) Object del,
//                                   @RequestParam(value = "edit", required = false) Object edit,
//                                   @RequestParam(value = "add", required = false) Object add, ModelMap map){
//
//        if (del != null){
//            try {
//                patientFacade.deletePatient(patientFacade.getPatient(patientId));
//            } catch (Exception e){
//
//            }
//        } else if (edit != null){
//            try {
//                map.addAttribute("patient", patientFacade.getPatient(patientId));
//                map.addAttribute("insurers", insurerFacade.getInsurers());
//
//                return "patients/editPatient";
//            } catch (Exception e){
//
//            }
//        } else if (add != null){
//            PatientView p = new PatientView();
//            p.setPatientId(0L);
//            map.addAttribute("patient", p);
//            map.addAttribute("insurers", insurerFacade.getInsurers());
//
//            return "patients/editPatient";
//        }
//
//        map.addAttribute("patientList", patientFacade.getPatients());
//
//        return "patients/main";
//    }
//
//    @RequestMapping("/editPatient")
//    public String edit(@ModelAttribute("patient") PatientView patient,
//                       @RequestParam(value = "ok", required = false) Object ok, ModelMap map){
//
//        if (ok != null){
//
//            if (patient.getPatientId() > 0){
//                patientFacade.updatePatient(patient);
//            } else {
//                patientFacade.addPatient(patient);
//            }
//        }
//
//        map.addAttribute("patientList", patientFacade.getPatients());
//
//        return "patients/main";
//    }
//}

//package hospital.web.controller;
//
//import hospital.facade.DiagnosisFacade;
//import hospital.facade.PatientFacade;
//import hospital.view.DiagnosisView;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * Created on 28.12.2014.
// *
// * @author Crazy Bobik
// *         (.)(.)
// *         =)
// */
//@Controller
//public class DiagnosisController {
//
//    @Autowired
//    private DiagnosisFacade diagnosisFacade;
//
//    @Autowired
//    private PatientFacade patientFacade;
//
//    @RequestMapping(value = "/editDiagnosis")
//    public String edit(@RequestParam(value = "diagnosisId") Long diagnosisId,
//                       @RequestParam(value = "name") String name,
//                       @RequestParam(value = "text") String text,
//                       @RequestParam(value = "patientId") Long patientId,
//                       @RequestParam(value = "doctorId", required = false) String doctorId,
//                       @RequestParam(value = "ok", required = false) Object ok, ModelMap map){
//
//        if (diagnosisId != null && ok != null){
//            DiagnosisView d = new DiagnosisView();
//            d.setDiagnosisId(diagnosisId);
//            d.setName(name.trim());
//            d.setText(text.trim());
//            if (!doctorId.equals("not")) {
//                d.setDoctorId(Long.parseLong(doctorId));
//            } else {
//                d.setDoctorId(null);
//            }
//            d.setPatientId(patientId);
//
//            if (diagnosisId > 0){
//                diagnosisFacade.updateDiagnosis(d);
//            } else {
//                diagnosisFacade.addDiagnosis(d);
//            }
//        }
//
//        map.addAttribute("patient", patientFacade.getPatient(patientId));
//
//        return "patients/patient";
//    }
//}

//package hospital.web.controller;
//
//import hospital.facade.DoctorFacade;
//import hospital.facade.GraphikFacade;
//import hospital.facade.PatientFacade;
//import hospital.view.GraphikView;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
///**
// * Created on 09.01.2015.
// *
// * @author Crazy Bobik
// *         (.)(.)
// *         =)
// */
//
//@Controller
//public class GraphikController {
//
//    @Autowired
//    private GraphikFacade graphikFacade;
//
//    @Autowired
//    private PatientFacade patientFacade;
//
//    @Autowired
//    private DoctorFacade doctorFacade;
//
//    @RequestMapping("/graphikPatient")
//    public String delPatientGraphik(@RequestParam(value = "patientId") Long patientId,
//                      @RequestParam(value = "graphikId", required = false) Long id,
//                      @RequestParam(value = "del", required = false) Object del, ModelMap map){
//
//        if (del != null){
//            try {
//                graphikFacade.deleteGraphik(graphikFacade.getGraphik(id));
//            } catch (Exception e) {
//            }
//        }
//
//        map.addAttribute("patient", patientFacade.getPatient(patientId));
//
//        return "graphiks/graphik";
//    }
//
//    @RequestMapping("/graphikDoctor")
//    public String delDoctorGraphik(@RequestParam(value = "doctorId") Long doctorId,
//                      @RequestParam(value = "graphikId", required = false) Long id,
//                      @RequestParam(value = "del", required = false) Object del, ModelMap map){
//
//        if (del != null){
//            try {
//                graphikFacade.deleteGraphik(graphikFacade.getGraphik(id));
//            } catch (Exception e) {
//            }
//        }
//
//        map.addAttribute("doctor", doctorFacade.getDoctor(doctorId));
//
//        return "graphiks/graphik";
//    }
//
//    @RequestMapping("/addGraphik")
//    public String add(@RequestParam(value = "patientId", required = false) Long patientId,
//                      @RequestParam(value = "doctorId", required = false) Long doctorId,
//                      @RequestParam(value = "day", required = false) Integer day,
//                      @RequestParam(value = "month", required = false) Integer month,
//                      @RequestParam(value = "ok", required = false) Object add, ModelMap map){
//
//        if (add != null){
//            GraphikView gv = new GraphikView();
//            gv.setPatientId(patientId);
//            gv.setDoctorId(doctorId);
//
//            Calendar calendar = new GregorianCalendar();
//            calendar.set(Calendar.MONTH, month);
//            calendar.set(Calendar.DAY_OF_MONTH, day);
//            gv.setDate(calendar.getTime());
//
//            graphikFacade.addGraphik(gv);
//
//            return "graphiks/addOK";
//        }
//
//        map.addAttribute("patients", patientFacade.getPatients());
//        map.addAttribute("doctors", doctorFacade.getDoctors());
//
//        int[] days = new int[31];
//        int[] months = new int[12];
//        for (int i = 0; i < 31; i++) {
//            days[i] = i + 1;
//        }
//        for (int i = 0; i < 12; i++) {
//            months[i] = i;
//        }
//
//        map.addAttribute("days", days);
//        map.addAttribute("months", months);
//
//        return "graphiks/editGraphik";
//    }
//}

package hospital.web.controller;

import hospital.facade.DoctorFacade;
import hospital.view.DoctorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 29.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */
@Controller
public class DoctorsController {
    
    @Autowired
    private DoctorFacade doctorFacade;
    
    @RequestMapping("/doctors")
    public String printAllDoctors(@RequestParam(value = "doctorId", required = false) Long doctorId,
                                  @RequestParam(value = "graphik", required = false) Object graphik,
                                  @RequestParam(value = "del", required = false) Object del,
                                  @RequestParam(value = "edit", required = false) Object edit,
                                  @RequestParam(value = "add", required = false) Object add, ModelMap map){
        if (graphik != null){
            try {
                map.addAttribute("doctor", doctorFacade.getDoctor(doctorId));

                return "graphikDoctor";
            } catch (Exception e) {

            }
        } else if (del != null){
            try {
                doctorFacade.deleteDoctor(doctorFacade.getDoctor(doctorId));
            } catch (Exception e){

            }
        } else if (edit != null){
            try {
                map.addAttribute("doctor", doctorFacade.getDoctor(doctorId));
            
                return "editDoctor";
            } catch (Exception e){

            }
        } else if (add != null){
            DoctorView d = new DoctorView();
            d.setDoctorId(0l);
            map.addAttribute("doctor", d);
            
            return "editDoctor";
        }
        
        map.addAttribute("doctorList", doctorFacade.getDoctors());
        
        return "doctors";
    }
    
    @RequestMapping("/editDoctor")
    public String edit(@RequestParam(value = "doctorId") Long doctorId,
                       @RequestParam(value = "fio") String fio,
                       @RequestParam(value = "post") String post,
                       @RequestParam(value = "ok", required = false) Object ok, ModelMap map){
        
        if (doctorId != null && ok != null){
            DoctorView d = new DoctorView();
            d.setDoctorId(doctorId);
            d.setFio(fio.trim());
            d.setPost(post.trim());
            
            if (doctorId > 0){
                doctorFacade.updateDoctor(d);
            } else {
                doctorFacade.addDoctor(d);
            }
        }
        
        map.addAttribute("doctorList", doctorFacade.getDoctors());
        
        return "doctors";
    }
}

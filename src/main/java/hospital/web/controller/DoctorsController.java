package hospital.web.controller;

import hospital.facade.DoctorFacade;
import hospital.view.DoctorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String showDoctors(ModelMap map){
        map.addAttribute("doctorList", doctorFacade.getDoctors());
        
        return "doctors/doctors";
    }
    
    @RequestMapping(value = "/doctors/new", method = RequestMethod.GET)
    public String prepareAddDoctor(ModelMap map){
        DoctorView d = new DoctorView();
        d.setDoctorId(0L);
        
        map.addAttribute("doctor", d);
        
        return "doctors/editOrAddDoctor";
    }
    
    @RequestMapping(value = "/doctors/new", method = RequestMethod.POST)
    public String processAddDoctor(@ModelAttribute("doctor") DoctorView doctor){
        doctorFacade.addDoctor(doctor);
        
        return "redirect:/doctors";
    }
    
    @RequestMapping(value = "/doctors/{doctorId}/edit", method = RequestMethod.GET)
    public String prepareEditDoctor(@PathVariable Long doctorId, ModelMap map){
        map.addAttribute("doctor", doctorFacade.getDoctor(doctorId));
        
        return "doctors/editOrAddDoctor";
    }
    
    @RequestMapping(value = "/doctors/{doctorId}/edit", method = RequestMethod.POST)
    public String processEditDoctor(@ModelAttribute("doctor") DoctorView doctor){
        doctorFacade.addDoctor(doctor);
        
        return "redirect:/doctors";
    }
    
    @RequestMapping("/doctors/{doctorId}/delete")
    public String deleteDoctor(@PathVariable Long doctorId){
        doctorFacade.deleteDoctor(doctorFacade.getDoctor(doctorId));
        
        return "redirect:/doctors";
    }
}

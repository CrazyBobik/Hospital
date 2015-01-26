package hospital.web.controller;

import hospital.facade.InsurerFacade;
import hospital.view.InsurerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* Created on 30.12.2014.
*
* @author Crazy Bobik
*         (.)(.)
*         =)
*/

@Controller
public class InsurerController {

    @Autowired
    private InsurerFacade insurerFacade;

    @RequestMapping("/insurers")
    public String showInsurers(ModelMap map){
        map.addAttribute("insurerList", insurerFacade.getInsurers());
        
        return "insurers/insurers";
    }
    
    @RequestMapping(value = "/insurers/new", method = RequestMethod.GET)
    public String prepareAddInsurer(ModelMap map){
        InsurerView i = new InsurerView();
        i.setInsurerId(0L);
        
        map.addAttribute("insurer", i);
        
        return "insurers/editOrAddInsurer";
    }
    
    @RequestMapping(value = "/insurers/new", method = RequestMethod.POST)
    public String processAddInsurer(@ModelAttribute InsurerView insurer){
        insurerFacade.addInsurer(insurer);
        
        return "redirect:/insurers";
    }
    
    @RequestMapping(value = "/insurers/{insurerId}/edit", method = RequestMethod.GET)
    public String prepareEditInsurer(@PathVariable Long insurerId, ModelMap map){
        map.addAttribute("insurer", insurerFacade.getInsurer(insurerId));
        
        return "insurers/editOrAddInsurer";
    }
    
    @RequestMapping(value = "/insurers/{insurerId}/edit", method = RequestMethod.POST)
    public String processEditInsurer(@ModelAttribute InsurerView insurer){
        insurerFacade.updateInsurer(insurer);
        
        return "redirect:/insurers";
    }
    
    @RequestMapping("/insurers/{insurerId}/delete")
    public String deleteInsurer(@PathVariable Long insurerId){
        insurerFacade.deleteInsurer(insurerFacade.getInsurer(insurerId));
        
        return "redirect:/insurers";
    }
}

package hospital.web.controller;

import hospital.facade.InsurerFacade;
import hospital.view.InsurerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String printAllInsurers(@RequestParam(value = "insurerId", required = false) Long insurerId,
                                   @RequestParam(value = "del", required = false) Object del,
                                   @RequestParam(value = "edit", required = false) Object edit,
                                   @RequestParam(value = "add", required = false) Object add, ModelMap map){
        
        if (del != null){
            try{
                insurerFacade.deleteInsurer(insurerFacade.getInsurer(insurerId));
            } catch (Exception e){
                
            }
        } else if (edit != null){
            try {
                map.addAttribute("insurer", insurerFacade.getInsurer(insurerId));
                
                return "editInsurer";
            } catch (Exception e){
                                
            }
        } else if (add != null){
            InsurerView i = new InsurerView();
            i.setInsurerId(0l);
            
            map.addAttribute("insurer", i);
            
            return "editInsurer";
        }
        
        map.addAttribute("insurerList", insurerFacade.getInsurers());
        
        return "insurers";
    }
    
    @RequestMapping("editInsurer")
    public String edit(@RequestParam(value = "insurerId") Long insurerId, 
                       @RequestParam(value = "name") String name,
                       @RequestParam(value = "contacts", required = false) String contacts,
                       @RequestParam(value = "ok", required = false) Object ok, ModelMap map){
        
        if (insurerId != null && ok != null){
            InsurerView i = new InsurerView();
            i.setInsurerId(insurerId);
            i.setName(name.trim());
            if (contacts.equals("")){
                i.setContacts(null);
            } else {
                i.setContacts(contacts.trim());
            }
            
            if (insurerId > 0){
                insurerFacade.updateInsurer(i);
            } else {
                insurerFacade.addInsurer(i);
            }
        }
        
        map.addAttribute("insurerList", insurerFacade.getInsurers());
        
        return "insurers";
    }
}

package hospital.DAO.interfaceDAO;

import hospital.entity.Doctor;
import hospital.entity.Graphik;
import hospital.entity.Patient;

import java.util.List;

/**
 * Created on 03.01.2015.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public interface GraphikDAO {
    
    public Long addGraphik(Graphik g);
    
    public void updateGraphik(Graphik g);
    
    public void deleteGraphik(Graphik g);
    
    public Graphik getGraphik(Long id);
    
    public List<Graphik> getGraphiksForPatient(Patient p);
    
    public List<Graphik> getGraphiksForDoctor(Doctor d);
}

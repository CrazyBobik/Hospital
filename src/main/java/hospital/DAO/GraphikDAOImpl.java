package hospital.DAO;

import hospital.DAO.interfaceDAO.GraphikDAO;
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

public class GraphikDAOImpl extends BaseDAO implements GraphikDAO {

    @Override
    public Long addGraphik(Graphik g) {
        Long id = (Long) template.save(g);
        template.flush();
        return id;
    }

    @Override
    public void updateGraphik(Graphik g) {
        template.saveOrUpdate(g);
        template.flush();
    }

    @Override
    public void deleteGraphik(Graphik g) {
        template.delete(g);
        template.flush();
    }

    @Override
    public Graphik getGraphik(Long id) {
        Graphik g = template.load(Graphik.class, id);
        template.flush();
        return g;
    }

    @Override
    public List<Graphik> getGraphiksForPatient(Patient p) {
        List<Graphik> g = (List<Graphik>) template.findByNamedParam("FROM Graphik g WHERE g.patient = :patient " +
        "ORDER BY g.a_time", "patient", p);
        template.flush();
        return g;
    }

    @Override
    public List<Graphik> getGraphiksForDoctor(Doctor d) {
        List<Graphik> g = (List<Graphik>) template.findByNamedParam("FROM Graphik g WHERE g.doctor = :doctor " +
        "ORDER BY g.a_time", "doctor", d);
        template.flush();
        return g;
    }
}

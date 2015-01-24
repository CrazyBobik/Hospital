package hospital.facade;

import hospital.DAO.interfaceDAO.DoctorDAO;
import hospital.DAO.interfaceDAO.GraphikDAO;
import hospital.DAO.interfaceDAO.PatientDAO;
import hospital.entity.Graphik;
import hospital.view.GraphikView;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created on 04.01.2015.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class GraphikFacade {
    
    private GraphikDAO graphikDAO;
    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;

    public void setGraphikDAO(GraphikDAO graphikDAO) {
        this.graphikDAO = graphikDAO;
    }

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public void setDoctorDAO(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public Long addGraphik(GraphikView gv){
        gv.setGraphikId(null);
        return graphikDAO.addGraphik(createGraphikFromView(gv));        
    }
    
    public void updateGraphik(GraphikView gv){
        graphikDAO.updateGraphik(createGraphikFromView(gv));
    }
    
    public void deleteGraphik(GraphikView gv){
        graphikDAO.deleteGraphik(graphikDAO.getGraphik(gv.getGraphikId()));        
    }
    
    public GraphikView getGraphik(Long id){
        return new GraphikView(graphikDAO.getGraphik(id));
    }
    
    private Graphik createGraphikFromView(GraphikView gv){
        Graphik graphik = null;
        if (gv.getGraphikId() != null && gv.getGraphikId() > 0){
            graphik = graphikDAO.getGraphik(gv.getGraphikId());
        } else {
            graphik = new Graphik();
        }
        if (gv.getDay() != null){
            Calendar calendar = new GregorianCalendar();
            calendar.set(Calendar.MONTH, gv.getMonth());
            calendar.set(Calendar.DAY_OF_MONTH, gv.getDay());
            graphik.setDate(calendar.getTime());
        } else {
            graphik.setDate(gv.getDate());
        }
        graphik.setPatient(patientDAO.getPatient(gv.getPatientId()));
        graphik.setDoctor(doctorDAO.getDoctor(gv.getDoctorId()));
        
        return graphik;
    }
}

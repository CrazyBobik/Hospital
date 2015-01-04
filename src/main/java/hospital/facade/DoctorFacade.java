package hospital.facade;

import hospital.DAO.interfaceDAO.DiagnosisDAO;
import hospital.DAO.interfaceDAO.DoctorDAO;
import hospital.DAO.interfaceDAO.GraphikDAO;
import hospital.entity.Diagnosis;
import hospital.entity.Doctor;
import hospital.entity.Graphik;
import hospital.view.DoctorView;
import hospital.view.GraphikView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class DoctorFacade {

    private DoctorDAO doctorDAO;
    private DiagnosisDAO diagnosisDAO;
    private GraphikDAO graphikDAO;
    private GraphikFacade graphikFacade;

    public void setDoctorDAO(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public void setDiagnosisDAO(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }

    public void setGraphikDAO(GraphikDAO graphikDAO) {
        this.graphikDAO = graphikDAO;
    }

    public void setGraphikFacade(GraphikFacade graphikFacade) {
        this.graphikFacade = graphikFacade;
    }

    public Long addDoctor(DoctorView doctorView){
        return doctorDAO.addDoctor(createDoctorFromView(doctorView));
    }

    public void updateDoctor(DoctorView doctorView){
        doctorDAO.updateDoctor(createDoctorFromView(doctorView));
    }

    public void deleteDoctor(DoctorView doctorView){
        for (Diagnosis d : getDiagnosisesForDoctor(doctorView)) {
            d.setDoctor(null);
            diagnosisDAO.updateDiagnosis(d);
        }
        for (GraphikView view : getGraphiksForDoctor(doctorView)) {
            graphikFacade.deleteGraphik(view);
        }


        doctorDAO.deleteDoctor(doctorDAO.getDoctor(doctorView.getDoctorId()));
    }

    public DoctorView getDoctor(Long id){
        return new DoctorView(doctorDAO.getDoctor(id), true);
    }
    
    public List<DoctorView> getDoctors(){
        List<DoctorView> doctorViews = new LinkedList<DoctorView>();
        List<Doctor> list = doctorDAO.getDoctors();
        for (Doctor d : list) {
            doctorViews.add(new DoctorView(d));
        }

        return doctorViews;
    }

    public List<Diagnosis> getDiagnosisesForDoctor(DoctorView doctorView){
        return diagnosisDAO.getDiagnosisesForDoctor(createDoctorFromView(doctorView));
    }
    
    public List<GraphikView> getGraphiksForDoctor(DoctorView doctorView){
        List<GraphikView> graphikView = new LinkedList<GraphikView>();
        List<Graphik> graphikList = graphikDAO.getGraphiksForDoctor(createDoctorFromView(doctorView));
        for (Graphik g : graphikList) {
            graphikView.add(new GraphikView(g));
        }

        return graphikView;
    }

    private Doctor createDoctorFromView(DoctorView doctorView){
        Doctor doctor = null;
        if (doctorView.getDoctorId() != null && doctorView.getDoctorId() > 0){
            doctor = doctorDAO.getDoctor(doctorView.getDoctorId());
        } else {
            doctor = new Doctor();
        }
        doctor.setFio(doctorView.getFio());
        doctor.setPost(doctorView.getPost());

        return doctor;
    }
}

package hospital.facade;

import hospital.DAO.interfaceDAO.DiagnosisDAO;
import hospital.DAO.interfaceDAO.DoctorDAO;
import hospital.entity.Diagnosis;
import hospital.entity.Doctor;
import hospital.view.DoctorView;

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

    public void setDoctorDAO(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public void setDiagnosisDAO(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
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

        doctorDAO.deleteDoctor(doctorDAO.getDoctor(doctorView.getDoctorId()));
    }

    public DoctorView getDoctor(Long id){
        return new DoctorView(doctorDAO.getDoctor(id));
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

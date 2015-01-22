package hospital.facade;

import hospital.DAO.interfaceDAO.DiagnosisDAO;
import hospital.DAO.interfaceDAO.GraphikDAO;
import hospital.DAO.interfaceDAO.InsurerDAO;
import hospital.DAO.interfaceDAO.PatientDAO;
import hospital.entity.Diagnosis;
import hospital.entity.Graphik;
import hospital.entity.Patient;
import hospital.view.DiagnosisView;
import hospital.view.GraphikView;
import hospital.view.PatientView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class PatientFacade {
    private PatientDAO patientDAO;
    private InsurerDAO insurerDAO;
    private DiagnosisDAO diagnosisDAO;
    private GraphikDAO graphikDAO;
    private DiagnosisFacade diagnosisFacade;
    private GraphikFacade graphikFacade;

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public void setInsurerDAO(InsurerDAO insurerDAO) {
        this.insurerDAO = insurerDAO;
    }

    public void setDiagnosisDAO(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }

    public void setGraphikDAO(GraphikDAO graphikDAO) {
        this.graphikDAO = graphikDAO;
    }

    public void setDiagnosisFacade(DiagnosisFacade diagnosisFacade) {
        this.diagnosisFacade = diagnosisFacade;
    }

    public void setGraphikFacade(GraphikFacade graphikFacade) {
        this.graphikFacade = graphikFacade;
    }

    public Long addPatient(PatientView patientView){
        patientView.setPatientId(null);
        return patientDAO.addPatient(createPatientFromView(patientView));
    }

    public void updatePatient(PatientView patientView){
        patientDAO.updatePatient(createPatientFromView(patientView));
    }

    public void deletePatient(PatientView patientView){
        for (DiagnosisView view : getDiagnosisesForPatient(patientView)) {
            diagnosisFacade.deleteDiagnosis(view);
        }
        for (GraphikView view : getGraphiksForPatient(patientView)){
            graphikFacade.deleteGraphik(view);
        }
        patientDAO.deletePatient(patientDAO.getPatient(patientView.getPatientId()));
    }

    public PatientView getPatient(Long id){
        return new PatientView(patientDAO.getPatient(id), true, true);
    }

    public List<PatientView> getPatients(){
        List<PatientView> patientViews = new LinkedList<PatientView>();
        List<Patient> list = patientDAO.getPatients();
        for (Patient p : list) {
            patientViews.add(new PatientView(p));
        }

        return patientViews;
    }

    public List<DiagnosisView> getDiagnosisesForPatient(PatientView pv){
        List<DiagnosisView> diagnosisView = new LinkedList<DiagnosisView>();
        List<Diagnosis> diagnosisList = diagnosisDAO.getDiagnosisesForPatient(createPatientFromView(pv));
        for (Diagnosis d : diagnosisList) {
            diagnosisView.add(new DiagnosisView(d));
        }

        return diagnosisView;
    }
    
    public List<GraphikView> getGraphiksForPatient(PatientView pv){
        List<GraphikView> graphikView = new LinkedList<GraphikView>();
        List<Graphik> graphikList = graphikDAO.getGraphiksForPatient(createPatientFromView(pv));
        for (Graphik g : graphikList) {
            graphikView.add(new GraphikView(g));
        }

        return graphikView;
    }

    public Patient createPatientFromView(PatientView patientView){
        Patient patient = null;
        if (patientView.getPatientId() != null && patientView.getPatientId() > 0){
            patient = patientDAO.getPatient(patientView.getPatientId());
        } else {
            patient = new Patient();
            patient.setDiagnosisList(new LinkedList<Diagnosis>());
            patient.setGraphikList(new LinkedList<Graphik>());
        }
        patient.setFio(patientView.getFio());
        patient.setAddress(patientView.getAddress());
        patient.setContacts(patientView.getContacts());
        if (patientView.getInsurerId() != null && patientView.getInsurerId() != 0) {
            patient.setInsurer(insurerDAO.getInsurer(patientView.getInsurerId()));
        } else {
            patient.setInsurer(null);
        }

        return patient;
    }
}

package hospital.facade;

import hospital.DAO.interfaceDAO.DiagnosisDAO;
import hospital.DAO.interfaceDAO.DoctorDAO;
import hospital.DAO.interfaceDAO.PatientDAO;
import hospital.entity.Diagnosis;
import hospital.view.DiagnosisView;
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

public class DiagnosisFacade {

    private DiagnosisDAO diagnosisDAO;
    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;

    public void setDiagnosisDAO(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public void setDoctorDAO(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public Long addDiagnosis(DiagnosisView diagnosisView){
        diagnosisView.setDiagnosisId(null);
        return diagnosisDAO.addDiagnosis(createDiagnosisFromView(diagnosisView));
    }

    public void updateDiagnosis(DiagnosisView diagnosisView){
        diagnosisDAO.updateDiagnosis(createDiagnosisFromView(diagnosisView));
    }

    public void deleteDiagnosis(DiagnosisView diagnosisView){
        diagnosisDAO.deleteDiagnosis(diagnosisDAO.getDiagnosis(diagnosisView.getDiagnosisId()));
    }

    public DiagnosisView getDiagnosis(Long id){
        return new DiagnosisView(diagnosisDAO.getDiagnosis(id));
    }

    private Diagnosis createDiagnosisFromView(DiagnosisView dv){
        Diagnosis diagnosis = null;
        if (dv.getDiagnosisId() != null && dv.getDiagnosisId() > 0){
            diagnosis = diagnosisDAO.getDiagnosis(dv.getDiagnosisId());
        } else {
            diagnosis = new Diagnosis();
        }
        diagnosis.setPatient(patientDAO.getPatient(dv.getPatientId()));
        if (dv.getDoctorId() != null) {
            diagnosis.setDoctor(doctorDAO.getDoctor(dv.getDoctorId()));
        } else {
            diagnosis.setDoctor(null);
        }
        diagnosis.setName(dv.getName());
        diagnosis.setText(dv.getText());

        return diagnosis;
    }
}

package hospital.DAO.interfaceDAO;

import hospital.entity.Diagnosis;
import hospital.entity.Doctor;
import hospital.entity.Patient;

import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public interface DiagnosisDAO {

    public Long addDiagnosis(Diagnosis diagnosis);

    public void updateDiagnosis(Diagnosis diagnosis);

    public void deleteDiagnosis(Diagnosis diagnosis);

    public Diagnosis getDiagnosis(Long diagnosisId);

    public List<Diagnosis> getDiagnosisesForPatient(Patient patient);

    public List<Diagnosis> getDiagnosisesForDoctor(Doctor patient);
}

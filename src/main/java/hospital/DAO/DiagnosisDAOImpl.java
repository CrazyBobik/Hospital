package hospital.DAO;

import hospital.DAO.interfaceDAO.DiagnosisDAO;
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

public class DiagnosisDAOImpl extends BaseDAO implements DiagnosisDAO {
    @Override
    public Long addDiagnosis(Diagnosis diagnosis) {
        Long id = (Long) template.save(diagnosis);
        template.flush();
        return id;
    }

    @Override
    public void updateDiagnosis(Diagnosis diagnosis) {
        template.saveOrUpdate(diagnosis);
        template.flush();
    }

    @Override
    public void deleteDiagnosis(Diagnosis diagnosis) {
        template.delete(diagnosis);
        template.flush();
    }

    @Override
    public Diagnosis getDiagnosis(Long diagnosisId) {
        Diagnosis d = template.load(Diagnosis.class, diagnosisId);
        template.flush();
        return d;
    }

    @Override
    public List<Diagnosis> getDiagnosisesForPatient(Patient patient) {
        List<Diagnosis> list = (List<Diagnosis>) template.findByNamedParam("FROM Diagnosis d WHERE d.patient = :patient " +
                "ORDER BY d.name", "patient", patient);
        template.flush();
        return list;
    }

    @Override
    public List<Diagnosis> getDiagnosisesForDoctor(Doctor doctor) {
        List<Diagnosis> list = (List<Diagnosis>) template.findByNamedParam("FROM Diagnosis d WHERE d.doctor = :doctor " +
                "ORDER BY d.name", "doctor", doctor);
        template.flush();
        return list;
    }
}

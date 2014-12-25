package hospital.DAO;

import hospital.DAO.interfaceDAO.PatientDAO;
import hospital.entity.Insurer;
import hospital.entity.Patient;

import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class PatientDAOImpl extends BaseDAO implements PatientDAO {
    @Override
    public Long addPatient(Patient patient) {
        Long id = (Long) template.save(patient);
        template.flush();
        return id;
    }

    @Override
    public void updatePatient(Patient patient) {
        template.saveOrUpdate(patient);
        template.flush();
    }

    @Override
    public void deletePatient(Patient patient) {
        template.delete(patient);
        template.flush();
    }

    @Override
    public Patient getPatient(Long patientId) {
        Patient p = template.load(Patient.class, patientId);
        template.flush();
        return p;
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> list = (List<Patient>) template.find("FROM Patient ORDER BY fio");
        template.flush();
        return list;
    }

    @Override
    public List<Patient> getPatientsForInsurer(Insurer insurer) {
        List<Patient> list = (List<Patient>) template.findByNamedParam("FROM Patient p WHERE p.insurer = :insurer " +
                "ORDER BY p.fio", "insurer", insurer);
        template.flush();
        return list;
    }
}

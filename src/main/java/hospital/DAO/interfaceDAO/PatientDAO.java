package hospital.DAO.interfaceDAO;

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

public interface PatientDAO {

    public Long addPatient(Patient patient);

    public void updatePatient(Patient patient);

    public void deletePatient(Patient patient);

    public Patient getPatient(Long patientId);

    public List<Patient> getPatients();

    public List<Patient> getPatientsForInsurer(Insurer insurer);
}

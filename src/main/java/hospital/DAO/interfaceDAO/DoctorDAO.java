package hospital.DAO.interfaceDAO;

import hospital.entity.Doctor;

import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public interface DoctorDAO {

    public Long addDoctor(Doctor doctor);

    public void updateDoctor(Doctor doctor);

    public void deleteDoctor(Doctor doctor);

    public Doctor getDoctor(Long doctorId);

    public List<Doctor> getDoctors();
}

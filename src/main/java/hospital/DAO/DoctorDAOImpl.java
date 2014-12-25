package hospital.DAO;

import hospital.DAO.interfaceDAO.DoctorDAO;
import hospital.entity.Doctor;

import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class DoctorDAOImpl extends BaseDAO implements DoctorDAO {
    @Override
    public Long addDoctor(Doctor doctor) {
        Long id = (Long) template.save(doctor);
        template.flush();
        return id;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        template.saveOrUpdate(doctor);
        template.flush();
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        template.delete(doctor);
        template.flush();
    }

    @Override
    public Doctor getDoctor(Long doctorId) {
        Doctor d = template.load(Doctor.class, doctorId);
        template.flush();
        return d;
    }
}

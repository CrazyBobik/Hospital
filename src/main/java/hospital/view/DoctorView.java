package hospital.view;

import hospital.entity.Doctor;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class DoctorView {

    private Long doctorId;
    private String fio;
    private String post;

    public DoctorView() {
    }

    public DoctorView(Doctor d) {
        this.doctorId = d.getDoctorId();
        this.fio = d.getFio();
        this.post = d.getPost();
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}

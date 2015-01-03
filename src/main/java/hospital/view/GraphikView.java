package hospital.view;

import hospital.entity.Graphik;

import java.util.Date;

/**
 * Created on 03.01.2015.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class GraphikView {
    
    private Long graphikId;
    private Long patientId;
    private Long doctorId;
    private String doctorName;
    private String doctorPost;
    private Date date;

    public GraphikView() {
    }

    public GraphikView(Graphik g) {
        
        this.graphikId = g.getGraphikId();
        this.patientId = g.getPatient().getPatientId();
        this.doctorId = g.getDoctor().getDoctorId();
        this.doctorName = g.getDoctor().getFio();
        this.doctorPost = g.getDoctor().getPost();
        this.date = g.getDate();
    }

    public Long getGraphikId() {
        return graphikId;
    }

    public void setGraphikId(Long graphikId) {
        this.graphikId = graphikId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPost() {
        return doctorPost;
    }

    public void setDoctorPost(String doctorPost) {
        this.doctorPost = doctorPost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
package hospital.view;

import hospital.entity.Diagnosis;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class DiagnosisView {

    private Long diagnosisId;
    private Long patientId;
    private Long doctorId;
    private String doctorName;
    private String doctorPost;
    private String name;
    private String text;

    public DiagnosisView() {
    }

    public DiagnosisView(Diagnosis d) {
        this.diagnosisId = d.getDiagnosisId();
        this.patientId = d.getPatient().getPatientId();
        if (d.hasDoctor()) {
            this.doctorId = d.getDoctor().getDoctorId();
            this.doctorName = d.getDoctor().getFio();
            this.doctorPost = d.getDoctor().getPost();
        }
        this.name = d.getName();
        this.text = d.getText();
    }

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

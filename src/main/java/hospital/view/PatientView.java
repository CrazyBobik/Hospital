package hospital.view;

import hospital.entity.Diagnosis;
import hospital.entity.Graphik;
import hospital.entity.Patient;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class PatientView {

    private Long patientId;
    private String fio;
    private String address;
    private String contacts;
    private Long insurerId;
    private String insurerName;
    private List<DiagnosisView> diagnosisViewList;
    private List<GraphikView> graphikViewList;

    public PatientView() {
    }

    public PatientView(Patient p){
        this(p, false, false);
    }

    public PatientView(Patient p, boolean full, boolean fullG) {
        this.patientId = p.getPatientId();
        this.fio = p.getFio();
        if (p.getAddress() == null || p.getAddress().equals("")) {
            this.address = "Не указан";
        } else {
            this.address = p.getAddress();
        }
        if (p.getContacts() == null || p.getContacts().equals("")){
            this.contacts = "Не указаны";
        } else {
            this.contacts = p.getContacts();
        }
        if (p.hasInsurer()) {
            this.insurerId = p.getInsurer().getInsurerId();
            this.insurerName = p.getInsurer().getName();
        } else {
            this.insurerName = "Нет страховщика";
        }
        if (full) {
            diagnosisViewList = new LinkedList<DiagnosisView>();
            List<Diagnosis> diagnosisList = p.getDiagnosisList();
            for (Diagnosis d : diagnosisList) {
                diagnosisViewList.add(new DiagnosisView(d));
            }
        }

        if (fullG){
            graphikViewList = new LinkedList<GraphikView>();
            List<Graphik> graphikList = p.getGraphikList();
            for (Graphik g : graphikList) {
                graphikViewList.add(new GraphikView(g));
            }
        }
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Long getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(Long insurerId) {
        this.insurerId = insurerId;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public List<DiagnosisView> getDiagnosisViewList() {
        return diagnosisViewList;
    }

    public void setDiagnosisViewList(List<DiagnosisView> diagnosisViewList) {
        this.diagnosisViewList = diagnosisViewList;
    }

    public List<GraphikView> getGraphikViewList() {
        return graphikViewList;
    }

    public void setGraphikViewList(List<GraphikView> graphikViewList) {
        this.graphikViewList = graphikViewList;
    }
}

package hospital.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 03.01.2015.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

@Entity
@Table(name = "graphik")
public class Graphik {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "graphik_id")
    private Long graphikId;
    
    @Column(name = "a_time")
    private Date date;
    
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Long getGraphikId() {
        return graphikId;
    }

    public void setGraphikId(Long graphikId) {
        this.graphikId = graphikId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

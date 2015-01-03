package hospital.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created on 20.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "fio")
    private String fio;

    @Column(name = "post")
    private String post;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<Graphik> graphikList;

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

    public List<Graphik> getGraphikList() {
        return graphikList;
    }

    public void setGraphikList(List<Graphik> graphikList) {
        this.graphikList = graphikList;
    }
}


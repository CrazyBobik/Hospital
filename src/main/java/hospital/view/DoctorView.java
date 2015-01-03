package hospital.view;

import hospital.entity.Doctor;
import hospital.entity.Graphik;

import java.util.LinkedList;
import java.util.List;

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
    private List<GraphikView> graphikViewList;

    public DoctorView() {
    }
    
    public DoctorView(Doctor d){
        this(d, false);        
    }

    public DoctorView(Doctor d, boolean full) {
        this.doctorId = d.getDoctorId();
        this.fio = d.getFio();
        this.post = d.getPost();
        
        if (full){
            graphikViewList = new LinkedList<GraphikView>();
            List<Graphik> graphikList = d.getGraphikList();
            for (Graphik g : graphikList) {
                graphikViewList.add(new GraphikView(g));
            }
        }
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

    public List<GraphikView> getGraphikViewList() {
        return graphikViewList;
    }

    public void setGraphikViewList(List<GraphikView> graphikViewList) {
        this.graphikViewList = graphikViewList;
    }
}

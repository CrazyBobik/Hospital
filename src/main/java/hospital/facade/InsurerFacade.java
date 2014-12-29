package hospital.facade;

import hospital.DAO.interfaceDAO.InsurerDAO;
import hospital.DAO.interfaceDAO.PatientDAO;
import hospital.entity.Insurer;
import hospital.entity.Patient;
import hospital.view.InsurerView;
import hospital.view.PatientView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class InsurerFacade {

    private InsurerDAO insurerDAO;
    private PatientDAO patientDAO;

    public void setInsurerDAO(InsurerDAO insurerDAO) {
        this.insurerDAO = insurerDAO;
    }

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public Long addInsurer(InsurerView insurerView){
        return insurerDAO.addInsurer(createInsurerFromView(insurerView));
    }

    public void updateInsurer(InsurerView insurerView){
        insurerDAO.updateInsurer(createInsurerFromView(insurerView));
    }

    public void deleteInsurer(InsurerView insurerView){
        for (Patient p : getPatientForInsurer(insurerView)) {
            p.setInsurer(null);
            patientDAO.updatePatient(p);
        }
        insurerDAO.deleteInsurer(insurerDAO.getInsurer(insurerView.getInsurerId()));
    }

    public InsurerView getInsurer(Long id){
        return new InsurerView(insurerDAO.getInsurer(id));
    }
    
    public List<InsurerView> getInsurers(){
        List<Insurer> list = insurerDAO.getInsurers();
        List<InsurerView> viewList = new LinkedList<InsurerView>();
        for (Insurer i : list) {
            viewList.add(new InsurerView(i));
        }

        return viewList;
    }

    public List<Patient> getPatientForInsurer(InsurerView iv){
        return patientDAO.getPatientsForInsurer(createInsurerFromView(iv));
    }

    public Insurer createInsurerFromView(InsurerView insurerView){
        Insurer insurer = null;
        if (insurerView.getInsurerId() != null && insurerView.getInsurerId() > 0){
            insurer = insurerDAO.getInsurer(insurerView.getInsurerId());
        } else {
            insurer = new Insurer();
        }
        insurer.setName(insurerView.getName());
        insurer.setContacts(insurerView.getContacts());

        return insurer;
    }
}

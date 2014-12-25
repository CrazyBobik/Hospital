package hospital.test;

import hospital.facade.DiagnosisFacade;
import hospital.facade.DoctorFacade;
import hospital.facade.InsurerFacade;
import hospital.facade.PatientFacade;
import hospital.view.DiagnosisView;
import hospital.view.DoctorView;
import hospital.view.InsurerView;
import hospital.view.PatientView;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */
@ContextConfiguration(locations = {"/HospitalConfig.xml", "/HospitalDatabase.xml"})
@TransactionConfiguration(transactionManager = "txManager")
public class HospitalTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private DiagnosisFacade diagnosisFacade;

    @Autowired
    private DoctorFacade doctorFacade;

    @Autowired
    private InsurerFacade insurerFacade;

    @Autowired
    private PatientFacade patientFacade;

    @Test
    public void Test1(){
        //проверяем добавление страховщика
        InsurerView insurerView = new InsurerView();
        insurerView.setName("Test Name");
        insurerView.setContacts("Test Contacts");
        Long idInsurer = insurerFacade.addInsurer(insurerView);
        insurerView = insurerFacade.getInsurer(idInsurer);
        Assert.assertTrue(insurerView.getName().equals("Test Name") && insurerView.getContacts().equals("Test Contacts"));

        //проверяем редактирование
        insurerView.setContacts(null);
        insurerFacade.updateInsurer(insurerView);
        Assert.assertTrue(insurerFacade.getInsurer(idInsurer).getContacts() == null);

        //проверяем добавление доктора
        DoctorView doctorView = new DoctorView();
        doctorView.setFio("Test doctor");
        doctorView.setPost("Test post");
        Long idDoctor = doctorFacade.addDoctor(doctorView);
        doctorView = doctorFacade.getDoctor(idDoctor);
        Assert.assertTrue(doctorView.getFio().equals("Test doctor") && doctorView.getPost().equals("Test post"));

        //проверяем редактирование
        doctorView.setPost("Test Post");
        doctorView.setFio("Test fio");
        doctorFacade.updateDoctor(doctorView);
        doctorView = doctorFacade.getDoctor(idDoctor);
        Assert.assertTrue(doctorView.getFio().equals("Test fio") && doctorView.getPost().equals("Test Post"));

        //проверяем пациента
        //берем всех пациенов
        int sizeBefore = patientFacade.getPatients().size();
        //добавим нового
        PatientView patientView = new PatientView();
        patientView.setFio("Test fio");
        patientView.setAddress("Test address");
        patientView.setContacts("Test contacts");
        patientView.setInsurerId(1l);
        Long idPatient = patientFacade.addPatient(patientView);
        patientView = patientFacade.getPatient(idPatient);
        Assert.assertTrue(patientView.getFio().equals("Test fio") && patientView.getAddress().equals("Test address")
                && patientView.getContacts().equals("Test contacts") && patientView.getInsurerId() == 1);
        Assert.assertTrue(patientFacade.getPatients().size() == (sizeBefore + 1));

        //редактируем
        patientView.setFio("Test FIO");
        patientView.setInsurerId(idInsurer);
        patientFacade.updatePatient(patientView);
        patientView = patientFacade.getPatient(idPatient);
        Assert.assertTrue(patientView.getFio().equals("Test FIO") && patientView.getAddress().equals("Test address")
                && patientView.getContacts().equals("Test contacts") && patientView.getInsurerId().equals(idInsurer));
        Assert.assertTrue(patientFacade.getPatients().size() == (sizeBefore + 1));

        //проверяем диагноз
        DiagnosisView diagnosisView = new DiagnosisView();
        diagnosisView.setPatientId(idPatient);
        diagnosisView.setDoctorId(idDoctor);
        diagnosisView.setName("Test name");
        diagnosisView.setText("Test text");
        Long idDiagnosis = diagnosisFacade.addDiagnosis(diagnosisView);
        diagnosisView = diagnosisFacade.getDiagnosis(idDiagnosis);
        Assert.assertTrue(diagnosisView.getPatientId().equals(idPatient) && diagnosisView.getDoctorId().equals(idDoctor)
                && diagnosisView.getName().equals("Test name") && diagnosisView.getText().equals("Test text"));
        Assert.assertTrue(patientFacade.getDiagnosisesForPatient(patientView).size() == 1);

        //редактируем
        diagnosisView.setName("Test NAME");
//        diagnosisView.setDoctorId(1L);
        diagnosisFacade.updateDiagnosis(diagnosisView);
        diagnosisView = diagnosisFacade.getDiagnosis(idDiagnosis);
        Assert.assertTrue(diagnosisView.getPatientId().equals(idPatient) && diagnosisView.getDoctorId().equals(idDoctor)
                && diagnosisView.getName().equals("Test NAME") && diagnosisView.getText().equals("Test text"));
        Assert.assertTrue(patientFacade.getDiagnosisesForPatient(patientView).size() == 1);

        //добавим ещо 1 диагноз
        diagnosisView.setName("Test name 2");
        diagnosisView.setText("Test text 2");
        Long idDiagnosis2 = diagnosisFacade.addDiagnosis(diagnosisView);
        diagnosisView = diagnosisFacade.getDiagnosis(idDiagnosis2);
        Assert.assertTrue(diagnosisView.getPatientId().equals(idPatient) && diagnosisView.getDoctorId().equals(idDoctor)
                && diagnosisView.getName().equals("Test name 2") && diagnosisView.getText().equals("Test text 2"));
        Assert.assertTrue(patientFacade.getDiagnosisesForPatient(patientView).size() == 2);

        //удалим доктора
        doctorView = doctorFacade.getDoctor(idDoctor);
        doctorFacade.deleteDoctor(doctorView);

        //удалим страховщика
        insurerFacade.deleteInsurer(insurerView);

        //удалим пациента
        patientView = patientFacade.getPatient(idPatient);
        patientFacade.deletePatient(patientView);
        Assert.assertTrue(patientFacade.getPatients().size() == sizeBefore);
    }
}

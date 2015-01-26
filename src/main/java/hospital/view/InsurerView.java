package hospital.view;

import hospital.entity.Insurer;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class InsurerView {

    private Long insurerId;
    private String name;
    private String contacts;

    public InsurerView() {
    }

    public InsurerView(Insurer i) {
        this.insurerId = i.getInsurerId();
        this.name = i.getName();
        if (i.getContacts() == null || i.getContacts().equals("")){
            this.contacts = "Не указаны";
        } else {
            this.contacts = i.getContacts();
        }
    }

    public Long getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(Long insurerId) {
        this.insurerId = insurerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}

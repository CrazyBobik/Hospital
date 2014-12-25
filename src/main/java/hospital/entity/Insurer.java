package hospital.entity;

import javax.persistence.*;

/**
 * Created on 20.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

@Entity
@Table(name = "insurer")
public class Insurer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurer_id")
    private Long insurerId;

    @Column(name = "name")
    private String name;

    @Column(name = "contacts")
    private String contacts;

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
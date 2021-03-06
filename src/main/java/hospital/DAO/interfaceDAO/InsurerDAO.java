package hospital.DAO.interfaceDAO;

import hospital.entity.Insurer;

import java.util.List;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public interface InsurerDAO {

    public Long addInsurer(Insurer insurer);

    public void updateInsurer(Insurer insurer);

    public void deleteInsurer(Insurer insurer);

    public Insurer getInsurer(Long insurerId);
    
    public List<Insurer> getInsurers();
}

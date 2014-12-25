package hospital.DAO;

import hospital.DAO.interfaceDAO.InsurerDAO;
import hospital.entity.Insurer;

/**
 * Created on 21.12.2014.
 *
 * @author Crazy Bobik
 *         (.)(.)
 *         =)
 */

public class InsurerDAOImpl extends BaseDAO implements InsurerDAO {
    @Override
    public Long addInsurer(Insurer insurer) {
        Long id = (Long) template.save(insurer);
        template.flush();
        return id;
    }

    @Override
    public void updateInsurer(Insurer insurer) {
        template.saveOrUpdate(insurer);
        template.flush();
    }

    @Override
    public void deleteInsurer(Insurer insurer) {
        template.delete(insurer);
        template.flush();
    }

    @Override
    public Insurer getInsurer(Long insurerId) {
        Insurer i = template.load(Insurer.class, insurerId);
        template.flush();
        return i;
    }
}

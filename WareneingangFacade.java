package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Wareneingang;

/**
 *
 * @author mohamed
 */
@Stateless
public class WareneingangFacade extends AbstractFacade<Wareneingang> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WareneingangFacade() {
        super(Wareneingang.class);
    }
    
}

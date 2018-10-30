package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Wareneingangspositionen;

/**
 *
 * @author mohamed
 */
@Stateless
public class WareneingangspositionenFacade extends AbstractFacade<Wareneingangspositionen> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WareneingangspositionenFacade() {
        super(Wareneingangspositionen.class);
    }
    
}

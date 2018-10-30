
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Lager;

/**
 *
 * @author mohamed
 */
@Stateless
public class LagerFacade extends AbstractFacade<Lager> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LagerFacade() {
        super(Lager.class);
    }
    
}

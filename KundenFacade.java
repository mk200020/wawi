
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Kunden;

/**
 *
 * @author mohamed
 */
@Stateless
public class KundenFacade extends AbstractFacade<Kunden> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KundenFacade() {
        super(Kunden.class);
    }
    
}

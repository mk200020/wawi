
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Lieferanten;

/**
 *
 * @author mohamed
 */
@Stateless
public class LieferantenFacade extends AbstractFacade<Lieferanten> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LieferantenFacade() {
        super(Lieferanten.class);
    }
    
}


package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Anreden;

/**
 *
 * @author mohamed
 */
@Stateless
public class AnredenFacade extends AbstractFacade<Anreden> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnredenFacade() {
        super(Anreden.class);
    }
    
}

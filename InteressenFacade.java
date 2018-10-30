
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Interessen;

/**
 *
 * @author mohamed
 */
@Stateless
public class InteressenFacade extends AbstractFacade<Interessen> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InteressenFacade() {
        super(Interessen.class);
    }
    
}

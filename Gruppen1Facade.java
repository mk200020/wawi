
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Gruppen1;

/**
 *
 * @author mohamed
 */
@Stateless
public class Gruppen1Facade extends AbstractFacade<Gruppen1> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Gruppen1Facade() {
        super(Gruppen1.class);
    }
    
}


package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Gruppen2;

/**
 *
 * @author mohamed
 */
@Stateless
public class Gruppen2Facade extends AbstractFacade<Gruppen2> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Gruppen2Facade() {
        super(Gruppen2.class);
    }
    
}

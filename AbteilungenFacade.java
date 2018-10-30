
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Abteilungen;

/**
 *
 * @author mohamed
 */
@Stateless
public class AbteilungenFacade extends AbstractFacade<Abteilungen> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbteilungenFacade() {
        super(Abteilungen.class);
    }
    
}

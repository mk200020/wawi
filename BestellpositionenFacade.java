
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Bestellpositionen;

/**
 *
 * @author mohamed
 */
@Stateless
public class BestellpositionenFacade extends AbstractFacade<Bestellpositionen> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BestellpositionenFacade() {
        super(Bestellpositionen.class);
    }
    
}

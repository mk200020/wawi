
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Bestellungen;

/**
 *
 * @author mohamed
 */
@Stateless
public class BestellungenFacade extends AbstractFacade<Bestellungen> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BestellungenFacade() {
        super(Bestellungen.class);
    }
    
}

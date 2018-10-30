package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Lagerstand;

/**
 *
 * @author mohamed
 */
@Stateless
public class LagerstandFacade extends AbstractFacade<Lagerstand> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LagerstandFacade() {
        super(Lagerstand.class);
    }
    
}

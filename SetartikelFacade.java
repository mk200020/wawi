package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Setartikel;

/**
 *
 * @author mohamed
 */
@Stateless
public class SetartikelFacade extends AbstractFacade<Setartikel> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SetartikelFacade() {
        super(Setartikel.class);
    }
    
}

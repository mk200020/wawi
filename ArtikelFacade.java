package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Artikel;

/**
 *
 * @author mohamed
 */
@Stateless
public class ArtikelFacade extends AbstractFacade<Artikel> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtikelFacade() {
        super(Artikel.class);
    }
    
}

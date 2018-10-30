
package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Artikelgruppen;

/**
 *
 * @author mohamed
 */
@Stateless
public class ArtikelgruppenFacade extends AbstractFacade<Artikelgruppen> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtikelgruppenFacade() {
        super(Artikelgruppen.class);
    }
    
}

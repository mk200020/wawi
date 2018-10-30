package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Gehaltstufen;

/**
 *
 * @author mohamed
 */
@Stateless
public class GehaltstufenFacade extends AbstractFacade<Gehaltstufen> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GehaltstufenFacade() {
        super(Gehaltstufen.class);
    }
    
}

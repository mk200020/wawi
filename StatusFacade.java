package kasmi.wawi.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasmi.wawi.model.Status;

/**
 *
 * @author mohamed
 */
@Stateless
public class StatusFacade extends AbstractFacade<Status> {

    @PersistenceContext(unitName = "wawiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatusFacade() {
        super(Status.class);
    }
    
}

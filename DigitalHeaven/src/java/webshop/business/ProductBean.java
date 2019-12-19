package webshop.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import webshop.business.model.Proizvod;
import webshop.constants.Constants;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Stateless
public class ProductBean implements ProductBeanLocal {

    
    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager em;
    
    @Override
    public List<Proizvod> listAllProducts() {
        try {
            Query query = em.createNamedQuery("Proizvod.findAll");
            List<Proizvod> result = query.getResultList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

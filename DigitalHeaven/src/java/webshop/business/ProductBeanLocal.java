package webshop.business;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import webshop.business.model.Proizvod;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Local
public interface ProductBeanLocal {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<Proizvod> listAllProducts();

}

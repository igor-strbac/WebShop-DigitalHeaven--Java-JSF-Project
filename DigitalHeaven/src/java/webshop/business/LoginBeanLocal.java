package webshop.business;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import webshop.business.model.Korisnik;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Local
public interface LoginBeanLocal {
        @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Korisnik login(final String username, final String password);

}

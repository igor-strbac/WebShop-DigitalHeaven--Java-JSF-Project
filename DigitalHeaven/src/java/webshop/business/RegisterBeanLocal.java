package webshop.business;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Local
public interface RegisterBeanLocal {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean register(final String username, final String password, final String name, final String surname, final String email, final String phoneNumber);

}

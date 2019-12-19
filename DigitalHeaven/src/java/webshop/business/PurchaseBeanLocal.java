package webshop.business;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import webshop.beans.model.ShoppingCartItem;
import webshop.business.model.Korisnik;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Local
public interface PurchaseBeanLocal {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean addPurchase(Korisnik korisnik, List<ShoppingCartItem> proizvodi, final String brojKartice);

}

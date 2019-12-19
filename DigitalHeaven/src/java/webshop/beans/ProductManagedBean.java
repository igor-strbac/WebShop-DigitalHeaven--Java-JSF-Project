package webshop.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import webshop.business.ProductBeanLocal;
import webshop.business.model.Proizvod;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Named("products")
@SessionScoped
public class ProductManagedBean implements Serializable {

    @EJB
    private ProductBeanLocal productBean;

    public List<Proizvod> getProducts() {

        return productBean.listAllProducts();
    }
}

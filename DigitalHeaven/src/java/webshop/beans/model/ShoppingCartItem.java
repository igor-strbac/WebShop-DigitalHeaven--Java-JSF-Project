package webshop.beans.model;

import java.io.Serializable;
import webshop.business.model.Proizvod;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
public class ShoppingCartItem implements Serializable {

    private Proizvod product;
    private int productNum;

    public String getProductName() {
        if (product == null) {
            return null;
        }
        return product.getNaziv();
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public int getPrice() {
        if (product == null) {
            return 0;
        }
        return product.getCena();
    }

    public int getTotalPrice() {
        return product.getCena() * productNum;
    }

    public void setProduct(Proizvod product) {
        this.product = product;
    }

    public Proizvod getProduct() {
        return product;
    }

}

package webshop.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import webshop.beans.model.ShoppingCartItem;
import webshop.business.model.Proizvod;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Named("cart")
@SessionScoped
public class ShoppingCartManagedBean implements Serializable {

    private List<ShoppingCartItem> cartItems = new ArrayList<>();

    private int productNum;

    public void addProduct(Proizvod proizvod) {
        for (ShoppingCartItem sci : cartItems) {
            if (sci.getProductName().equals(proizvod.getNaziv())) {
                sci.setProductNum(sci.getProductNum() + productNum);
                return;
            }
        }
        ShoppingCartItem newItem = new ShoppingCartItem();
        newItem.setProduct(proizvod);
        newItem.setProductNum(productNum);
        cartItems.add(newItem);
    }

    public int getTotalPrice() {
        int total = 0;
        for (ShoppingCartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void emptyCart() {
        cartItems = new ArrayList<>();
    }

    public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

}

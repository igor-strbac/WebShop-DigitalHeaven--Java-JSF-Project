package webshop.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import webshop.business.LoginBeanLocal;
import webshop.business.model.Korisnik;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@ManagedBean(name = "loginMB", eager = true)
@SessionScoped
public class LoginManagedBean implements Serializable {

    private String username;
    private String password;

    private String message = "";

    private Korisnik loggedInUser = null;

    @EJB
    private LoginBeanLocal loginBean;

    public String login() {

        if (loggedInUser != null) {
            return "success";
        }

        Korisnik korisnik = loginBean.login(username, password);

        if (korisnik == null) {
            message = "Neispravna kombinacija korisničkog imena i lozinke.";
            return "failure";
        }

        this.loggedInUser = korisnik;

        return "success";
    }

    public void logout() {
        loggedInUser = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Korisnik getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Korisnik loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    public boolean isLoggedIn() {
        return (loggedInUser != null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

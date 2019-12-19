package webshop.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import webshop.business.model.Korisnik;
import webshop.constants.Constants;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Stateless
public class LoginBean implements LoginBeanLocal {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Korisnik login(String username, String password) {

        try {
            Query query = em.createNamedQuery("Korisnik.findByKorisnickoImeLozinka");
            query.setParameter("korisnickoIme", username);
            query.setParameter("lozinka", password);

            Korisnik result = (Korisnik) query.getSingleResult();

            return result;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}

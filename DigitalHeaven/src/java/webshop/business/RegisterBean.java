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
public class RegisterBean implements RegisterBeanLocal {

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean register(String username, String password, String name, String surname, String email, String phoneNumber) {

        try {
            Query query = em.createNamedQuery("Korisnik.findByKorisnickoIme");
            query.setParameter("korisnickoIme", username);

            Korisnik k = (Korisnik) query.getSingleResult();

            if (k != null) {
                return false;
            }

        } catch (NoResultException nre) {
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try {
            Korisnik noviKorisnik = new Korisnik();
            noviKorisnik.setKorisnickoIme(username);
            noviKorisnik.setLozinka(password);
            noviKorisnik.setIme(name);
            noviKorisnik.setPrezime(surname);
            noviKorisnik.setEmail(email);
            noviKorisnik.setTelefon(phoneNumber);

            em.persist(noviKorisnik);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}

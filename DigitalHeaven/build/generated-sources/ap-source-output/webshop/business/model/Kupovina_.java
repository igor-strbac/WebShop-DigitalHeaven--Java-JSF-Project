package webshop.business.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webshop.business.model.Korisnik;
import webshop.business.model.KupovinaProizvodi;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-16T15:50:17")
@StaticMetamodel(Kupovina.class)
public class Kupovina_ { 

    public static volatile SingularAttribute<Kupovina, String> ime;
    public static volatile SingularAttribute<Kupovina, String> prezime;
    public static volatile SingularAttribute<Kupovina, String> telefon;
    public static volatile SingularAttribute<Kupovina, String> brojKartice;
    public static volatile SingularAttribute<Kupovina, Integer> id;
    public static volatile SingularAttribute<Kupovina, Integer> cena;
    public static volatile ListAttribute<Kupovina, KupovinaProizvodi> kupovinaProizvodiList;
    public static volatile SingularAttribute<Kupovina, Korisnik> idKorisnik;

}
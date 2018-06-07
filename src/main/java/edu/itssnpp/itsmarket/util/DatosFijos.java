package edu.itssnpp.itsmarket.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estela
 */
public class DatosFijos {
    
    //public static Modulo MODULO_CLIENTES=new Modulo();
    
    public static void verificarModulos(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("edu.itssnpp_ITSMarket_jar_1.0-SNAPSHOTPU");
        EntityManager em=emf.createEntityManager();
    }
    
}

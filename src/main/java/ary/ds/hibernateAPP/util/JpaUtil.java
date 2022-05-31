package ary.ds.hibernateAPP.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
//	atributo
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    
//	para optner el entity manager factori
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("ejemploJPA");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

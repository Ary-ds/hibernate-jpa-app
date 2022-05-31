package ary.ds.hibernateAPP.mapeo;

import jakarta.persistence.EntityManager;
import ary.ds.hibernateAPP.entity.Cliente;
import ary.ds.hibernateAPP.util.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
        
//    	se llama la clase entityManager
        EntityManager em = JpaUtil.getEntityManager();
        
//        se la pasa el objeto o la instancia de la clase
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        
//        cerramos la conexion 
        em.close();
    }
}

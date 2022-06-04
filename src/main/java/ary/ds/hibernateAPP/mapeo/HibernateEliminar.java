package ary.ds.hibernateAPP.mapeo;

import java.util.Scanner;

import ary.ds.hibernateAPP.entity.Cliente;
import ary.ds.hibernateAPP.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateEliminar {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		System.out.println("ingresa el id del cliente a eliminar");
		Long id = s.nextLong();
		
//	    hacemos la llamada a la conexion inicializamos 
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			
//			buscamos el id del cliente en el objecto 
			Cliente c = em.find(Cliente.class, id);
			
//			inicializamos la transacion
			em.getTransaction().begin();
//			eliminamos el cliente 
			em.remove(c);
//			hacemos la actualizacin
			em.getTransaction().commit();
			
		} catch (Exception e) {
//		    si falla volvemos a donde estabamos 
			em.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
//			cerramos la conexion 
			em.close();
		}
		

	}

}

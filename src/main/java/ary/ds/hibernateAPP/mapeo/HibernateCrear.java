package ary.ds.hibernateAPP.mapeo;

import javax.swing.JOptionPane;

import ary.ds.hibernateAPP.entity.Cliente;
import ary.ds.hibernateAPP.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateCrear {

	public static void main(String[] args) {
	    
//		llamamos la conexion de entity manager 
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
//			creamos los paramentros para ingresar en la base de datos 
			String nombre = JOptionPane.showInputDialog("ingrese el nombre");
			String apellido = JOptionPane.showInputDialog("ingrese el apellido");
			String pago = JOptionPane.showInputDialog("ingrese la forma de pago");
			
//			para empezaar 
			em.getTransaction().begin();
			
//			creamos el objeto que va recebir los paramentros 
			Cliente c = new Cliente();
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setFormaPago(pago);
			
//			guardamos los datos en el objecto 
			em.persist(c);
			
//			para hacer commit en la base de datos el insert 
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
//		     si hay fallo volve al punto anterior 
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
//			para cerrar 
			em.close();
		}

	}

}

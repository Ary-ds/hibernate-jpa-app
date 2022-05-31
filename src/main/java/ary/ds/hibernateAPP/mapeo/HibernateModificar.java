package ary.ds.hibernateAPP.mapeo;

import javax.swing.JOptionPane;

import ary.ds.hibernateAPP.entity.Cliente;
import ary.ds.hibernateAPP.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateModificar {

	public static void main(String[] args) {
	    
//		llamamos la conexion de entity manager 
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			
//			optenemos el id a modificar 
			Long id = Long.valueOf(JOptionPane.showInputDialog("ingrese el id a modificar"));
//			busca por en el objecto 
			Cliente c = em.find(Cliente.class, id);
			
//			cogemos los paramentros existentes y sus valores y dejamos listos para ingresar el nuevo parametro 
			String nombre = JOptionPane.showInputDialog("ingrese el nombre:", c.getNombre());
			String apellido = JOptionPane.showInputDialog("ingrese el apellido: ", c.getApellido());
			String pago = JOptionPane.showInputDialog("ingrese la forma de pago: ", c.getFormaPago());
			
//			para empezaar 
			em.getTransaction().begin();
			
//			creamos el objeto que va recebir los paramentros 
			c = new Cliente();
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setFormaPago(pago);
			
//			hacemos el actualiza los datos 
			em.merge(c);
			
//			para hacer commit en la base de datos hacemos el update
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

package ary.ds.hibernateAPP.main;

import java.util.List;
import java.util.Optional;

import ary.ds.hibernateAPP.entity.Cliente;
import ary.ds.hibernateAPP.services.ClienteService;
import ary.ds.hibernateAPP.services.ClienteServiceImpl;
import ary.ds.hibernateAPP.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateCrudService {

	public static void main(String[] args) {
		
//		llamamos a entityManager para usar las conexiones  la passamos la clase JpaUtil
		EntityManager em = JpaUtil.getEntityManager();
		
//		llamamos el service ma general la passamos la clase ClienteServiceImpl
		ClienteService service = new ClienteServiceImpl(em);
		
		System.out.println();
		System.out.println("=================== ver la lista =======================");
		List<Cliente> clientes = service.listar();
		clientes.forEach(System.out::println);
		
		System.out.println();
		System.out.println("=================== ver un registro =======================");
		Optional<Cliente>  optional = service.porId(25L);
		optional.ifPresent(System.out::println);
		
		System.out.println();
		System.out.println("=================== insertar  un registro =======================");
		Cliente cliente = new Cliente();
		cliente.setNombre("lucie");
		cliente.setApellido("cotton");
		cliente.setFormaPago("paypal");
//		guado el cliente 
		service.guardar(cliente);
		System.out.println("cliente guardado exito " + cliente.getNombre());
		service.listar().forEach(System.out::println);
		
		System.out.println();
		System.out.println("=================== mofificar/editar un registro =======================");
		Long id = cliente.getId();
		optional = service.porId(id);
		optional.ifPresent(c ->{
			c.setFormaPago("mercado");
			service.guardar(c);
			System.out.println("cliente modificado con exito " + c);
			service.listar().forEach(System.out::println);
			});
		
		System.out.println();
		System.out.println("=================== eliminar  un registro =======================");
		id = cliente.getId();
		optional = service.porId(id);
		optional.ifPresent(c -> {
			service.eliminar(c.getId());
			System.out.println("cliente eliminado con exito " + c);
		});
		
		
//		para cerrar la conexion 
		em.close();

	}

}

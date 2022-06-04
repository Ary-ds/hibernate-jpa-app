package ary.ds.hibernateAPP.repositories;

import java.util.List;

import ary.ds.hibernateAPP.entity.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteCrudRepositoryImpl implements CrudRepository<Cliente> {
	
//	pasamos el entityManager para la conexion
	private EntityManager em;
	
//	creamos el constructor para inicializarlo 
	public ClienteCrudRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}
	

	@Override
	public List<Cliente> lista() {
//		buscamos la lista de los clientes y cogemos el resultado de la lista 
		return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}


	@Override
	public Cliente porId(Long id) {
//		buscamos el cliente por id 
		return em.find(Cliente.class, id);
	}

	@Override
	public void guardar(Cliente cliente) {
//		si el id es diferente a null y mayor que 0 es que egiste 
		if (cliente.getId() != null && cliente.getId() >0) {
//			se hace un upadate
			em.merge(cliente);
		} else {
//			si no se crea 
            em.persist(cliente);
		}
		
	}

	@Override
	public void eliminar(Long id) {
		
//		cogemos el id del cliente 
		Cliente cliente = porId(id);
//		la borramos 
		em.remove(cliente);
		
	}

}

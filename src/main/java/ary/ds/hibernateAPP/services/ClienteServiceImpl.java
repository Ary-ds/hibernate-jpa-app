package ary.ds.hibernateAPP.services;

import java.util.List;
import java.util.Optional;

import ary.ds.hibernateAPP.entity.Cliente;
import ary.ds.hibernateAPP.repositories.ClienteCrudRepositoryImpl;
import ary.ds.hibernateAPP.repositories.CrudRepository;
import jakarta.persistence.EntityManager;

public class ClienteServiceImpl implements ClienteService {
	
//	llamamos el entityManager para manejar las transaciones
	private EntityManager em;
	
//	llamamos al crud general 
	private CrudRepository<Cliente> repository;
	
	
//	
	public ClienteServiceImpl(EntityManager em) {

	this.em = em;
	this.repository = new ClienteCrudRepositoryImpl(em);
	
}

	@Override
	public List<Cliente> listar() {
		
		return repository.lista();
	}

	@Override
	public Optional<Cliente> porId(Long id) {
		
//		convertir un objecto a opcional 
		return Optional.ofNullable(repository.porId(id));
	}

	@Override
	public void guardar(Cliente cliente) {
		
		try {
			em.getTransaction().begin();
			repository.guardar(cliente);
			em.getTransaction().commit();
			
		} catch (Exception e) {
//			volver al codigo anterior 
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar(Long id) {
		try {
			em.getTransaction().begin();
			repository.eliminar(id);
			em.getTransaction().commit();
			
		} catch (Exception e) {
//			volver al codigo anterior 
			em.getTransaction().rollback();
			e.printStackTrace();
		}


	}

}

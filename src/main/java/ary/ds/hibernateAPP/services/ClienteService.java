package ary.ds.hibernateAPP.services;

import java.util.List;
import java.util.Optional;

import ary.ds.hibernateAPP.entity.Cliente;

public interface ClienteService {
	
//	creamos los metodos del crud para cliente
	
	List<Cliente> listar();
	
//  llamamos a la clase Opcional para poder manejar el null 
	Optional<Cliente> porId(Long id);
	
	void guardar(Cliente cliente);
	
	void eliminar(Long id);

}

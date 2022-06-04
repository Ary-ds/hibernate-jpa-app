package ary.ds.hibernateAPP.repositories;

import java.util.List;

public interface CrudRepository<T>{
	
// para ver la lista 
	List<T> lista();
	
//	para ver un registro
	T porId(Long id);
	
//	para guardar 
	void guardar(T t);
	
//	para eliminar 
	void eliminar(Long id);

}

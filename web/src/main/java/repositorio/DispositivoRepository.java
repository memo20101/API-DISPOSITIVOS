package repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Dispositivo;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long>{
	
	//Spring Data Derived findBy Query Methods (prefix findBy)
	//Retrieve all records from the database based on the Author
	//https://www.websparrow.org/spring/spring-data-derived-findby-query-methods-example
	//List<Book> findByAuthor (String s);
	
	//JPQL
	//@Query ("FROM Book WHERE author = ?1")
	//List<Book> findByAuthor1 (String s);
	
	//SQL
	@Query (value="SELECT id, tipedispositivo, version,ID_pos FROM dispositivo WHERE ID_pos = ?1",nativeQuery = true)
	List<Dispositivo> findByID_pos (String s);
	@Query (value="INSERT INTO pilotonoveda.dispositivo (ID, tipedispositivo, version,ID_pos) Values (?1,?2,?3,?4)",nativeQuery = true)
	Dispositivo save (int s,String g,String a);
	
	
}

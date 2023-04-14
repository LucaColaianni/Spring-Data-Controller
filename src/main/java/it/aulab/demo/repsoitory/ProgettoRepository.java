package it.aulab.demo.repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.aulab.demo.model.Progetto;


public interface ProgettoRepository extends JpaRepository<Progetto, Long>{

	@Query(" SELECT i FROM Impiegato i WHERE i.nome = 'Luca' ")
	List<Progetto> findByImpiegatoWithFirstNameLuca();
}

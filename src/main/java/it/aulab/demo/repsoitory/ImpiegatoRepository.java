package it.aulab.demo.repsoitory;

import it.aulab.demo.model.Impiegato;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ImpiegatoRepository extends JpaRepository<Impiegato, Long>{

}

package it.aulab.demo.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	
}

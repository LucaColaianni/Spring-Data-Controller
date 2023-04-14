package it.aulab.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.aulab.demo.model.Impiegato;
import it.aulab.demo.repsoitory.ImpiegatoRepository;

@Controller
@RequestMapping(value = "impiegati")
public class ImpiegatoController {

	@Autowired
	private ImpiegatoRepository impiegatoRepository;
	
	/*
	 * CREATE -> GET
	 * READ	  -> POST
	 * UPDATE -> PUT
	 * DELETE -> DELETE
	 */


	// "/impiegati" GET - SELECT
	//@RequestMapping( method=RequestMethod.GET)
	@GetMapping 
	public @ResponseBody List<Impiegato> getAll() {
		return impiegatoRepository.findAll();
	}

	//POST - VIEW
	@PostMapping
	public @ResponseBody Impiegato post(@RequestBody Impiegato impiegato){
		return impiegatoRepository.save(impiegato);
	}

	//DELETE - DELETE
	@DeleteMapping("{id}")
	public @ResponseBody String delete(@PathVariable("id") Long id){
		 impiegatoRepository.deleteById(id);
		return "Eliminato con successo!";
	}
	
	//PUT - UPDATE
	@PutMapping("{id}")
	public @ResponseBody String put(@PathVariable("id") Long id, @RequestBody Impiegato impiegato) throws Exception{
		Optional <Impiegato> dbOptionalImpiegato = impiegatoRepository.findById(id);
		if(dbOptionalImpiegato.isPresent()){
			Impiegato dbImpiegato = dbOptionalImpiegato.get();
			dbImpiegato.setNome(impiegato.getNome());
			dbImpiegato.setCognome(impiegato.getCognome());
			dbImpiegato.setEmail(impiegato.getEmail());
			impiegatoRepository.save(dbImpiegato);
			
		return "Modifica eseguita con successo!";
		}
		throw new Exception();
	}
	
}

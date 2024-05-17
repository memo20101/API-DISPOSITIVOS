package com.recaudo.bogota.piloto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recaudo.bogota.piloto.model.Dispositivo;
import com.recaudo.bogota.piloto.repository.DispositivoRepository;


@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class DispositivoController {
	
	
	// Tells the application context to inject an instance of BookRespository here
	@Autowired
	private DispositivoRepository dispositivoRepository;

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Dispositivos")	
	public List<Dispositivo> getAllDispositivos() {
		// The BookRepository is already injected and you can use it
		return dispositivoRepository.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Dispositivo/{id}")
	public ResponseEntity<Dispositivo> getdispositivoById(@PathVariable long id) { 
		
		if (dispositivoRepository.existsById(id)) {
			Dispositivo dispositivo = dispositivoRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(dispositivo);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/Dispositivossave")
	public Dispositivo createDispositivo(@RequestBody Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/Dispositivos/{id}")
	public Dispositivo updatedisposito(@PathVariable long id, @RequestBody Dispositivo dispositivoNew) {
		Dispositivo dispositivodb = dispositivoRepository.findById(id).get();

		dispositivodb.setIsbn(dispositivoNew.getIsbn());
		dispositivodb.settipe(dispositivoNew.gettipe());
		dispositivodb.setversion(dispositivoNew.getversion());
		dispositivodb.setnovedad(dispositivoNew.getnovedad());
		dispositivodb.setID_pos(dispositivoNew.getID_pos());

		
		dispositivoRepository.save(dispositivodb);
		return dispositivodb;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/dispositos/{id}")
	public Dispositivo deleteDispositivo(@PathVariable long id) {
		Dispositivo dispositivodb = dispositivoRepository.findById(id).get();
		dispositivoRepository.delete(dispositivodb);
		return dispositivodb;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	//Query
	@GetMapping("/Dispositivoss/{s}")
	public List<Dispositivo> getfindBytipe(@PathVariable String s) {
		return dispositivoRepository.findByID_pos(s);
	}

	

	@PostMapping("/dispositivosL")
	public String createBookList(@RequestBody List<Dispositivo> dispositivos) {
		dispositivoRepository.saveAll(dispositivos);
		return "done";
	}
	
}

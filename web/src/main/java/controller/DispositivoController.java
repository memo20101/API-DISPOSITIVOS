package controller;

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
import model.Dispositivo;
import repositorio.DispositivoRepository;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class DispositivoController {
	
	
	// Tells the application context to inject an instance of BookRespository here
	@Autowired
	private DispositivoRepository dispositivoRepository;
	
	@GetMapping("/Dispositivos")
	public List<Dispositivo> getAllDispositivos() {
		// The BookRepository is already injected and you can use it
		return dispositivoRepository.findAll();
	}

	@GetMapping("/Dispositivo/{id}")
	public ResponseEntity<Dispositivo> getBookById(@PathVariable long id) { 
		
		if (dispositivoRepository.existsById(id)) {
			Dispositivo dispositivo = dispositivoRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(dispositivo);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}
	
	@PostMapping("/Dispositivos")
	public Dispositivo createDispositivo(@RequestBody Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}

	@PutMapping("/Dispositivos/{id}")
	public Dispositivo updateBook(@PathVariable long id, @RequestBody Dispositivo dispositivoNew) {
		Dispositivo dispositivodb = dispositivoRepository.findById(id).get();

		dispositivodb.setIsbn(dispositivoNew.getIsbn());
		dispositivodb.settipe(dispositivoNew.gettipe());
		dispositivodb.setversion(dispositivoNew.getversion());
		
		dispositivoRepository.save(dispositivodb);
		return dispositivodb;
	}
	
	@DeleteMapping("/books/{id}")
	public Dispositivo deleteDispositivo(@PathVariable long id) {
		Dispositivo dispositivodb = dispositivoRepository.findById(id).get();
		dispositivoRepository.delete(dispositivodb);
		return dispositivodb;
	}
	
	//Query
	@GetMapping("/Dispositivoss/{s}")
	public List<Dispositivo> getfindBytipe(@PathVariable String s) {
		return dispositivoRepository.findByID_pos(s);
	}

	
	//Load List of Books
	@PostMapping("/dispositivosL")
	public String createBookList(@RequestBody List<Dispositivo> dispositivos) {
		dispositivoRepository.saveAll(dispositivos);
		return "done";
	}
	
}
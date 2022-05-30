package com.proyecto.arte.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.arte.dto.ResonanciaDto;
import com.proyecto.arte.exception.ResonanciaNotFoundException;
import com.proyecto.arte.exception.UserNotFoundException;
import com.proyecto.arte.message.ResponseMessage;
import com.proyecto.arte.model.Resonancia;
import com.proyecto.arte.service.FilesStorageService;
import com.proyecto.arte.service.ResonanciaService;



/**
 * This  is the controller class with the endpoints of a CRUD for users.
 * @author mmoral
 * @since 1.0.0
 */

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("resonancias")
public class ResonanciaController {

		
    private static final Log log = LogFactory.getLog(ResonanciaController.class);

    private final ResonanciaService resonanciasService;
    @Autowired
    FilesStorageService storageService;
    private Resonancia resonancia;


    @Autowired
    private ModelMapper modelMapper;
   
    @Autowired
    public ResonanciaController(ResonanciaService resonanciasService) {
        this.resonanciasService = resonanciasService;
    }

    /**
     * Get a Resonancia by resonanciaId
     * @param resonanciaId
     * @return a controller
     */
    @RequestMapping(value="/{resonanciaId}",method = RequestMethod.GET)
    public ResponseEntity<Resonancia> resonanciaById(@PathVariable String resonanciaId)  throws  ResonanciaNotFoundException{
        log.info("Get resonanciaById");
        try{
        	resonancia = resonanciasService.findByUserId(resonanciaId);
        }catch(UserNotFoundException e){
        	resonancia = null;              			
        }     
        return ResponseEntity.ok(resonancia);
        
    }
    
    /**
     * Get all Resonancia
     * @return a controller
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Resonancia>> resonanciaById(){
        log.info("Get allUsers");
        return ResponseEntity.ok(resonanciasService.findAll());
    }


    /**
     * Delete an resonancia by Id
     * @param resonanciaId
     * @return empty response
     */
    @RequestMapping(value="/{resonanciaId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteResonancia(@PathVariable String resonanciaId){
    	log.info("Delete resonancia " + resonanciaId);
    	resonanciasService.deleteResonancia(resonanciaId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Save a new resonancia
     * @param resonancia
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public  ResponseEntity<ResponseMessage> saveResonancia(@RequestParam("file") MultipartFile file, 
    													   @RequestParam("nombre") String nombre, 
    													   @RequestParam("disciplina") String disciplina,
    													   @RequestParam("esAnonimo") Boolean esAnonimo,
    													   @RequestParam("lugar") String lugar){
    	String message = "";
    	try {
    		Resonancia resonancia = new Resonancia();
    		resonancia.setDisciplina(disciplina);
    		resonancia.setEsAnonimo(esAnonimo);
    		resonancia.setLugar(lugar);
    		resonancia.setNombre(nombre);
    		resonancia.setTipoMaterial(file.getContentType());
    		String path = storageService.save(file);  	
    		resonancia.setPath(path);
    		message = "Uploaded the file successfully: " + file.getOriginalFilename();
    		return ResponseEntity.ok(new ResponseMessage(message,resonanciasService.saveResonancia(resonancia)));
    	} catch (Exception e) {
    		message = "Could not upload the file: " + file.getOriginalFilename() + "!";
    	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    	 }
    }

    /**
     * Update an resonancia
     * @param resonancia
     * @return empty response
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateResonancia(@RequestBody @Valid Resonancia resonancia){
    	log.info("update resonancia " + resonancia.getResonanciaId());
        resonanciasService.updateResonancia(resonancia);
        return ResponseEntity.noContent().build();
    }   

    
    private ResonanciaDto convertToDto(Resonancia resonancia) {
		ResonanciaDto resonanciaDto = modelMapper.map(resonancia, ResonanciaDto.class);
		
	    return resonanciaDto;
	}
    
    private Resonancia convertToEntity(ResonanciaDto resonanciatDto) {
    	Resonancia resonancia = modelMapper.map(resonanciatDto, Resonancia.class);
        return resonancia;
    }

}

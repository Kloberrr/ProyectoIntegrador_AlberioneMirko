
package com.portfolio.mta.Controller;

import com.portfolio.mta.Dto.dtoHys;
import com.portfolio.mta.Entity.hys;
import com.portfolio.mta.Security.Controller.Mensaje;
import com.portfolio.mta.Service.Shys;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class CHys {
    
     @Autowired
     Shys shys;
     
     @GetMapping("/lista")
    public ResponseEntity<List<hys>> list(){
        List<hys> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys){
        
        if(StringUtils.isBlank(dtohys.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(shys.existsByNombre(dtohys.getNombre()))
            return new ResponseEntity (new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        
        hys hYs = new hys(dtohys.getNombre(), dtohys.getPorcentaje());
        shys.save(hYs);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoHys dtohys){
        //validamos si existe el id
        if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        //compara los nombres de las experiencias
        if(shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        //no puede estar vacio
        if(StringUtils.isBlank(dtohys.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        //Si pasa todas las validaciones anteriores, hace lo siguiente:
        hys hYs = shys.getOne(id).get();
        hYs.setNombre(dtohys.getNombre());
        hYs.setPorcentaje((dtohys.getPorcentaje()));
        
        
        shys.save(hYs);
        return new ResponseEntity(new Mensaje("Skill actualizada correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        
        //validamos si existe el id
        if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        shys.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<hys> getById(@PathVariable("id") int id){
        if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        hys hYs = shys.getOne(id).get();
        
        return new ResponseEntity(hYs, HttpStatus.OK);
    }
    
}

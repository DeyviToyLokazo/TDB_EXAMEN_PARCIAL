package TDB.ExamenParcial.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDB.ExamenParcial.constants.NoHardCodeo;
import TDB.ExamenParcial.model.AlumnoModel;

import TDB.ExamenParcial.services.AlumnoService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(NoHardCodeo.ALUMNO_BASE)
//@RequestMapping("alumno")
public class AlumnoController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(AlumnoController.class);
    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/findAll")
    public List<AlumnoModel> findAll(){
        List<AlumnoModel> lista = alumnoService.findAll();
        return lista;
    }

    @PostMapping("/create")
    public AlumnoModel create(@RequestBody AlumnoModel model){
        return alumnoService.add(model);
    }

    //findById
    //update
    //delete

    @GetMapping("/obtenerAlumno/{id}")
    public AlumnoModel obtenerAlumno(@PathVariable int id) {
        AlumnoModel alum = alumnoService.findById(id);
        logger.info("Obteniendo alumno con id: {}", id);
        logger.info("Retorno de la variable id: {}", alum.getIdAlumno());
        return alumnoService.findById(id);
    }

    @GetMapping("/findById/{id}")
    public AlumnoModel findById(@PathVariable Integer id) {
        return alumnoService.findById(id);
    }

    @PutMapping("/update")
    public AlumnoModel update(@RequestBody AlumnoModel model){
    return alumnoService.update(model);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = alumnoService.delete(id);
        return isDeleted ? "Usuario eliminado correctamente" : "Error al eliminar usuario";
    }
}

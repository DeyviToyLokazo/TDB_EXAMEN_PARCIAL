package TDB.ExamenParcial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import TDB.ExamenParcial.constants.NoHardCodeo;
import TDB.ExamenParcial.model.AlumnoModel;

import TDB.ExamenParcial.services.AlumnoService;


@RestController
@RequestMapping(NoHardCodeo.ALUMNO_BASE)
//@RequestMapping("alumno")
public class AlumnoController {
  
    private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);

    @Autowired
    AlumnoService alumnoService;

    @GetMapping(NoHardCodeo.GET_ALL)
    public List<AlumnoModel> findAll() {
        try {
            List<AlumnoModel> lista = alumnoService.findAll();
            return lista;
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al obtener la lista de alumnos: {}", e.getMessage(), e);
            return new ArrayList<>(); // Retornar lista vacía en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo findAll ejecutado");
        }
    }

    @PostMapping(NoHardCodeo.CREATE)
    public AlumnoModel create(@RequestBody AlumnoModel model) {
        try {
            return alumnoService.add(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al crear el alumno: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo create ejecutado");
        }
    }

    @GetMapping(NoHardCodeo.GET_BY_ID)
    public AlumnoModel findById(@PathVariable Integer id) {
        try {
            return alumnoService.findById(id);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al buscar el alumno con ID {}: {}", id, e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo findById ejecutado");
        }
    }

    @PutMapping(NoHardCodeo.UPDATE)
    public AlumnoModel update(@RequestBody AlumnoModel model) {
        try {
            return alumnoService.update(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al actualizar el alumno: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo update ejecutado");
        }
    }

    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = alumnoService.delete(id);
            return isDeleted ? "Usuario eliminado correctamente" : "Error al eliminar usuario";
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al eliminar el alumno con ID {}: {}", id, e.getMessage(), e);
            return "Ocurrio un error al intentar eliminar el usuario.";
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo delete ejecutado.");
        }
    }

    /* 
    //@GetMapping("/findAll")
    @GetMapping(NoHardCodeo.GET_ALL)
    public List<AlumnoModel> findAll() {
        try {
            List<AlumnoModel> lista = alumnoService.findAll();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de alumnos: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Retornar lista vacía en caso de error
        } finally {
            System.out.println("Metodo findAll ejecutado");
        }
    }

    //@PostMapping("/create")
    @PostMapping(NoHardCodeo.CREATE)
    public AlumnoModel create(@RequestBody AlumnoModel model) {
        try {
            return alumnoService.add(model);
        } catch (Exception e) {
            System.out.println("Error al crear el alumno: " + e.getMessage());
            e.printStackTrace();
            return null; // Retornar nulo en caso de error
        } finally {
            System.out.println("Metodo create ejecutado");
        }
    }

    //@GetMapping("/findById/{id}")
    @GetMapping(NoHardCodeo.GET_BY_ID)
    public AlumnoModel findById(@PathVariable Integer id) {
        try {
            return alumnoService.findById(id);
        } catch (Exception e) {
            System.out.println("Error al buscar el alumno con ID " + id + ": " + e.getMessage());
            e.printStackTrace();
            return null; // Retornar nulo en caso de error
        } finally {
            System.out.println("Metodo findById ejecutado");
        }
    }

    //@PutMapping("/update")
    @PutMapping(NoHardCodeo.UPDATE)
    public AlumnoModel update(@RequestBody AlumnoModel model) {
        try {
            return alumnoService.update(model);
        } catch (Exception e) {
            System.out.println("Error al actualizar el alumno: " + e.getMessage());
            e.printStackTrace();
            return null; // Retornar nulo en caso de error
        } finally {
            System.out.println("Metodo update ejecutado");
        }
    }

    //@DeleteMapping("/delete/{id}")
    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = alumnoService.delete(id);
            return isDeleted ? "Usuario eliminado correctamente" : "Error al eliminar usuario";
        } catch (Exception e) {
            System.out.println("Error al eliminar el alumno con ID " + id + ": " + e.getMessage());
            e.printStackTrace();
            return "Ocurrio un error al intentar eliminar el usuario.";
        } finally {
            System.out.println("Metodo delete ejecutado.");
        }
    }*/

    /* 
    //@GetMapping("/findAll")
    @GetMapping(NoHardCodeo.GET_ALL)
    public List<AlumnoModel> findAll(){
        List<AlumnoModel> lista = alumnoService.findAll();
        return lista;
    }

    //@PostMapping("/create")
    @PostMapping(NoHardCodeo.CREATE)
    public AlumnoModel create(@RequestBody AlumnoModel model){
        return alumnoService.add(model);
    }

    //@GetMapping("/findById/{id}")
    @GetMapping(NoHardCodeo.GET_BY_ID)
    public AlumnoModel findById(@PathVariable Integer id) {
        return alumnoService.findById(id);
    }

    //@PutMapping("/update")
    @PutMapping(NoHardCodeo.UPDATE)
    public AlumnoModel update(@RequestBody AlumnoModel model){
    return alumnoService.update(model);
    }

    //@DeleteMapping("/delete/{id}")
    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = alumnoService.delete(id);
        return isDeleted ? "Usuario eliminado correctamente" : "Error al eliminar usuario";
    }
    */
    
    /* 
    //@GetMapping("/obtenerAlumno/{id}")
    @GetMapping(NoHardCodeo.GET_BY_ID)
    public AlumnoModel obtenerAlumno(@PathVariable int id) {
        AlumnoModel alum = alumnoService.findById(id);
        logger.info("Obteniendo alumno con id: {}", id);
        logger.info("Retorno de la variable id: {}", alum.getIdAlumno());
        return alumnoService.findById(id);
    }*/
}

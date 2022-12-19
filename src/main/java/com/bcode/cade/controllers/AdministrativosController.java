package com.bcode.cade.controllers;

import com.bcode.cade.dto.AdministrativoAuth;
import com.bcode.cade.dto.CalificacionSaveBcodeDto;
import com.bcode.cade.entities.AdministrativoBcode;
import com.bcode.cade.entities.CalificacionBcode;
import com.bcode.cade.services.AdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrativo")
public class AdministrativosController {
    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping()
    public ResponseEntity<List<AdministrativoBcode>> getAdminstrativos() {
        return new ResponseEntity<>(administrativoService.getAdministrativos(), HttpStatus.OK);
    }

    @GetMapping("/id/{id_admin}")
    public ResponseEntity<AdministrativoBcode> getAdminstrativo(@PathVariable(value = "id_admin") Integer id) {
        return new ResponseEntity<>(administrativoService.getAdministrativo(id), HttpStatus.OK);
    }

    @GetMapping("/id/{id_admin}/materias")
    public ResponseEntity<List<String>> getAdminstrativo_cursos(@PathVariable(value = "id_admin") Integer id) {
        return new ResponseEntity<>(administrativoService.getAdministrativoMaterias(id), HttpStatus.OK);
    }

    @GetMapping("/id/{id_admin}/{materia}/grupos")
    public ResponseEntity<List<String>> getGrupos(@PathVariable(value="id_admin") Integer id_admin,
            @PathVariable(value="materia")String clave){
        return new ResponseEntity<>(administrativoService.getAdministrativoGrupos(id_admin, clave), HttpStatus.OK);
    }

    @GetMapping("/id/{id_admin}/{materia}/{grupo}/alumnos")
    public ResponseEntity<List<String>> getAlumnos(@PathVariable(value="id_admin") Integer id_admin,
                                                   @PathVariable(value="materia") String clave_materia,
                                                   @PathVariable(value="grupo") String grupo){
        return new ResponseEntity<>(administrativoService.getAdministrativoAlumnoGrupo(id_admin, clave_materia, grupo), HttpStatus.OK);
    }

    @GetMapping("/docente_carrera/{carrera}")
    public ResponseEntity<List<AdministrativoBcode>> getAdminstrativoByCarrera(
            @PathVariable(value = "carrera") String carrera) {
        return new ResponseEntity<>(administrativoService.getDocenteByCarrera(carrera), HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity<AdministrativoBcode> authAdmin(@RequestBody AdministrativoAuth admin) {
        return new ResponseEntity<>(administrativoService.authuAdmin(admin), HttpStatus.OK);
    }

    @GetMapping("/authv2")
    public ResponseEntity<AdministrativoBcode> authAdmin2(@RequestParam(value = "nombre") String nom,
                                                          @RequestParam(value = "contra") String contra) {
        return new ResponseEntity<>(administrativoService.authuAdmin(nom, contra), HttpStatus.OK);
    }

    @PostMapping("/registro_calificacion")
    public ResponseEntity<CalificacionBcode> saveCalificacion (@RequestBody CalificacionBcode calificacionSaveBcode){
        return new ResponseEntity<>(administrativoService.registrarCalificacion(calificacionSaveBcode), HttpStatus.CREATED);
    }

    /*
    @PostMapping("/registro")
    public ResponseEntity<AlumnoBcode> saveAlumno (@RequestBody AlumnoSaveBcodeDto alumnoSaveBcodeDto){
        return new ResponseEntity<>(alumnoService.registrarAlumno(alumnoSaveBcodeDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<AlumnoBcode> updateAlumno (
            @RequestBody AlumnoSaveBcodeDto alumnoSaveBcodeDto,
            @RequestParam(value = "numc") String numeroc){
        return new ResponseEntity<>(alumnoService.actualizarAlumno(alumnoSaveBcodeDto, numeroc), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<Void> deleteAlumno (@RequestParam(value = "numc") String numeroc){
        alumnoService.borrarAlumno(numeroc);
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }*/
}

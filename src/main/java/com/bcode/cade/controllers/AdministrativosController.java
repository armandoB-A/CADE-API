package com.bcode.cade.controllers;

import com.bcode.cade.dto.*;
import com.bcode.cade.dto.horarioinfo.AlumnosByMaterias;
import com.bcode.cade.dto.horarioinfo.GruposAdministrativo;
import com.bcode.cade.entities.*;
import com.bcode.cade.services.AdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/administrativo")
public class AdministrativosController {
    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping()
    public ResponseEntity<List<AdministrativoBcode>> getAdminstrativos() {
        return new ResponseEntity<>(administrativoService.getAdministrativos(), HttpStatus.OK);
    }
    @GetMapping("/adminss")
    public ResponseEntity<List<AdministrativoBcode>> getAdminstrativosDef() {
        return new ResponseEntity<>(administrativoService.getAdministrativoss(), HttpStatus.OK);
    }
    @GetMapping("/adminss")
    public ResponseEntity<List<AdministrativoBcode>> getDocentesDef() {
        return new ResponseEntity<>(administrativoService.getDocenteSS(), HttpStatus.OK);
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
    public ResponseEntity<List<String>> getGrupos(@PathVariable(value = "id_admin") Integer id_admin,
                                                  @PathVariable(value = "materia") String clave) {
        return new ResponseEntity<>(administrativoService.getAdministrativoGrupos(id_admin, clave), HttpStatus.OK);
    }

    @GetMapping("materias/id/{id_admin}")
    public ResponseEntity<List<GruposAdministrativo>> getGrupos(@PathVariable(value = "id_admin") Integer id_admin) {
        return new ResponseEntity<>(administrativoService.getMateriasByIdAdmin(id_admin), HttpStatus.OK);
    }

    @GetMapping("/id/{id_admin}/{materia}/{grupo}/alumnos")
    public ResponseEntity<List<String>> getAlumnos(@PathVariable(value = "id_admin") Integer id_admin,
                                                   @PathVariable(value = "materia") String clave_materia,
                                                   @PathVariable(value = "grupo") String grupo) {
        return new ResponseEntity<>(administrativoService.getAdministrativoAlumnoGrupo(id_admin, clave_materia, grupo), HttpStatus.OK);
    }

    @GetMapping("/alumnos/{id_admin}/{materia}/{grupo}/")
    public ResponseEntity<List<AlumnosByMaterias>> getListAlumnos(@PathVariable(value = "id_admin") Integer id_admin,
                                                                  @PathVariable(value = "materia") String clave_materia,
                                                                  @PathVariable(value = "grupo") String grupo) {
        return new ResponseEntity<>(administrativoService.getLisAlum(id_admin, clave_materia, grupo), HttpStatus.OK);
    }

    @GetMapping("/docente_carrera/{carrera}")
    public ResponseEntity<List<AdministrativoBcode>> getAdminstrativoByCarrera(
            @PathVariable(value = "carrera") String carrera) {
        return new ResponseEntity<>(administrativoService.getDocenteByCarrera(carrera), HttpStatus.OK);
    }

    @PostMapping("registro-calificaciones")
    public ResponseEntity<List<CalificacionBcode>> saveAlumno(@RequestBody List<CalificacionAlumnosBcodeDto> calificaciones) {
        return new ResponseEntity<>(administrativoService.calificacion(calificaciones), HttpStatus.CREATED);
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

    @PutMapping("/actualizar")
    public ResponseEntity<AdministrativoSaveBcodeDto> updateDocente(
            @RequestBody AdministrativoSaveBcodeDto administrativoSaveBcodeDto,
            @RequestParam(value = "id") Integer id) {
        return new ResponseEntity<>(administrativoService.actualizarDocente(administrativoSaveBcodeDto, id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/registro")
    public ResponseEntity<AdministrativoBcode> saveAdministrativo(@RequestBody AdministrativoSaveBcodeDto administrativoSaveBcodeDto) {
        return new ResponseEntity<>(administrativoService.registrarAlumno(administrativoSaveBcodeDto), HttpStatus.CREATED);
    }

    @GetMapping("/docentes-vacios")
    public ResponseEntity<List<AdministrativoBcode>> getDocentesv() {
        return new ResponseEntity<>(administrativoService.getDocentesv(), HttpStatus.OK);
    }

    @PostMapping("/registro-carrerasd/{idd}/")
    public ResponseEntity<List<DetalleAdministrativoBcode>> saveCarrerasDocente(
            @PathVariable(value = "idd") int idd,
            @RequestBody List<CarreraBcodeDto1> carrera) {
        return new ResponseEntity<>(administrativoService.registroDocenteCarrera(idd,carrera), HttpStatus.CREATED);
    }

    @PostMapping("/registro-materiasd/{idd}/")
    public ResponseEntity<List<HorarioBcode>> saveMateriasDocente(
            @PathVariable(value = "idd") int idd,
            @RequestBody List<MateriasDocenteBcodeDto> materias) {
        return new ResponseEntity<>(administrativoService.registroMateriasCarrera(idd,materias), HttpStatus.CREATED);
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

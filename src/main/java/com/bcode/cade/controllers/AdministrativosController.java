package com.bcode.cade.controllers;

import com.bcode.cade.dto.AdministrativoAuth;
import com.bcode.cade.dto.AlumnoSaveBcodeDto;
import com.bcode.cade.entities.AdministrativoBcode;
import com.bcode.cade.entities.AlumnoBcode;
import com.bcode.cade.entities.HorarioBcode;
import com.bcode.cade.services.AdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @GetMapping("/id/{id_admin}/grupos")
    public ResponseEntity<List<HorarioBcode>> getAdminstrativo_cursos(@PathVariable(value = "id_admin") Integer id) {
        return new ResponseEntity<>(administrativoService.getAdministrativoMaterias(id), HttpStatus.OK);
    }

    @GetMapping("/docente_carrera/{carrera}")
    public ResponseEntity<List<AdministrativoBcode>> getAdminstrativoByCarrera(
            @PathVariable(value = "carrera") String carrera) {
        return new ResponseEntity<>(administrativoService.getDocenteByCarrera(carrera), HttpStatus.OK);
    }
    @GetMapping("/auth")
    public ResponseEntity<AdministrativoBcode> authAdmin(@RequestBody AdministrativoAuth admin){
        return new ResponseEntity<>(administrativoService.authuAdmin(admin),HttpStatus.OK);
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
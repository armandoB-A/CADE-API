package com.bcode.cade.controllers;

import com.bcode.cade.dto.AlumnoSaveBcodeDto;
import com.bcode.cade.dto.TokenDto;
import com.bcode.cade.entities.AlumnoBcode;
import com.bcode.cade.services.AlumnoService;
import com.bcode.cade.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private AuthService authService;

    @GetMapping("/numero_control/{numc}")
    public ResponseEntity<AlumnoBcode> getAlumno(@PathVariable("numc") String numC) {
        return new ResponseEntity<>(alumnoService.getAlumnoBcodeRepository(numC), HttpStatus.OK);
    }

    @GetMapping("/total_carrera")
    public ResponseEntity<Long> getAlumnoByCarrera(
            @RequestParam(value = "carrera") String carrera) {
        return new ResponseEntity<>(alumnoService.getTotalAlumnosByCarrera(carrera), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AlumnoBcode>> getAlumnos() {
        return new ResponseEntity<>(alumnoService.getAlumnoBcodeRepository(), HttpStatus.OK);
    }

    @PostMapping("/registro")
    public ResponseEntity<AlumnoSaveBcodeDto> saveAlumno(@RequestBody AlumnoSaveBcodeDto alumnoSaveBcodeDto) {
        return new ResponseEntity<>(alumnoService.registrarAlumno(alumnoSaveBcodeDto), HttpStatus.CREATED);
    }

    @GetMapping("/auth")
    public ResponseEntity<AlumnoSaveBcodeDto> authAdmin(@RequestParam(value = "id") String nom,
                                                        @RequestParam(value = "contra") String contra) {
        return new ResponseEntity<>(alumnoService.authuAdmin(nom, contra), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestParam(value = "id") String nom,
                                          @RequestParam(value = "contra") String contra) {
        TokenDto token = authService.login(nom, contra);
        return ResponseEntity.ok(token);
    }
    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String apiKey) {
        // Tu código de validación de la clave de API aquí
        TokenDto tokenDto = authService.validate(apiKey);
        return ResponseEntity.ok(tokenDto);
    }
    /*
        @GetMapping("/auth")
        public ResponseEntity<AlumnoBcode> auth (@RequestBody AlumnoSaveBcodeDto alumnoSaveBcodeDto){
            return new ResponseEntity<>(alumnoService.registrarAlumno(alumnoSaveBcodeDto), HttpStatus.CREATED);
        }
    */
    @PutMapping("/actualizar")
    public ResponseEntity<AlumnoSaveBcodeDto> updateAlumno(
            @RequestBody AlumnoSaveBcodeDto alumnoSaveBcodeDto,
            @RequestParam(value = "numc") String numeroc) {
        return new ResponseEntity<>(alumnoService.actualizarAlumno(alumnoSaveBcodeDto, numeroc), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<Void> deleteAlumno(@RequestParam(value = "numc") String numeroc) {
        alumnoService.borrarAlumno(numeroc);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

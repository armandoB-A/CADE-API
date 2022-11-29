package com.bcode.cade.services;

import com.bcode.cade.dto.AlumnoBcodeDto;
import com.bcode.cade.dto.AlumnoSaveBcodeDto;
import com.bcode.cade.entities.AlumnoBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import com.bcode.cade.repository.CarreraBcodeRepository;
import com.bcode.cade.repository.RolBcodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoBcodeRepository alumnoBcodeRepository;
    @Autowired
    private CarreraBcodeRepository carreraBcodeRepository;
    @Autowired
    private RolBcodeRepository rolBcodeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AlumnoBcode getAlumnoBcodeRepository(String numC) {
        AlumnoBcode alumnoBcode = null;
        if (alumnoExist(numC)){
            alumnoBcode= alumnoBcodeRepository.findById(numC).get();
        }
        return alumnoBcode;
    }

    public long getTotalAlumnosByCarrera(String carrera) {
        return alumnoBcodeRepository.countAlumnoBcodeByClaveCarreraFkDescripcionCarrera(carrera);
    }

    public AlumnoBcode getAlumnoBcodeRepository(String numC, String carrera) {
        AlumnoBcode alumnoBcode = null;
        if (alumnoExist(numC)){
            alumnoBcode= alumnoBcodeRepository.findByIdAndAndClaveCarreraFk_DescripcionCarrera(numC, carrera);
        }
        return alumnoBcode;
    }
    public List<AlumnoBcode> getAlumnoBcodeRepository() {
        try {
            return alumnoBcodeRepository.findAll();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se encontraron alumnos ", ex);
        }
    }

    public AlumnoSaveBcodeDto registrarAlumno(AlumnoSaveBcodeDto alumnoSaveBcodeDto) {
        AlumnoBcode alumnoBcode = new AlumnoBcode();
        return entityToDto(alumnoBcodeRepository.saveAndFlush(dtoToEntity(alumnoSaveBcodeDto, alumnoBcode)));
    }

    public AlumnoBcode actualizarAlumno(AlumnoSaveBcodeDto alumnoSaveBcodeDto, String numC) {
        AlumnoBcode alumnoBcode = null;
        Calendar.getInstance().getTime().getYear();
        if (alumnoExist(numC)) {
            alumnoBcode = alumnoBcodeRepository.findById(numC).get();
        }
        return alumnoBcodeRepository.saveAndFlush(dtoToEntity(alumnoSaveBcodeDto, alumnoBcode, numC));
    }

    public void borrarAlumno(String numC) {
        if (alumnoExist(numC)) {
            alumnoBcodeRepository.deleteById(numC);
        }
    }

    //-----------------------------------

    private AlumnoSaveBcodeDto entityToDto(AlumnoBcode alumno){
        return new AlumnoSaveBcodeDto(
                alumno.getId(),
                alumno.getNombreAlumno(),
                alumno.getApe1Alumno(),
                alumno.getApe2Alumno(),
                alumno.getTelefonoAlumno(),
                alumno.getCorreoAlumno(),
                alumno.getDireccionAlumno(),
                alumno.getFechaNacimientoAlumno(),
                alumno.getContraseniaAlumno(),
                alumno.getGeneroAlumno(),
                alumno.getClaveCarreraFk().getId()
        );

    }
    private AlumnoBcode dtoToEntity(AlumnoSaveBcodeDto alumnoSaveBcodeDto, AlumnoBcode alumnoBcode) {
        alumnoBcode.setId(alumnoSaveBcodeDto.getId());
        return getAlumnoBcode(alumnoSaveBcodeDto, alumnoBcode);
    }

    private AlumnoBcode dtoToEntity(AlumnoSaveBcodeDto alumnoSaveBcodeDto, AlumnoBcode alumnoBcode, String numC) {
        alumnoBcode.setId(numC);
        return getAlumnoBcode(alumnoSaveBcodeDto, alumnoBcode);
    }

    private AlumnoBcode getAlumnoBcode(AlumnoSaveBcodeDto alumnoSaveBcodeDto, AlumnoBcode alumnoBcode) {
        if (alumnoSaveBcodeDto.getNombreAlumno() != null)
            alumnoBcode.setNombreAlumno(alumnoSaveBcodeDto.getNombreAlumno());

        if (alumnoSaveBcodeDto.getApe1Alumno() != null)
            alumnoBcode.setApe1Alumno(alumnoSaveBcodeDto.getApe1Alumno());

        if (alumnoSaveBcodeDto.getApe2Alumno() != null)
            alumnoBcode.setApe2Alumno(alumnoSaveBcodeDto.getApe2Alumno());

        if (alumnoSaveBcodeDto.getTelefonoAlumno() != null) {
            alumnoBcode.setTelefonoAlumno(alumnoSaveBcodeDto.getTelefonoAlumno());
        }
        if (alumnoSaveBcodeDto.getCorreoAlumno() != null)
            alumnoBcode.setCorreoAlumno(alumnoSaveBcodeDto.getCorreoAlumno());

        if (alumnoSaveBcodeDto.getDireccionAlumno() != null)
            alumnoBcode.setDireccionAlumno(alumnoSaveBcodeDto.getDireccionAlumno());

        if (alumnoSaveBcodeDto.getFechaNacimientoAlumno() != null)
            alumnoBcode.setFechaNacimientoAlumno(alumnoSaveBcodeDto.getFechaNacimientoAlumno());


        if (alumnoSaveBcodeDto.getContraseniaAlumno() != null)
            alumnoBcode.setContraseniaAlumno(alumnoSaveBcodeDto.getContraseniaAlumno());

        alumnoBcode.setStatusAlumno('1');
        if (alumnoSaveBcodeDto.getGeneroAlumno() != null)
            alumnoBcode.setGeneroAlumno(alumnoSaveBcodeDto.getGeneroAlumno());
        try {
            if (alumnoBcode.getIdRolFk() == null)
                alumnoBcode.setIdRolFk(rolBcodeRepository.findById((byte) 1).get());
            if (alumnoSaveBcodeDto.getClaveCarreraFk() != null)
                alumnoBcode.setClaveCarreraFk(carreraBcodeRepository.findById(alumnoSaveBcodeDto.getClaveCarreraFk()).get());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error en la clave de la carrera, no existe o esta mal escrita ", ex);
        }

        return alumnoBcode;
    }

    public Boolean alumnoExist(String numC) {
        if (alumnoBcodeRepository.existsById(numC)) {
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario no encontrado");
        }
    }


}

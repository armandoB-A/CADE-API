package com.bcode.cade.services;

import com.bcode.cade.config.JwtProvider;
import com.bcode.cade.dto.AlumnoSaveBcodeDto;
import com.bcode.cade.dto.TokenDto;
import com.bcode.cade.entities.AlumnoBcode;
import com.bcode.cade.repository.AlumnoBcodeRepository;
import com.bcode.cade.repository.CarreraBcodeRepository;
import com.bcode.cade.repository.RolBcodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AlumnoBcodeRepository alumnoBcodeRepository;
    @Autowired
    private CarreraBcodeRepository carreraBcodeRepository;
    @Autowired
    private RolBcodeRepository rolBcodeRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtProvider provider;
    @Autowired
    private ModelMapper mapper;
    /*
    public User Dtosave(UserDto dto) {
        Optional<UserEntity> result = repository.findByUsername(dto.getUsername());
        if (result.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format(" User %s al r eady exists", dto.getUsername()));
        }
        UserEntity entity = repository.save(new UserEntity(dto.getUsername(), encoder.encode(dto.getPassword())));
        return mapper.map(entity, UserDto.class);
    }*/

    public TokenDto login(String id, String contra) {
        try {
            AlumnoSaveBcodeDto result = entityToDto(alumnoBcodeRepository.findByIdAndContraseniaAlumno(id, contra));
            return new TokenDto(provider.createToken(result));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se encontro alumno ");
        }
    }

    public TokenDto validate(String token) {
        if (!provider.validate(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String username = provider.getUsernameFromToken(token);
        AlumnoBcode result = alumnoBcodeRepository.findByNombreAlumno(username);

        return new TokenDto(token);
    }

    //-----------------------------------

    private AlumnoSaveBcodeDto entityToDto(AlumnoBcode alumno) {
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
}

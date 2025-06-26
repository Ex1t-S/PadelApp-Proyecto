package com.efectopadel.padeltour.controller;

import com.efectopadel.padeltour.model.Turno;
import com.efectopadel.padeltour.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoRepository turnoRepository;

    // 1. Crear un turno (POST)
    @PostMapping
    public Turno createTurno(@RequestBody Turno turno) {
        return turnoRepository.save(turno);
    }

    // 2. Listar todos los turnos (GET)
    @GetMapping
    public List<Turno> getAllTurnos() {
        return turnoRepository.findAll();
    }

    // 3. Buscar turnos por cancha (GET)
    @GetMapping("/cancha/{cancha}")
    public List<Turno> getTurnosByCancha(@PathVariable int cancha) {
        return turnoRepository.findByCancha(cancha);
    }

    // 4. Buscar turno por cancha y horario (GET)
    @GetMapping("/cancha/{cancha}/horario/{horario}")
    public ResponseEntity<Turno> getTurnoByCanchaAndHorario(@PathVariable int cancha, @PathVariable int horario) {
        return turnoRepository.findByCanchaAndHorario(cancha, horario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Buscar turnos por usuario (GET)
    @GetMapping("/usuario/{usuarioId}")
    public List<Turno> getTurnosByUsuario(@PathVariable String usuarioId) {
        return turnoRepository.findByUsuarioId(usuarioId);
    }

    // 7. Actualizar un turno (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Turno> updateTurno(@PathVariable String id, @RequestBody Turno turnoActualizado) {
        return turnoRepository.findById(id)
                .map(turno -> {
                    turno.setCancha(turnoActualizado.getCancha());
                    turno.setHorario(turnoActualizado.getHorario());
                    turno.setHoraInicio(turnoActualizado.getHoraInicio());
                    turno.setHoraFin(turnoActualizado.getHoraFin());
                    turno.setEstado(turnoActualizado.getEstado());
                    turno.setUsuarioId(turnoActualizado.getUsuarioId());
                    return ResponseEntity.ok(turnoRepository.save(turno));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 8. Eliminar un turno (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurno(@PathVariable String id) {
        return turnoRepository.findById(id)
                .map(turno -> {
                    turnoRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
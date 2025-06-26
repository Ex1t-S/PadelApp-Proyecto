package com.efectopadel.padeltour.repository;

import com.efectopadel.padeltour.model.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TurnoRepository extends MongoRepository<Turno, String> {
    List<Turno> findByCancha(int cancha);
    //List<Turno> findByCanchaAndEstado(int cancha, String estado);
    Optional<Turno> findByCanchaAndHorario(int cancha, int horario);
    List<Turno> findByUsuarioId(String usuarioId);
}

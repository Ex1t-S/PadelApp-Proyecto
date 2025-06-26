package com.efectopadel.padeltour.helpers;

import com.efectopadel.padeltour.model.Turno;
import com.efectopadel.padeltour.repository.TurnoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class TurnosLoader {
    @Bean
    CommandLineRunner initDatabase(TurnoRepository turnoRepository) {
        return args -> {
            if (turnoRepository.count() == 0) {
                LocalTime primerHorario = LocalTime.of(9, 0);
                LocalTime finDelDia = LocalTime.MIDNIGHT; // 00:00

                for (int cancha = 1; cancha <= 3; cancha++) {
                    LocalTime actual = primerHorario;
                    int bloque = 1;

                    for(int i=1; i<=10; i++) {
                        LocalTime siguiente = actual.plusMinutes(90);
                        String horaInicio = actual.toString();
                        String horaFin = siguiente.toString();
                        turnoRepository.save(new Turno(
                                cancha,
                                bloque,
                                horaInicio,
                                horaFin,
                                "libre",
                                null));
                        actual = siguiente;
                        bloque++;
                        System.out.println("Guardando turno: cancha=" + cancha + ", bloque=" + bloque + ", " + horaInicio + " - " + horaFin);

                    }
                }
                System.out.println("¡Turnos iniciales cargados con éxito!");
            }
        };
    }
}
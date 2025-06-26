package com.efectopadel.padeltour.Utils;

import java.util.ArrayList;
import java.util.List;

public class HorarioUtils {
    public static List<String> generarHorarios() {
        List<String> horarios = new ArrayList<>();
        int hora = 9;
        int minuto = 0;
        while (hora < 24) {
            String hIni = String.format("%02d:%02d", hora, minuto);
            minuto += 30;
            if (minuto >= 60) {
                minuto -= 60;
                hora += 1;
            }
            hora += 1;
            if (hora==24){
                String hFin = String.format("00:%02d", minuto);
                horarios.add(hIni + " - " + hFin);
            }
            else {
                String hFin = String.format("%02d:%02d", hora, minuto);
                horarios.add(hIni + " - " + hFin);
            }
        }
        return horarios;
    }
}

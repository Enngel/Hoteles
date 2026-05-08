package com.engelnieves.hotel;

import com.engelnieves.hotel.model.Habitacion;
import com.engelnieves.hotel.model.Reserva;
import com.engelnieves.hotel.repository.HabitacionRepository;
import com.engelnieves.hotel.repository.ReservaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final HabitacionRepository habitacionRepository;
    private final ReservaRepository    reservaRepository;

    public DataLoader(HabitacionRepository habitacionRepository,
                      ReservaRepository reservaRepository) {
        this.habitacionRepository = habitacionRepository;
        this.reservaRepository    = reservaRepository;
    }

    @Override
    public void run(String... args) {
        // Solo cargamos datos si la BD está vacía
        if (habitacionRepository.count() == 0) {
            cargarHabitaciones();
        }
        if (reservaRepository.count() == 0) {
            cargarReservas();
        }
    }

    private void cargarHabitaciones() {
        List<Habitacion> habitaciones = List.of(
            new Habitacion("Simple",   65.00,  1, "Habitación individual con vista al jardín",       true),
            new Habitacion("Simple",   70.00,  1, "Habitación individual con vista a la piscina",    true),
            new Habitacion("Doble",    110.00, 2, "Habitación doble con cama de matrimonio",          true),
            new Habitacion("Doble",    120.00, 2, "Habitación doble con dos camas separadas",         true),
            new Habitacion("Doble",    130.00, 2, "Habitación doble superior con terraza",            true),
            new Habitacion("Familiar", 180.00, 4, "Habitación familiar con sala de estar",            true),
            new Habitacion("Familiar", 195.00, 4, "Habitación familiar con bañera de hidromasaje",    false),
            new Habitacion("Suite",    280.00, 2, "Suite junior con jacuzzi y vistas al mar",         true),
            new Habitacion("Suite",    350.00, 2, "Suite presidencial con salón privado",             true),
            new Habitacion("Suite",    420.00, 3, "Suite royal con piscina privada",                  true),
            new Habitacion("Doble",    115.00, 2, "Habitación doble accesible para personas con movilidad reducida", true),
            new Habitacion("Simple",   75.00,  1, "Habitación individual ático con vistas panorámicas", false)
        );
        habitacionRepository.saveAll(habitaciones);
        System.out.println("✔ Habitaciones cargadas: " + habitacionRepository.count());
    }

    private void cargarReservas() {
        List<Habitacion> h = habitacionRepository.findAll();

        List<Reserva> reservas = List.of(
            new Reserva("Carlos Ramírez",   "carlos@email.com",   LocalDate.of(2025,  6,  1), LocalDate.of(2025,  6,  5), 1, "Sin observaciones",          h.get(0)),
            new Reserva("María López",      "maria@email.com",    LocalDate.of(2025,  6, 10), LocalDate.of(2025,  6, 14), 2, "Cama extra si es posible",    h.get(2)),
            new Reserva("Alejandro Torres", "alex@email.com",     LocalDate.of(2025,  7,  1), LocalDate.of(2025,  7,  7), 2, "Luna de miel",                h.get(7)),
            new Reserva("Sofía Martínez",   "sofia@email.com",    LocalDate.of(2025,  7, 15), LocalDate.of(2025,  7, 20), 4, "Familia con niños",           h.get(5)),
            new Reserva("Pablo Fernández",  "pablo@email.com",    LocalDate.of(2025,  8,  5), LocalDate.of(2025,  8,  8), 1, "Llegada tardía",              h.get(1)),
            new Reserva("Laura Sánchez",    "laura@email.com",    LocalDate.of(2025,  8, 20), LocalDate.of(2025,  8, 25), 2, "Aniversario",                 h.get(8)),
            new Reserva("Miguel Gómez",     "miguel@email.com",   LocalDate.of(2025,  9,  3), LocalDate.of(2025,  9,  6), 3, "Requiere cuna",               h.get(5)),
            new Reserva("Elena Ruiz",       "elena@email.com",    LocalDate.of(2025,  9, 12), LocalDate.of(2025,  9, 15), 2, "Dieta vegetariana",           h.get(3)),
            new Reserva("Antonio Moreno",   "antonio@email.com",  LocalDate.of(2025, 10,  1), LocalDate.of(2025, 10, 10), 2, "Congreso empresarial",        h.get(9)),
            new Reserva("Isabel Jiménez",   "isabel@email.com",   LocalDate.of(2025, 10, 15), LocalDate.of(2025, 10, 18), 1, "Sin gluten en desayuno",      h.get(0)),
            new Reserva("David Hernández",  "david@email.com",    LocalDate.of(2025, 11,  5), LocalDate.of(2025, 11,  9), 4, "Familia numerosa",            h.get(5)),
            new Reserva("Carmen Díaz",      "carmen@email.com",   LocalDate.of(2025, 12, 24), LocalDate.of(2025, 12, 28), 2, "Navidades en pareja",         h.get(8))
        );
        reservaRepository.saveAll(reservas);
        System.out.println("✔ Reservas cargadas: " + reservaRepository.count());
    }
}

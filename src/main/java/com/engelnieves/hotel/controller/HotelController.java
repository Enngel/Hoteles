package com.engelnieves.hotel.controller;

import com.engelnieves.hotel.model.Habitacion;
import com.engelnieves.hotel.model.Reserva;
import com.engelnieves.hotel.repository.HabitacionRepository;
import com.engelnieves.hotel.repository.ReservaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HotelController {

    private final HabitacionRepository habitacionRepository;
    private final ReservaRepository    reservaRepository;

    public HotelController(HabitacionRepository habitacionRepository,
                           ReservaRepository reservaRepository) {
        this.habitacionRepository = habitacionRepository;
        this.reservaRepository    = reservaRepository;
    }

    // ── GET /inicio ────────────────────────────────────────────
    @GetMapping({"/", "/inicio"})
    public String inicio() {
        return "inicio";
    }

    // ── GET /listadoHabitacion ─────────────────────────────────
    @GetMapping("/listadoHabitacion")
    public String listadoHabitacion(Model model) {
        List<Habitacion> habitaciones = habitacionRepository.findAll();
        model.addAttribute("habitaciones", habitaciones);
        return "listadoHabitacion";
    }

    // ── GET /listadoReserva ────────────────────────────────────
    @GetMapping("/listadoReserva")
    public String listadoReserva(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "listadoReserva";
    }

    // ── GET /altaHabitacion ────────────────────────────────────
    @GetMapping("/altaHabitacion")
    public String altaHabitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "altaHabitacion";
    }

    // ── POST /altaHabitacion ───────────────────────────────────
    @PostMapping("/altaHabitacion")
    public String altaHabitacionSubmit(@Valid @ModelAttribute("habitacion") Habitacion habitacion,
                                       BindingResult result) {
        if (result.hasErrors()) {
            return "altaHabitacion";
        }
        habitacionRepository.save(habitacion);
        return "redirect:/listadoHabitacion";
    }

    // ── GET /altaReserva ───────────────────────────────────────
    @GetMapping("/altaReserva")
    public String altaReservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "altaReserva";
    }

    // ── POST /altaReserva ──────────────────────────────────────
    @PostMapping("/altaReserva")
    public String altaReservaSubmit(@Valid @ModelAttribute("reserva") Reserva reserva,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("habitaciones", habitacionRepository.findAll());
            return "altaReserva";
        }
        reservaRepository.save(reserva);
        return "redirect:/listadoReserva";
    }
}

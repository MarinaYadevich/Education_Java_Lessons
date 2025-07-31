package by.tms.lesson43.controller;

import by.tms.lesson43.model.Film;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class FilmController {

    private final List<Film> filmsList = new ArrayList<>();

    @GetMapping
    public String showFilm(Model model) {
        model.addAttribute("films", filmsList);
        model.addAttribute("film", new Film());
        return "films-form";
    }

    @PostMapping("/add")
    public String addFilm(@Valid @ModelAttribute("film") Film film, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("films", filmsList);
            return "films-form";
        }

        filmsList.add(film);
        return "redirect:/";
    }
}

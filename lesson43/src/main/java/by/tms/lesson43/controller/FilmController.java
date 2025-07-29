package by.tms.lesson43.controller;

import by.tms.lesson43.model.FilmDTO;
import by.tms.lesson43.service.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/film")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public String showFilm(Model model) {
        model.addAttribute("films", filmService.findAll());
        model.addAttribute("film", new FilmDTO());
        return "films-form";
    }

    @PostMapping("/add")
    public String addFilm(@Valid @ModelAttribute("film") FilmDTO filmDTO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("films", filmService.findAll());
            return "films-form";
        }

        System.out.println(filmDTO);
        filmService.save(filmDTO);
       // filmsList.add(film);
        return "redirect:/film";
    }

    @GetMapping("/search")
    public String searchFilm(@RequestParam String title, Model model) {
        var result = filmService.findFilmByTitle(title);
        model.addAttribute("films", result);
        model.addAttribute("film", new FilmDTO());
        return "films-form";
    }
}

package br.univille.projfso2024b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projfso2024b.entity.Work;
import br.univille.projfso2024b.service.WorkService;

@Controller
@RequestMapping("/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping
    public ModelAndView index() {
        var listaWorks = workService.getAll();
        return new ModelAndView("work/index", "listaWorks", listaWorks);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var work = new Work();
        return new ModelAndView("work/form", "work", work);
    }

    @PostMapping()
    public ModelAndView save(Work work) {
        workService.save(work);
        return new ModelAndView("redirect:/works");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var work = workService.getById(id);
        return new ModelAndView("work/form", "work", work);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        workService.delete(id);
        return new ModelAndView("redirect:/works");
    }
}

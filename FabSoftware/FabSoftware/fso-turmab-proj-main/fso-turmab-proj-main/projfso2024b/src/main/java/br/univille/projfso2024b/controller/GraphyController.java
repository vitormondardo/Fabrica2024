package br.univille.projfso2024b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.univille.projfso2024b.entity.Graphy;
import br.univille.projfso2024b.service.WorkService;

@Controller
public class GraphyController {

    @Autowired
    private WorkService workService;

    @GetMapping("/graphy")
    public String getGraphyData(Model model) {
        List<Graphy> graphyData = workService.getWorkCountByFuncao();
        model.addAttribute("graphyData", graphyData);
        return "graphy/graphy";
    }
}

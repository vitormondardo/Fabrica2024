package br.univille.projfso2024b.controller;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.entity.Work;
import br.univille.projfso2024b.service.ClienteService;
import br.univille.projfso2024b.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private WorkService workService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView index() {
        List<Work> listaTrabalhos = workService.getAll();
        List<Cliente> listaClientes = clienteService.getAll();
        ModelAndView modelAndView = new ModelAndView("feed/index");
        modelAndView.addObject("listaTrabalhos", listaTrabalhos);
        modelAndView.addObject("listaClientes", listaClientes);
        return modelAndView;
    }

    @GetMapping("/vincular/{clienteId}/{workId}")
    public ModelAndView vincular(@PathVariable("clienteId") long clienteId, @PathVariable("workId") long workId) {
        Cliente cliente = clienteService.getById(clienteId);
        Work work = workService.getById(workId);
        work.setCliente(cliente);
        workService.save(work);
        return new ModelAndView("redirect:/feed");
    }
}

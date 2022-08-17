package ru.ryauzov.testtask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.services.ClientService;
import ru.ryauzov.testtask.services.ClientServiceImpl;

import java.util.List;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public ModelAndView allClients() {
        List<Client> clients = clientService.allClients();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("clients");
        modelAndView.addObject("clientsList", clients);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showClientById(@PathVariable int id) {
        Client client = clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editClient");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        clientService.update(client);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createClientPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createClient");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        clientService.create(client);
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView deleteClient(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Client client = clientService.getById(id);
        clientService.delete(client);
        return modelAndView;
    }
}

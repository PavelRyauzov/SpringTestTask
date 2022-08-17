package ru.ryauzov.testtask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ryauzov.testtask.models.Client;

@Controller
public class ClientController {
    private static Client client;

    static {
        client = new Client();
        client.setFullName("Ряузов Павел Евгеньевич");
    }

    @GetMapping("/")
    public ModelAndView allClients() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("clients");
        modelAndView.addObject(client);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editClient() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editClient");
        return modelAndView;
    }
}

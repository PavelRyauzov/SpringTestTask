package ru.ryauzov.testtask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.models.LoanApplication;
import ru.ryauzov.testtask.services.ClientService;
import ru.ryauzov.testtask.services.LoanApplicationService;

import java.util.List;

@Controller
public class ClientController {
    private ClientService clientService;
    private LoanApplicationService loanApplicationService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setLoanApplicationService(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createLoanApplicationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createLoanApplicationForm");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createClient(@ModelAttribute("client") Client client, @ModelAttribute("desiredLoanAmount") int desiredLoanAmount) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        clientService.create(client);
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setClient(client);
        loanApplication.setDesiredLoanAmount(desiredLoanAmount);
        loanApplicationService.create(loanApplication);
        return modelAndView;
    }

    @GetMapping("/clients")
    public ModelAndView allClients() {
        List<Client> clients = clientService.allClients();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("clients");
        modelAndView.addObject("clientsList", clients);
        return modelAndView;
    }

//    @GetMapping("/loanApplications")
//    public ModelAndView allLoanApplications() {
//        List<LoanApplication> clients = loanApplicationService.allLoanApplications();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("");
//        modelAndView.addObject("clientsList", clients);
//        return modelAndView;
//    }

    @GetMapping("/edit/{id}")
    public ModelAndView showClientById(@PathVariable long id) {
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

    @PostMapping("/{id}")
    public ModelAndView deleteClient(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Client client = clientService.getById(id);
        clientService.delete(client);
        return modelAndView;
    }

    @GetMapping("/clients/{id}")
    public ModelAndView showClient(@PathVariable long id) {
        Client client = clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client");
        modelAndView.addObject("client", client);
        return modelAndView;
    }
}

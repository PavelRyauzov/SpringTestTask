package ru.ryauzov.testtask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.models.LoanAgreement;
import ru.ryauzov.testtask.models.LoanApplication;
import ru.ryauzov.testtask.services.ClientService;
import ru.ryauzov.testtask.services.LoanAgreementService;
import ru.ryauzov.testtask.services.LoanApplicationService;

import java.util.List;

@Controller
public class MainController {
    private ClientService clientService;
    private LoanApplicationService loanApplicationService;

    private LoanAgreementService loanAgreementService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setLoanApplicationService(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @Autowired
    public void setLoanAgreementService(LoanAgreementService loanAgreementService) {
        this.loanAgreementService = loanAgreementService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
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

    @GetMapping("/clients/{id}")
    public ModelAndView showClient(@PathVariable long id) {
        Client client = clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @GetMapping("/loanApplications")
    public ModelAndView allLoanApplications() {
        List<LoanApplication> loanApplications = loanApplicationService.allLoanApplications();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loanApplications");
        modelAndView.addObject("loanApplicationsList", loanApplications);
        return modelAndView;
    }

    @GetMapping("/loanApplications/{id}")
    public ModelAndView showLoanApplication(@PathVariable long id) {
        LoanApplication loanApplication = loanApplicationService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loanApplication");
        modelAndView.addObject("loanApplication", loanApplication);
        return modelAndView;
    }

    @GetMapping("/loanAgreements")
    public ModelAndView allLoanAgreements() {
        List<LoanAgreement> loanAgreements = loanAgreementService.allLoanAgreements();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loanAgreements");
        modelAndView.addObject("loanAgreementsList", loanAgreements);
        return modelAndView;
    }
}

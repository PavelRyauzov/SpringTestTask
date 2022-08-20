package ru.ryauzov.testtask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.models.LoanAgreement;
import ru.ryauzov.testtask.models.LoanApplication;
import ru.ryauzov.testtask.services.ClientService;
import ru.ryauzov.testtask.services.LoanAgreementService;
import ru.ryauzov.testtask.services.LoanApplicationService;

import java.sql.Date;

@Controller
@RequestMapping("loan-processing")
public class LoanProcessingController {
    private long currentLoanApplicationId;
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

    @GetMapping("/step-1")
    public ModelAndView createLoanApplicationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createLoanApplicationForm");
        return modelAndView;
    }

    @PostMapping("/step-1")
    public ModelAndView createLoanApplication(@ModelAttribute("client") Client client, @ModelAttribute("desiredLoanAmount") int desiredLoanAmount) {
        ModelAndView modelAndView = new ModelAndView();

        clientService.create(client);
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setClient(client);
        loanApplication.setDesiredLoanAmount(desiredLoanAmount);
        loanApplicationService.create(loanApplication);
        loanApplicationService.makeDecision(loanApplication);

        currentLoanApplicationId = loanApplication.getId();

        if (loanApplication.getLoanTerm() != 0) {
            modelAndView.setViewName("redirect:/loan-processing/step-2");
        } else {
            modelAndView.setViewName("redirect:/loanApplications/" + loanApplication.getId());
        }

        return modelAndView;
    }

    @GetMapping("/step-2")
    public ModelAndView signAgreementPage() {
        ModelAndView modelAndView = new ModelAndView();
        if (currentLoanApplicationId == 0) {
            modelAndView.setViewName("redirect:/");
        } else {
            LoanApplication loanApplication = loanApplicationService.getById(currentLoanApplicationId);
            modelAndView.addObject("loanApplication", loanApplication);
            modelAndView.setViewName("signAgreementForm");
        }

        return modelAndView;
    }

    @PostMapping("/step-2")
    public ModelAndView signAgreement(@ModelAttribute("signStatus") boolean signStatus) {
        ModelAndView modelAndView = new ModelAndView();

        LoanAgreement loanAgreement = new LoanAgreement();
        loanAgreement.setLoanApplication(loanApplicationService.getById(currentLoanApplicationId));

        if (signStatus) {
            loanAgreement.setSigningDate(new Date(System.currentTimeMillis()));
            loanAgreementService.create(loanAgreement);
        }

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }
}

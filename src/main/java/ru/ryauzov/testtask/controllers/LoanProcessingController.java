package ru.ryauzov.testtask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ryauzov.testtask.entities.LoanApplicationEntity;
import ru.ryauzov.testtask.models.LoanApplicationForm;
import ru.ryauzov.testtask.models.LoanContractForm;
import ru.ryauzov.testtask.services.LoanApplicationService;
import ru.ryauzov.testtask.services.LoanContractService;

@Controller
@RequestMapping("loan-processing")
public class LoanProcessingController {
    private long currentLoanApplicationId = -1;
    private LoanApplicationService loanApplicationService;

    private LoanContractService loanContractService;

    @Autowired
    public void setLoanApplicationService(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @Autowired
    public void setLoanContractService(LoanContractService loanContractService) {
        this.loanContractService = loanContractService;
    }

    @GetMapping("/step-1")
    public ModelAndView createLoanApplicationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createLoanApplicationForm");
        return modelAndView;
    }

    @PostMapping("/step-1")
    public ModelAndView createLoanApplication(@ModelAttribute("loanApplicationForm") LoanApplicationForm form) {
        ModelAndView modelAndView = new ModelAndView();
        currentLoanApplicationId = loanApplicationService.create(form);
        modelAndView.setViewName("redirect:/loan-processing/step-2");
        return modelAndView;
    }

    @GetMapping("/step-2")
    public ModelAndView loanDecisionPage() {
        ModelAndView modelAndView = new ModelAndView();
        LoanApplicationEntity loanApplication = loanApplicationService.getById(currentLoanApplicationId);

        if (currentLoanApplicationId == -1) {
            modelAndView.setViewName("redirect:/");
        } else {
            loanApplicationService.makeDecision(loanApplication);
            modelAndView.setViewName("loanDecision");
            modelAndView.addObject("loanDecision", loanApplication.getApprovedLoanDecision());
        }


        return modelAndView;
    }

    @GetMapping("/step-3")
    public ModelAndView loanContractPage() {
        ModelAndView modelAndView = new ModelAndView();
        LoanApplicationEntity loanApplication = loanApplicationService.getById(currentLoanApplicationId);

        if (currentLoanApplicationId == -1) {
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.addObject("loanApplication", loanApplication);
            modelAndView.setViewName("loanContractForm");
        }

        return modelAndView;
    }

    @PostMapping("/step-3")
    public ModelAndView signContract(@ModelAttribute("loanContractForm") LoanContractForm form) {
        ModelAndView modelAndView = new ModelAndView();
        loanContractService.sign(form, currentLoanApplicationId);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}

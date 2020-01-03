package home.blackharold.controller;

import home.blackharold.entity.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //    add an initbiinder to convert trim input strings
//    remove leading and trailing whitespace
//    resolve issue for out validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

//        log input data
        System.out.println(customer.getFirstName() + " " + customer.getLastName());

        System.out.println(bindingResult);

        if (bindingResult.hasErrors()) return "customer-form";
        else return "customer-confirmation";
    }
}

package home.blackharold.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {

        return "helloworld-form";
    }

    @RequestMapping("/processform")
    public String processForm() {

        return "helloworld";
    }

    @RequestMapping("/processformVersion2")
    public String letsShoutDude(HttpServletRequest request, Model model){
//        read the request parameter from the HTML form
        String tempString = request.getParameter("studentName");
//        convert the data to all caps
        tempString = tempString.toUpperCase();
//        create the message
        String result = "Yo! " + tempString;
//        add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processformVersion3")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model){
//        read the request parameter from the HTML form
        String tempString = name;
//        convert the data to all caps
        tempString = tempString.toUpperCase();
//        create the message
        String result = "Hey my friend from v3! " + tempString;
//        add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}

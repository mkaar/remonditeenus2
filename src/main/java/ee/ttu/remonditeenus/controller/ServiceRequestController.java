package ee.ttu.remonditeenus.controller;

import ee.ttu.remonditeenus.model.SecurityUser;
import ee.ttu.remonditeenus.model.ServiceNote;
import ee.ttu.remonditeenus.model.ServiceRequest;
import ee.ttu.remonditeenus.service.ServiceRequestService;
import ee.ttu.remonditeenus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by markoka on 9.06.2015.
 */
@Controller
@RequestMapping("/remonditeenus")
public class ServiceRequestController {

    @Autowired
    ServiceRequestService service;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        SecurityUser account = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView model = new ModelAndView();
        model.addObject("ServiceList", service.loadServiceRequests(account.getCustomerId()));
        model.addObject("username", account.getUsername());

        if(userService.getAccountType(account.getCustomerId()).equals("EMPLOYEE")){
            model.setViewName("redirect:/tootaja/");
        } else {
            model.setViewName("/remonditeenus/index");
        }

        return model;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public ModelAndView notes(@RequestParam(value = "id", required = true) Integer id) {
        ModelAndView model = new ModelAndView();
        ServiceRequest sr = service.getServiceRequest(id);
        model.addObject("serviceRequest", sr);
        model.addObject("serviceNotes", service.getNotes(id));
        model.setViewName("/remonditeenus/notes");
        return model;
    }

    @RequestMapping(value = "/newNotes", method = RequestMethod.GET)
    public String newNotesView(Map<String, Object> model) {
        ServiceNote note = new ServiceNote();
        return "/remonditeenus/new_note";

    }

    @RequestMapping(value = "/newNotes", method = RequestMethod.POST)
    public String newNote(@ModelAttribute("ServiceNote")ServiceNote note,
                          ModelMap model) {
        SecurityUser account = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        note.setCustomer(service.findCustomerById(account.getCustomerId()));
        service.putNote(note);
        return "/remonditeenus/notes";

    }

    @RequestMapping(value = "/newRequest", method = RequestMethod.GET)
    public ModelAndView newRequestForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/remonditeenus/new_request");
        return model;

    }
}

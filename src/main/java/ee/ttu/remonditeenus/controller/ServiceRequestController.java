package ee.ttu.remonditeenus.controller;

import ee.ttu.remonditeenus.model.SecurityUser;
import ee.ttu.remonditeenus.model.ServiceRequest;
import ee.ttu.remonditeenus.model.UserAccount;
import ee.ttu.remonditeenus.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by markoka on 9.06.2015.
 */
@Controller
@RequestMapping("/remonditeenus")
public class ServiceRequestController {

    @Autowired
    ServiceRequestService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        SecurityUser account = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView model = new ModelAndView();
        model.addObject("ServiceList", service.loadServiceRequests(account.getCustomerId()));
        model.addObject("username", account.getUsername());
        model.setViewName("/remonditeenus/index");
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

    @RequestMapping(value = "/newRequest", method = RequestMethod.GET)
    public ModelAndView newRequestForm() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/remonditeenus/new_request");
        return model;

    }
}

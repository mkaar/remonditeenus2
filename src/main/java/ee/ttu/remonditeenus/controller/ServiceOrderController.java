package ee.ttu.remonditeenus.controller;

import ee.ttu.remonditeenus.model.SecurityUser;
import ee.ttu.remonditeenus.model.ServiceRequest;
import ee.ttu.remonditeenus.model.ServiceRequestForm;
import ee.ttu.remonditeenus.service.EmployeeService;
import ee.ttu.remonditeenus.service.ServiceRequestService;
import ee.ttu.remonditeenus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by markoka on 18.06.2015.
 */
@Controller
@SessionAttributes
@RequestMapping("/tootaja/serviceOrder")
public class ServiceOrderController {

    @Autowired
    ServiceRequestService serviceRequestService;

    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "id", required = true) Integer id) {
        ModelAndView model = new ModelAndView("serviceOrder", "command", new ServiceOrderCreationForm());
        ServiceRequest sr = serviceRequestService.getServiceRequest(id);
        model.addObject("serviceRequest", sr);
        model.setViewName("/tootaja/serviceOrder/add");
        return model;
    }

}

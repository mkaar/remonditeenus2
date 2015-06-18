package ee.ttu.remonditeenus.controller;

import ee.ttu.remonditeenus.model.SecurityUser;
import ee.ttu.remonditeenus.model.ServiceOrder;
import ee.ttu.remonditeenus.model.ServiceRequest;
import ee.ttu.remonditeenus.model.ServiceRequestForm;
import ee.ttu.remonditeenus.service.EmployeeService;
import ee.ttu.remonditeenus.service.ServiceRequestService;
import ee.ttu.remonditeenus.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView addServiceRequest(@ModelAttribute("serviceOrder")ServiceOrderCreationForm service,
                                          BindingResult result, ModelAndView model) {
        ServiceOrder serviceOrder = buildServiceOrder(service);
        employeeService.createServiceOrder(serviceOrder);
        serviceRequestService.updateServiceRequest(serviceRequestService.getServiceRequest(service.getServiceId().intValue()), 3);
        model.addObject("lisatud", "true");
        model.addObject("username", service.getEmployeeUsername());
        model.addObject("customers", employeeService.getAllCustomers());
        model.setViewName("redirect:/tootaja/");
        return model;
    }

    private ServiceOrder buildServiceOrder(ServiceOrderCreationForm service) {
        ServiceOrder so = new ServiceOrder();
        SecurityUser account = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        so.setServiceRequest(serviceRequestService.getServiceRequest(service.getServiceId().intValue()));
        so.setCreatedBy(userService.getEmployeeByUsername(account.getUsername()).getPerson());
        so.setCreatedDate(new DateTime().toDate());
        so.setNote(service.getNote());
        so.setServiceOrderStatusType(serviceRequestService.getSoStatusType(1));
        so.setTotalPrice(service.getPrice().doubleValue());
        return so;
    }

}

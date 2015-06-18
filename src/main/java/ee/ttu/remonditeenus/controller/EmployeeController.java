package ee.ttu.remonditeenus.controller;

import ee.ttu.remonditeenus.model.*;
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
 * Created by markoka on 9.06.2015.
 */
@Controller
@SessionAttributes
@RequestMapping("/tootaja")
public class EmployeeController {

    @Autowired
    ServiceRequestService serviceRequestService;

    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        SecurityUser account = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView model = new ModelAndView("serviceRequest", "command", new ServiceRequestForm());
        model.addObject("username", account.getUsername());
        model.addObject("customers", employeeService.getAllCustomers());
        model.setViewName("/tootaja/index");
        return model;

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView all() {
        SecurityUser account = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView model = new ModelAndView("serviceRequest", "command", new ServiceRequestForm());
        model.addObject("ServiceList", serviceRequestService.getAllServiceRequests());
        model.addObject("username", account.getUsername());
        model.setViewName("/tootaja/all");
        return model;

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "id", required = true) Integer id) {
        ModelAndView model = new ModelAndView("serviceRequest", "command", new ServiceRequestEditForm());
        SecurityUser account = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ServiceRequest sr = serviceRequestService.getServiceRequest(id);
        model.addObject("serviceTypes", serviceRequestService.getAllServiceStatusTypes());
        model.addObject("customers", employeeService.getAllCustomers());
        model.addObject("serviceRequest", sr);
        model.addObject("username", account.getUsername());
        model.setViewName("/tootaja/edit");
        return model;
    }


    @RequestMapping(value = "/edit/changeStatus", method = RequestMethod.POST)
    public ModelAndView editStatus(@RequestParam(value = "id", required = true) Integer id,
                                  @RequestParam(value = "status", required = true) Integer status) {
        ModelAndView model = new ModelAndView();
        ServiceRequest sr = serviceRequestService.getServiceRequest(id);
        serviceRequestService.updateServiceRequest(sr, status);
        model.addObject("muudetud", true);
        model.addObject("serviceTypes", serviceRequestService.getAllServiceStatusTypes());
        model.setViewName("redirect:/tootaja/all");
        return model;
    }

    @RequestMapping(value = "/edit/changeCustomer", method = RequestMethod.POST)
    public ModelAndView editCustomer(@RequestParam(value = "id", required = true) Integer id,
                                  @RequestParam(value = "customer", required = true) Integer customer) {
        ModelAndView model = new ModelAndView();
        ServiceRequest sr = serviceRequestService.getServiceRequest(id);
        serviceRequestService.updateServiceRequestClient(sr, customer);
        model.addObject("muudetud", true);
        model.addObject("serviceTypes", serviceRequestService.getAllServiceStatusTypes());
        model.setViewName("redirect:/tootaja/all");
        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView addServiceRequest(@ModelAttribute("serviceRequest")ServiceRequestForm service,
                             BindingResult result, ModelAndView model) {
        ServiceRequest serviceRequest = buildServiceRequest(service);
        employeeService.createServiceRequest(serviceRequest);
        model.addObject("lisatud", "true");
        model.addObject("username", service.getEmployeeUsername());
        model.addObject("customers", employeeService.getAllCustomers());
        model.setViewName("redirect:/tootaja/");
        return model;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam(value = "client", required = false) String client,
                               @RequestParam(value = "orderId", required = false) String orderId,
                               @RequestParam(value = "employee", required = false) String employee,
                               @RequestParam(value = "status", required = false) String status,
                               ModelAndView model) {
        if(client!=null){
            model.addObject("ServiceList", employeeService.getServiceRequestByClientName(client));
            model.setViewName("/tootaja/SearchResults");
            return model;
        } else if (orderId!=null){
            model.addObject("ServiceList", serviceRequestService.getServicesByOrderId(orderId));
            model.setViewName("/tootaja/SearchResults");
            return model;
        } else if (employee != null){
            model.addObject("ServiceList", serviceRequestService.getServicesByEmployee(employee));
            model.setViewName("/tootaja/SearchResults");
            return model;
        } else if (status != null){
            model.addObject("ServiceList", serviceRequestService.getServicesByStatus(status));
            model.setViewName("/tootaja/SearchResults");
            return model;
        } else {
            model.setViewName("redirect:/tootaja/");
        }
        return model;
    }

    private ServiceRequest buildServiceRequest(ServiceRequestForm service) {
        ServiceRequest sr = new ServiceRequest();
        Customer x = userService.getCustomerById(service.getPerson());
        sr.setCustomer(x);
        sr.setCreated(new DateTime().toDate());
        sr.setCreatedBy(userService.getEmployeeByUsername(service.getEmployeeUsername()));
        sr.setServiceDescByCustomer(service.getServiceDescByCustomer());
        sr.setServiceDescByEmployee(service.getServiceDescByEmployee());
        sr.setServiceRequestStatusType(serviceRequestService.getServiceRequestStatusType(new Long(1)));
        return sr;
    }
}

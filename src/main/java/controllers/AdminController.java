package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Account;
import pojo.Client;
import services.admin_services.AdminService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@Scope("session")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/admin_main", method = RequestMethod.GET)
    public String showAdminMainPage() {
        return "admin_main";
    }

    @ModelAttribute("exit")
    public String getExit(HttpServletRequest request)
    {
        return request.getParameter("exit");
    }

    @RequestMapping(value = "/admin_main", method = RequestMethod.POST)
    public String returnBackToMainPage(HttpServletRequest request, @ModelAttribute("exit") String exit) {
        if ("exit".equals(exit)) {
            request.getSession().setAttribute("isAuth", false);//use session attr
            request.getSession().setAttribute("role", null);
            return "redirect:/";
        } else {
            return "admin_main";
        }
    }

    @RequestMapping(value = "/admin_main/admin_client_list", method = RequestMethod.POST)
    public ModelAndView getClients() throws IOException, ServletException {
        List<Client> clients;
        ModelAndView modelAndView = new ModelAndView("admin_client_list");
        clients = adminService.doAdminGetAllClients();
        modelAndView.getModel().put("list", clients);
        return modelAndView;
    }

    @RequestMapping(value = "/admin_main/admin_account_list", method = RequestMethod.POST)
    public ModelAndView getUsers() throws IOException, ServletException, SQLException {
        List<Account> accounts;
        ModelAndView modelAndView = new ModelAndView("admin_account_list");
        accounts = adminService.doAdminGetAllAccounts();
        modelAndView.getModel().put("list", accounts);
        return modelAndView;
    }
}

package Controllers;

import Forms.RegisterForm;
import Forms.SignInForm;
import entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Repositories.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class LoginController {

    @Inject DatabaseAccessObject dao;

    @RequestMapping("/")
    public String index(HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u != null) return "redirect:/Products";
        return "/HomePage";
    }

    @RequestMapping("/Register")
    public String register(Map<String, Object> model, HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u != null) return "redirect:/Products";
        model.put("registerForm", new RegisterForm());
        return "/RegistrationPage";
    }

    @RequestMapping(value="/Register", method= RequestMethod.POST)
    public String getRegistration(Map<String, Object> model, RegisterForm form, HttpSession session)
    {
        User user = new User(form.getLoginId(),form.getPassword());
        Address address = new Address(
                form.getFirstName(),form.getLastName(),form.getAddress(),
                form.getCity(),form.getState(),form.getZipCode());
        address.setUser(user);

        if(form.getPassword().equals(form.getPassword2()) && !dao.isEmailTaken(user)) {
            this.dao.saveUser(user);
            this.dao.saveAddress(address);

            session.setAttribute("user",user);

            ArrayList<OrderItem> shoppingCart = new ArrayList<>();
            session.setAttribute("shoppingCart",shoppingCart);


            return "redirect:/Products";
        }
        else if( dao.isEmailTaken(user)){
            String error = "This Email is Already In Use";
            model.put("error",error);
            return "/RegistrationPage";
        }
        else if(!form.getPassword().equals(form.getPassword2())){
            String error = "Passwords Do Not Match";
            model.put("error",error);
            return "/RegistrationPage";
        }
        else {
            return "/RegistrationPage";
        }
    }

    @RequestMapping("/Login")
    public String signIn(Map<String, Object> model, HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u != null) return "redirect:/Products";
        model.put("signInForm", new SignInForm());
        return "/LoginPage";
    }

    @RequestMapping(value="/Login", method=RequestMethod.POST)
    public String getSignIn(Map<String, Object> model,SignInForm form, HttpSession session)
    {
        User user = new User(form.getLoginId(),form.getPassword());
        if(dao.isVerifiedUser(user)) {
            session.setAttribute("user",user);
            ArrayList<OrderItem> shoppingCart = new ArrayList<>();
            session.setAttribute("shoppingCart",shoppingCart);
            return "redirect:/Products";
        }
        else{
            String error = "Incorrect Email Or Password";
            model.put("error",error);
            return "/LoginPage";
        }
    }

}

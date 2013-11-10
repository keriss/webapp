package lu.lv.keriss.testapp.controllers;

import lu.lv.keriss.testapp.model.User;
import lu.lv.keriss.testapp.services.IBookDao;
import lu.lv.keriss.testapp.services.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope(value = "prototype")
public class UserController {
    
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IBookDao bookDao;

    //Display all users and books
    @RequestMapping(value = "/users.html", method = RequestMethod.GET)
    public ModelAndView listUsersAndBooks(){
        Map data = new HashMap();
        data.put("users",userDao.getAll());
        data.put("books",bookDao.getAll());
        return new ModelAndView("WEB-INF/jsp/users.jsp", "data", data);
    }
        
    //Prepare new user
    @RequestMapping(value = "/addUser.html", method = RequestMethod.GET)
    public String showCreateUser(Model model) {
        User user = new User();
        user.setActive(true);
        model.addAttribute("user", user);
        model.addAttribute("bookList", bookDao.getFree(user.getBooks()));
        return "WEB-INF/jsp/addEditUser.jsp";
    }

    //Process new user
    @RequestMapping(value = "/addUser.html", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("user") User user,
                          BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            model.put("bookList", bookDao.getFree(user.getBooks()));
            return "WEB-INF/jsp/addEditUser.jsp";
        }
        userDao.addUser(user);
        bookDao.updateBusy(user.getBooks(),true);
        return "redirect:" + "/users.html";
    }

    //Prepare user edit
    @RequestMapping(value = "/editUser.html", method = RequestMethod.GET)
    public String showEditUser(@RequestParam("id") Long id, Model model) {
        User user = userDao.findUserById(id);
        model.addAttribute("bookList", bookDao.getFree(user.getBooks()));
        model.addAttribute("user", user);
        return "WEB-INF/jsp/addEditUser.jsp";
    }


    //Process user update
    @RequestMapping(value = "/editUser.html", method = RequestMethod.POST)
    public String editUser(@Valid @ModelAttribute("user") User user,
                          BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            model.put("bookList", bookDao.getFree(user.getBooks()));
            return "WEB-INF/jsp/addEditUser.jsp";
        }
        bookDao.updateBusy(userDao.findUserById(user.getId()).getBooks(),false);
        userDao.updateUser(user);
        bookDao.updateBusy(user.getBooks(),true);

        return "redirect:" + "/users.html";
    }


    //Return user information
    @RequestMapping(value = "/infoUser.html", method = RequestMethod.GET)
    public String aboutUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("bookList", bookDao.getAll());
        model.addAttribute("user", userDao.findUserById(id));
        return "WEB-INF/jsp/infoUser.jsp";
    }

    //Process user delete
    @RequestMapping(value = "/deleteUser.html", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        bookDao.updateBusy(userDao.findUserById(id).getBooks(),false);
        userDao.deleteUser(id);
        return "redirect:" + "/users.html";
    }
}
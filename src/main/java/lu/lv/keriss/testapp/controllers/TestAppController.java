package lu.lv.keriss.testapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestAppController {

    @RequestMapping("/index.html")
    public String index(Model model) {
        return "WEB-INF/jsp/index.jsp";
    }

}
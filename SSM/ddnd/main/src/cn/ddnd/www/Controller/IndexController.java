package cn.ddnd.www.Controller;

import cn.ddnd.www.Entity.User;
import cn.ddnd.www.Service.Uservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    Uservice uservice;

    @RequestMapping(value = "/")
    public ModelAndView Index(){
        User user;
        user = uservice.getUserByEmail("xue8@ddnd.cn");
        return new ModelAndView("index", "user", user);
    }
}

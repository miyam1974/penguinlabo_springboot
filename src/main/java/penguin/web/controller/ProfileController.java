package penguin.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
@Controller
@RequestMapping("profile")
@SessionAttributes(names = "name")
public class ProfileController {
    @ModelAttribute("name")
    public String setName(String name) {
        return name;
    }

    @RequestMapping("name")
    public String name() {
        return "name";
    }
    @RequestMapping(path = "age", method = RequestMethod.POST)
    public String age(@RequestParam("name") String name, Model model) {
        setName(name);
        return "age";
    }
    @RequestMapping(path = "hello", method = RequestMethod.POST)
    public String hello(@RequestParam("name") String name, @RequestParam("age") String age, Model model, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        model.addAttribute("age", age);
        return "hello";
    }
}
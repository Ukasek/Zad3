package livecoding.example.demo.second;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @ResponseBody
    @GetMapping("/users")
    public String users() {
        List<User> users = userRepository.getAll();

        String result = "";
        for (User user : users) {
            result += user.toString() + "<br/>";
        }
        return result;
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam String imie, @RequestParam String nazwisko, @RequestParam Integer wiek) {
        if (StringUtils.isEmpty(imie)) {
            return "redirect:/err.html";
        } else {
            User user = new User(imie, nazwisko, wiek);

            userRepository.add(user);
            return "redirect:/success.html";
        }
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(required = false, defaultValue = "") String imie, @RequestParam(required = false, defaultValue = "") String nazwisko, @RequestParam(required = false, defaultValue = "") Integer wiek) {

        List<User> users = userRepository.getAll();

        for (User user : users) {
            if (user.getName().equalsIgnoreCase(imie) || user.getLastname().equalsIgnoreCase(nazwisko) || user.getAge() == wiek) {
                userRepository.delete(user);
                return "redirect:/successDelete.html";
            }
        }
        return "redirect:/err.html";
    }

    @ResponseBody
    @RequestMapping("/find")
    public String find(@RequestParam(required = false, defaultValue = "") String imie, @RequestParam(required = false, defaultValue = "") String nazwisko, @RequestParam(required = false, defaultValue = "") Integer wiek) {

        List<User> users = userRepository.getAll();

        String result = "";
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(imie) || user.getLastname().equalsIgnoreCase(nazwisko) || user.getAge() == wiek) {
                result += user.toString() + "<br/>";
            }
        }
        return result;
    }
}
package za.co.expertism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nguni52 on 16/03/23.
 */
@Controller
@RequestMapping("/home")
public class MainController {
    public static final String HOME = "/";

    /**
     * Displays the front end view when user first accesses the app
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }
}

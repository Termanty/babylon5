
package ohtumini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// Kaikki tuntemattomat kyselypolut ohjataan viitteiden listaus sivulle


@Controller
public class DefaultController {
 
    @RequestMapping("*")
    public String handleDefault() {
        return "redirect: /references";
    }
}
package website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

    /*sin on veut pas que le code cherche un template il faut
    ajouter
    @ResponseBody
    */
    @GetMapping("/")
    public String home(@RequestParam(required = false, defaultValue="World") String name, ModelMap modelMap){
        modelMap.put("name", name);
        return "pages/home";
    }

    /*

    Ce qu'on peut faire en Java sans spring

    public String home(HttpServletRequest request, ModelMap modelMap){
        String name = request.getParameter("name") != null && !request.getParameter("name").isEmpty()
                ? request.getParameter("name")
                : "World";

        System.out.println("\n\n\n"+name);
        //condition ? true(ce qu'on fait si c'est vrai)  : false(sinon);

        //on passe vraiable au template
        modelMap.put("name", name);
        return "pages/home";
    }

    */
}

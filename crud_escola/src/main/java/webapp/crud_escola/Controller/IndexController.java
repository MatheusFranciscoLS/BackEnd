package webapp.crud_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    // método
    @GetMapping("/")
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView homeIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/login-adm") // endereço da pagina no site
    public ModelAndView abrirLoginAdm() {
        ModelAndView mv = new ModelAndView("adm/login-adm");
        return mv;
    }

    @GetMapping("/login-professor") // endereço da pagina no site
    public ModelAndView abrirLoginProf() {
        ModelAndView mv = new ModelAndView("professores/login-professor");
        return mv;
    }

    @GetMapping("/login-usuario") // endereço da pagina no site
    public ModelAndView abrirLoginUsuario() {
        ModelAndView mv = new ModelAndView("usuarios/login-usuario");
        return mv;
    }

    @GetMapping("/cad-adm") // endereço da pagina no site
    public ModelAndView abrirCadAdm() {
        ModelAndView mv = new ModelAndView("adm/cad-adm");
        return mv;
    }

    @GetMapping("/cad-professor") // endereço da pagina no site
    public ModelAndView abrirCadProf() {
        ModelAndView mv = new ModelAndView("professores/cad-professor");
        return mv;
    }

    @GetMapping("/cad-usuario") // endereço da pagina no site
    public ModelAndView abrirCadUsuario() {
        ModelAndView mv = new ModelAndView("usuarios/cad-usuario");
        return mv;
    }

    @GetMapping("/professor") // endereço da pagina no site
    public ModelAndView abrirProf() {
        ModelAndView mv = new ModelAndView("professores/professor");
        return mv;
    }

    @GetMapping("/usuario") // endereço da pagina no site
    public ModelAndView abrirUsuario() {
        ModelAndView mv = new ModelAndView("usuario");
        return mv;
    }
}

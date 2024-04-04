package webapp.crud_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcessoAdmController {
    
    @GetMapping("/acesso-adm")
    public String acessoAdm() {
        return "adm/interna-adm";
    }

    @GetMapping("/cadastrar-professor")
    public String cadastrarProfessor() {
        return "adm/cadastrar-professor";
    }
}


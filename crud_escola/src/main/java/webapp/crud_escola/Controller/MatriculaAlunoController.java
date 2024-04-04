package webapp.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import webapp.crud_escola.Model.Usuario;

@Controller
public class MatriculaAlunoController {

    @Autowired
    private UsuarioController ur;

    @GetMapping("/matricula-aluno")
    public String exibirPaginaMatricula(Model model) {
        model.addAttribute("aluno", new Usuario());
        return "adm/matricula-aluno";
    }

    @PostMapping("/cadastrar-aluno")
    public String cadastrarAluno(@ModelAttribute Usuario usuario) {
        ur.save(usuario);
        return "redirect:/matricula-aluno";
    }
}


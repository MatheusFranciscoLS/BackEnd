package webapp.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import webapp.crud_escola.Model.Usuario;
import webapp.crud_escola.Repository.UsuarioRepository;
import webapp.crud_escola.Repository.VerificaCadastroUsuarioRepository;
@Controller
public class UsuarioController {
    @Autowired
    UsuarioRepository ar;
    @Autowired
    private VerificaCadastroUsuarioRepository vcar;

    @PostMapping("/cad-usuario")
    public String postCadAdm(Usuario prof) {
        String cpfVerificar = vcar.findByCpf(prof.getCpf()).getCpf();
        if (cpfVerificar.equals(prof.getCpf())) {
            ar.save(prof);
        }
        return "usuarios/login-usuario";
    }
}



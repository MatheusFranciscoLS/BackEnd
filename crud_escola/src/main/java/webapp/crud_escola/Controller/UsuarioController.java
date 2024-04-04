package webapp.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.crud_escola.Model.Usuario;
import webapp.crud_escola.Repository.UsuarioRepository;
import webapp.crud_escola.Repository.VerificaCadastroUsuarioRepository;
@Controller
public class UsuarioController {
    boolean acessoInternoUsuario = false;
    @Autowired
    UsuarioRepository ar;
    @Autowired
    private VerificaCadastroUsuarioRepository vcar;

    @PostMapping("/cad-usuario")
    public String postCadUsuario(Usuario usuario) {
        String cpfVerificar = vcar.findByCpf(usuario.getCpf()).getCpf();
        if (cpfVerificar.equals(usuario.getCpf())) {
            ar.save(usuario);
        }
        return "usuarios/login-usuario";
    }

    @PostMapping("acesso-usuario")
    public ModelAndView acessoUsuarioLogin(@RequestParam String cpf,
            @RequestParam String senha) {
        ModelAndView mv = new ModelAndView();// página interna de acesso
        boolean acessoCPF = cpf.equals(ar.findByCpf(cpf).getCpf());
        boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha());
        if(acessoCPF && acessoSenha){
            String mensagem = "Login Realizado com sucesso";
            System.out.println(mensagem);
            acessoInternoUsuario = true;
            mv.setViewName("redirect:/interna-prof");
        } else {
            mv.addObject("classe", "vermelho");
            mv.setViewName("usuarios/login-usuario");
        }
        return mv;
    }

    @GetMapping("/interna-usuario")
    public String acessoPageInternaUsuario() {
        ModelAndView mv = new ModelAndView();
        String acesso = "";
        if (acessoInternoUsuario) {
            acesso = "interna/interna-usuario";
        } else {
            acesso = "usuarios/login-usuario";
            mv.addObject("classe", "vermelho");
        }

        return acesso;
    }

    public void save(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}



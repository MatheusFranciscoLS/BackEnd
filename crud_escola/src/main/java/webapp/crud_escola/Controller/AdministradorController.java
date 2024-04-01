package webapp.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.crud_escola.Model.Administrador;
import webapp.crud_escola.Repository.AdministradorRepository;
import webapp.crud_escola.Repository.VerificaCadastroAdmRepository;

@Controller
public class AdministradorController {
    boolean acessoInternoAdm = false;
    @Autowired
    AdministradorRepository ar;
    @Autowired
    private VerificaCadastroAdmRepository vcar;

    @PostMapping("/cad-adm")
    public String postCadAdm(Administrador adm) {
        String cpfVerificar = vcar.findByCpf(adm.getCpf()).getCpf();
        if (cpfVerificar.equals(adm.getCpf())) {
            ar.save(adm);
        }
        return "adm/login-adm";
    }

    @PostMapping("acesso-adm")
    public ModelAndView acessoAdmLogin(@RequestParam String cpf,
            @RequestParam String senha) {
        ModelAndView mv = new ModelAndView("interna/interna-adm");// página interna de acesso

        boolean acessoCPF = cpf.equals(ar.findByCpf(cpf).getCpf());
        boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha());
        if (acessoCPF && acessoSenha) {
            String mensagem = "Login Realizado com sucesso";
            System.out.println(mensagem);
            acessoInternoAdm = true;
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "verde");
        } else {
            String mensagem = "Login Não Efetuado";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
        }
        return mv;
    }

    @GetMapping("/interna-adm")
    public String acessoPageInternaAdm() {
        ModelAndView mv = new ModelAndView();
        String acesso = "";
        if (acessoInternoAdm) {
            acesso = "interna/interna-adm";
        } else {
            acesso = "login/login-adm";
            String mensagem = "Acesso não Permitido - faça Login";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
        }

        return acesso;
    }
}

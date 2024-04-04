package webapp.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.crud_escola.Model.Professor;
import webapp.crud_escola.Repository.ProfessoresRepository;
import webapp.crud_escola.Repository.VerificaCadastroProfRepository;

@Controller
public class ProfessorController {
    boolean acessoInternoProf = false;
    @Autowired
    ProfessoresRepository ar;
    @Autowired
    private VerificaCadastroProfRepository vcar;

    @PostMapping("/cad-professor")
    public String postCadProf(Professor prof) {
        String cpfVerificar = vcar.findByCpf(prof.getCpf()).getCpf();
        if (cpfVerificar.equals(prof.getCpf())) {
            ar.save(prof);
        }
        return "professores/login-professor";
    }

    @PostMapping("acesso-prof")
    public ModelAndView acessoProfLogin(@RequestParam String cpf,
            @RequestParam String senha) {
        ModelAndView mv = new ModelAndView();// página interna de acesso
    
        boolean acessoCPF = cpf.equals(ar.findByCpf(cpf).getCpf());
        boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha());
        if(acessoCPF && acessoSenha){
            String mensagem = "Login Realizado com sucesso";
            System.out.println(mensagem);
            acessoInternoProf = true;
            mv.setViewName("redirect:/interna-prof");
        } else {
            mv.addObject("classe", "vermelho");
            mv.setViewName("professores/login-professor");
        }
        return mv;
    }

    @GetMapping("/interna-prof")
    public String acessoPageInternaProf() {
        ModelAndView mv = new ModelAndView();
        String acesso = "";
        if (acessoInternoProf) {
            acesso = "interna/interna-prof";
        } else {
            acesso = "professores/login-professor";
            mv.addObject("classe", "vermelho");
        }

        return acesso;
    }
}



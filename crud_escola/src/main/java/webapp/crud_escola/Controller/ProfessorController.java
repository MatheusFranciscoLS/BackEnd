package webapp.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import webapp.crud_escola.Model.Professor;
import webapp.crud_escola.Repository.ProfessoresRepository;
import webapp.crud_escola.Repository.VerificaCadastroProfRepository;

@Controller
public class ProfessorController {
    @Autowired
    ProfessoresRepository ar;
    @Autowired
    private VerificaCadastroProfRepository vcar;

    @PostMapping("/cad-professor")
    public String postCadAdm(Professor prof) {
        String cpfVerificar = vcar.findByCpf(prof.getCpf()).getCpf();
        if (cpfVerificar.equals(prof.getCpf())) {
            ar.save(prof);
        }
        return "professores/login-professor";
    }
}



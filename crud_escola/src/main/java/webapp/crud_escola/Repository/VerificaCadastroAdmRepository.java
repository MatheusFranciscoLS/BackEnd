package webapp.crud_escola.Repository;

import org.springframework.data.repository.CrudRepository;
import webapp.crud_escola.Model.VerificaCadastroAdm;

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm, String > {
    // criado para a busca CadastroADM por cpf ou nome
    VerificaCadastroAdm findByCpf(String cpf);

    // criado para a busca CadastroADM por nome
    VerificaCadastroAdm findByNome(String nome);
 
}

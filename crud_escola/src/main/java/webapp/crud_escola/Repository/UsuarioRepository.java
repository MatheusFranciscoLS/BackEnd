package webapp.crud_escola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.crud_escola.Model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Usuario findByCpf(String cpf);

}

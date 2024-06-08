package com.matheus.api_final.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.matheus.api_final.Model.Responsavel;
import com.matheus.api_final.Repository.ResponsavelRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
    
    @Autowired
    ResponsavelRepository repository;

    @GetMapping()
    public List<Responsavel> getResponsavel() {
        List<Responsavel> responsaveis = (List<Responsavel>) repository.findAll();
        System.out.println(responsaveis);
        return responsaveis;
    }

@PostMapping()
public RedirectView postResponsavel(@RequestParam("idResponsavel") Long id,
                                     @RequestParam("nomeResponsavel") String nome) {
    Responsavel responsavel = new Responsavel();
    responsavel.setId(id);
    responsavel.setNome(nome);
    Responsavel salvo = repository.save(responsavel);
    System.out.println("Salvo: " + salvo);

    return new RedirectView("/admin", true); // Redireciona para a página "/admin"
}
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Responsavel>> getResponsavelById(@PathVariable Long id) {
        Optional<Responsavel> responsavel = repository.findById(id);
        if (responsavel.isPresent()) {
            System.out.println(responsavel);
            return ResponseEntity.ok(responsavel);
        } else {
            System.out.println("Responsável não encontrado");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Responsavel> putResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        Optional<Responsavel> busca = repository.findById(id);
        if (busca.isPresent()) {
            responsavel.setId(id);
            Responsavel atualizado = repository.save(responsavel);
            System.out.println("Atualizado: " + atualizado);
            return ResponseEntity.ok(atualizado);
        } else {
            System.out.println("Responsável não encontrado para atualização");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/editar/{id}")
    public String editarResponsavel(@PathVariable Long id, Model model) {
        Optional<Responsavel> responsavelOptional = repository.findById(id);
        if (responsavelOptional.isPresent()) {
            Responsavel responsavel = responsavelOptional.get();
            model.addAttribute("responsavel", responsavel);
            return "editarResponsavel"; // Retorna a página de edição
        } else {
            return "redirect:/admin"; // Redireciona para a página principal
        }
    }
    


    @DeleteMapping("/admin/{id}")
    public RedirectView deleteResponsavel(@PathVariable Long id) {
        Responsavel responsavel = repository.findById(id).orElse(null);
        if (responsavel != null) {
            repository.delete(responsavel);
            System.out.println("Deletado");
        } else {
            System.out.println("Responsável não encontrado para deleção");
        }
    
        return new RedirectView("/admin", true); // Redireciona para a página "/admin"
    }  
    
}
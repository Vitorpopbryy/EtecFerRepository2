package br.com.etecfer.etecfer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.repository.ProfessorRepository;

@Service
public class ProfessorService {
    
    //Injeção de dependencia do repositório para a classe Professor
    @Autowired
    private ProfessorRepository professorRepository;

    //Método para salvar um professor
    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }

    // Método para listar todos os professor
    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    // Método para excluir um Professor pelo id
    public void deleteById(Integer id){
        professorRepository.deleteById(id);
    }

    //Método para buscar o Professor pelo id
    public Professor findById(Integer id){
        return professorRepository.findById(id).orElse(null);
    }
}

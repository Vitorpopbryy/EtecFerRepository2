package br.com.etecfer.etecfer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Disciplina;
import br.com.etecfer.etecfer.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
    
    //Injeção de dependencia do repositório para a classe disciplina
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    //Método para salvar um Disciplina
    public Disciplina save(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    // Método para listar todos os disciplina
    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();
    }

    // Método para excluir um disciplina pelo id
    public void deleteById(Integer id){
        disciplinaRepository.deleteById(id);
    }

    //Método para buscar o disciplina pelo id
    public Disciplina findById(Integer id){
        return disciplinaRepository.findById(id).orElse(null);
    }
}
package br.com.etecfer.etecfer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Aluno;
import br.com.etecfer.etecfer.repository.AlunoReposity;

@Service
public class AlunoService {

    //Injeção de dependencia para a classe aluno
    @Autowired
    private AlunoReposity alunoReposity;

    //Método para salvar um aluno
    public Aluno save(Aluno aluno){
        return alunoReposity.save(aluno);
    }

    //Método para listar todos os aluno
    public List<Aluno> findAll(){
        return alunoReposity.findAll();
    }
    
}

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
    
    //metodo para excluir um aluno pelo id
    public void deleteById(Integer id){
        alunoReposity.deleteById(id);
    }

    //metodo para buscar o aluno pelo id
    public Aluno findById(Integer id){
        return alunoReposity.findById(id).orElse(null);
    }
}

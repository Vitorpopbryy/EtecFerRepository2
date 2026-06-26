package br.com.etecfer.etecfer.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Curso;
import br.com.etecfer.etecfer.repository.CursoReposity;

@Service
public class CursoService {

    //Injeção de dependencia para a classe aluno
    @Autowired
    private CursoReposity cursoReposity;

    //Método para salvar um aluno
    public Curso save(Curso curso){
        return cursoReposity.save(curso);
    }

    //Método para listar todos os aluno
    public List<Curso> findAll(){
        return cursoReposity.findAll();
    }
    
    //metodo para excluir um aluno pelo id
    public void deleteById(Integer id){
        cursoReposity.deleteById(id);
    }

    //metodo para buscar o aluno pelo id
    public Curso findById(Integer id){
        return cursoReposity.findById(id).orElse(null);
    }
}

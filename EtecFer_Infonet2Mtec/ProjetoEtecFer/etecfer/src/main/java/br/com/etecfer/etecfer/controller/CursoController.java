package br.com.etecfer.etecfer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.Service.CursoService;
import br.com.etecfer.etecfer.entity.Curso;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/cursos")
public class CursoController {

    //Injeção de depedências da service para a classe curso
    @Autowired
    private CursoService cursoService;

    //Método para salvar um aluno
    @PostMapping("/salvar")
    public String salvar(Curso  curso) {
        
        cursoService.save(curso);
        return "redirect:/cursos/listar";
    }

    //Método para listar todos os alunos
    @GetMapping("/listar")
    public String listar(Model model) {

        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "curso/listarCursos";
    }

    //Método para criar um formulário com um novo objeto aluno

    @GetMapping("/criar")
    public String criaForm(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/formularioCurso";
    }
    //metodo para excluir um aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        cursoService.deleteById(id);
        return "redirect:/cursos/listar";
    }
    
    //metodo para abrir o formulario de edição de alunos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model) {
        Curso curso = cursoService.findById(id);
        model.addAttribute("curso", curso);
        return "curso/formularioCurso";
    }
    
    
    
}   

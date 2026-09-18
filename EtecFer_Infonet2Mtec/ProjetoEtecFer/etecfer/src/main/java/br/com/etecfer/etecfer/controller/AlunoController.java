package br.com.etecfer.etecfer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.Service.AlunoService;
import br.com.etecfer.etecfer.Service.CursoService;
import br.com.etecfer.etecfer.entity.Aluno;
import br.com.etecfer.etecfer.entity.Curso;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/alunos")
public class AlunoController {

    //Injeção de depedências da service para a classe aluno
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    //Método para salvar um aluno
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno  aluno,
        @RequestParam("foto") MultipartFile foto) {
        try {
            if (!foto.isEmpty()) {
                aluno.setFotoAluno(foto.getBytes());
                aluno.setTipoFoto(foto.getContentType());
            } else if (aluno.getIdAluno() != null) {
                Aluno alunoExistente = alunoService.findById(aluno.getIdAluno());
                if (alunoExistente != null) {
                    aluno.setFotoAluno(alunoExistente.getFotoAluno());
                    aluno.setTipoFoto(alunoExistente.getTipoFoto());
                }
            }
        } catch (Exception e) {
            // Log or handle exception as needed
            e.printStackTrace();
        }

        alunoService.save(aluno);
        return "redirect:/alunos/listar";
    }

    //Método para listar todos os alunos
    @GetMapping("/listar")
    public String listar(Model model) {

        List<Aluno> alunos = alunoService.findAll();
        model.addAttribute("alunos", alunos);
        return "aluno/listarAlunos";
    }

    //Método para criar um formulário com um novo objeto aluno

    @GetMapping("/criar")
    public String criaForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "aluno/formularioAluno";
    }
    //metodo para excluir um aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        alunoService.deleteById(id);
        return "redirect:/alunos/listar";
    }
    
    //metodo para abrir o formulario de edição de alunos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "aluno/formularioAluno";
    }
    
    
    
}

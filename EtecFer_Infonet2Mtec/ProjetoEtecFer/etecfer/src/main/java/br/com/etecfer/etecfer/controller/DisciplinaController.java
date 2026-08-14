package br.com.etecfer.etecfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.entity.Curso;
import br.com.etecfer.etecfer.entity.Disciplina;
import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.Service.CursoService;
import br.com.etecfer.etecfer.Service.DisciplinaService;
import br.com.etecfer.etecfer.Service.ProfessorService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
    @RequestMapping("/disciplinas")
    public class DisciplinaController{

        //Injeção de dependência da service para a classe disciplina
        @Autowired
        private DisciplinaService disciplinaService;
         
        @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfessorService professorService;

        //Método para salvar um disciplina
        @PostMapping("/salvar")
        public String salvar(@ModelAttribute Disciplina disciplina) {
            disciplinaService.save(disciplina);

            return "redirect:/disciplinas/listar";
        }

        //Método para listar todos os Disciplinas
        @GetMapping("/listar")
        public String listar(Model model) {
            List <Disciplina> disciplinas = disciplinaService.findAll();
            model.addAttribute("disciplinas", disciplinas);
            return "disciplina/listarDisciplina.html";
        }

        //Método para criar um formulário com um novo objeto disciplina
        @GetMapping("/criar")
        public String criarForm(Model model) {
            model.addAttribute("disciplina", new Disciplina());
              List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);
            return "disciplina/formularioDisciplina";
        }

        //Método para excluir um disciplina
        @GetMapping("/excluir/{id}")
        public String excluir(@PathVariable("id") Integer id) {
            disciplinaService.deleteById(id);
            return "redirect:/disciplinas/listar";
        }

        //Método para abrir o formulario de edição de Disciplinas
        @GetMapping("/editar/{id}")
        public String editarForm(@PathVariable("id") Integer id, Model model) {
            Disciplina disciplina = disciplinaService.findById(id);
            model.addAttribute("disciplina", disciplina);
            List<Curso> cursos = cursoService.findAll();
            model.addAttribute("cursos", cursos);
            List<Professor> professores = professorService.findAll();
            model.addAttribute("professores", professores);
            return "disciplina/formularioDisciplina";
        }
        
        
        
        
        
}
package br.com.etecfer.etecfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.Service.ProfessorService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
    @RequestMapping("/professores")
    public class ProfessorController{

        //Injeção de dependência da service para a classe professor
        @Autowired
        private ProfessorService professorService;

        //Método para salvar um professor
        @PostMapping("/salvar")
        public String salvar(@ModelAttribute Professor professor) {
            professorService.save(professor);

            return "redirect:/professores/listar";
        }

        //Método para listar todos os professores
        @GetMapping("/listar")
        public String listar(Model model) {
            List <Professor> professores = professorService.findAll();
            model.addAttribute("professores", professores);
            return "professor/ListarProfessor.html";
        }

        //Método para criar um formulário com um novo objeto professor
        @GetMapping("/criar")
        public String criarForm(Model model) {
            model.addAttribute("professor", new Professor());
            return "professor/formularioProfessor";
        }

        //Método para excluir um professor
        @GetMapping("/excluir/{id}")
        public String excluir(@PathVariable("id") Integer id) {
           professorService.deleteById(id);
            return "redirect:/professores/listar";
        }

        //Método para abrir o formulario de edição de professores
        @GetMapping("/editar/{id}")
        public String editarForm(@PathVariable("id") Integer id, Model model) {
            Professor professor = professorService.findById(id);
            model.addAttribute("professor", professor);
            return "professor/formularioProfessor";
        }
        
        
        
        
        
}

package br.com.ifspcodelab.regescweb.controllers;

import br.com.ifspcodelab.regescweb.models.Professor;
import br.com.ifspcodelab.regescweb.models.StatusProfessor;
import br.com.ifspcodelab.regescweb.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfessorController {
    @Autowired //cria o objeto automaticamente
    private ProfessorRepository professorRepository;

   // public ProfessorController(ProfessorRepository professorRepository){
   //     this.professorRepository = professorRepository;
   // }
    @GetMapping("/professores")
    public ModelAndView index() {

        List<Professor> professores = this.professorRepository.findAll();

        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", professores);
        return mv;
    }
    @GetMapping("/professor/new")
    public ModelAndView nnew(){
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("statusProfessor", StatusProfessor.values());
         return mv;
    }
}

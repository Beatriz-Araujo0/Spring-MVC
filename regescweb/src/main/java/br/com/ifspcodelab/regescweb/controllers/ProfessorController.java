package br.com.ifspcodelab.regescweb.controllers;

import br.com.ifspcodelab.regescweb.dto.RequisicaoNovoProfessor;
import br.com.ifspcodelab.regescweb.models.Professor;
import br.com.ifspcodelab.regescweb.models.StatusProfessor;
import br.com.ifspcodelab.regescweb.repositories.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/professores/new")
    public ModelAndView nnew(RequisicaoNovoProfessor requisicao){
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("ListaStatusProfessor", StatusProfessor.values());
         return mv;
    }

    @PostMapping("/professores")
    public ModelAndView creat(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult){
        System.out.print(requisicao);
        if (bindingResult.hasErrors()) {
            System.out.println("\n************ TEM ERROS *************\n");

            ModelAndView mv = new ModelAndView("professores/new");
            mv.addObject("ListaStatusProfessor", StatusProfessor.values());
            return mv;
        }
        else {
        Professor professor = requisicao.toProfessor();
        this.professorRepository.save(professor);

        return new ModelAndView("redirect:/professores");
        }
    }
}

package com.conv.crudbasic.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.conv.crudbasic.models.Alimento;
import com.conv.crudbasic.repository.AlimentoRepository;


@Controller
public class AlimentoController {
	
	@Autowired
	private AlimentoRepository ar;
	
	@RequestMapping(value = "/cadastrarAlimento", method = RequestMethod.GET)
	public String form() {

		return "alimento/formAlimento";
	}
	
	@RequestMapping(value = "/cadastrarAlimento", method = RequestMethod.POST)
	public String form(Alimento alimento) {

		ar.save(alimento);
		return "redirect:/cadastrarAlimento";
	}
	
	@RequestMapping("/listarAlimentos")
	public ModelAndView listaAlimentos() {
		ModelAndView mv = new ModelAndView("alimento/listAlimentos");
		Iterable<Alimento> alimentos = ar.findAll();
		mv.addObject("alimentos", alimentos);
		return mv;
		 
	}
	
	
	@RequestMapping("/deletarAlimento")
	public String deletarAlimento(long codigo) {
		Alimento alimento = ar.findByCodigo(codigo);
		ar.delete(alimento);
		return "redirect:/listarAlimentos";
	}
	
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesAlimento(@PathVariable("codigo") long codigo){
		Alimento alimento = ar.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("alimento/detailsAlimento");
		mv.addObject("alimento", alimento);
		return mv;
		
	}
	

}
package com.org.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.spring.dao.FreelancerRepository;
import com.org.spring.entities.Freealancer;



@Controller
public class FreelancerController {
	
	@Autowired
	private FreelancerRepository FreeRepository;
	
	@RequestMapping(value="/Freelancers")
	public String index(Model model)
	{
		model.addAttribute("data",FreeRepository.findAll());
		return "Freelancers";
	}
	@RequestMapping(value="/add")
	public String Add(Model model)
	{
		model.addAttribute("freelancer1", new Freealancer());
		return "Create";
	}
	
	
	@RequestMapping(value="/insert")
    public String save(@Valid Freealancer F,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
		return "Create";
		}
		FreeRepository.save(F);
		return "redirect:/Freelancers";
	}
	@RequestMapping(value="/delete")
    public String Delete(int id)
	{
		FreeRepository.deleteById(id);
		return "redirect:/Freelancers";
	}
	@RequestMapping(value="/edit")
	public String edit(Model model,int id,Model listRoles)
	{
		Freealancer f = FreeRepository.getOne(id);
		model.addAttribute("Freelancer1", f);
		return "Update";
	}
	@RequestMapping(value="/update")
    public String Update(@ModelAttribute("Freelancer1") Freealancer fr)
	{
		Freealancer F= FreeRepository.getOne(fr.getId());
		F.setId(fr.getId());
		F.setFirstname(fr.getFirstname());
		F.setLastname(fr.getLastname());
		F.setEmail(fr.getEmail());
		F.setPassword(fr.getPassword());
		F.setDescription(fr.getDescription());
		F.setUsername(fr.getUsername());
		FreeRepository.save(F);
		return "redirect:/Freelancers";
	}
	
//	@GetMapping("/freelancers")
//	public List<Freealancer> getFreelancers()
//	{
//		return FreeRepository.findAll();
//	}
//	
//	@GetMapping("/freelancers/{id}")
//	public Optional<Freealancer> getFreelancer(@PathVariable int id)
//	{
//		return FreeRepository.findById(id);
//	}
//	
//	@DeleteMapping("/freelancers/{id}")
//	public boolean deletefreelancer(@PathVariable int id)
//	{	
//				FreeRepository.deleteById(id);
//				return true;
//	}
//	
//	@PutMapping("/freelancers")
//	public Freealancer updatefreelancer(@RequestBody Freealancer f)
//	{			
//		return FreeRepository.save(f); 
//	}
//	
//	@PostMapping("/freelancers")
//	public Freealancer createfreelancer(@RequestBody Freealancer f)
//	{			
//		return FreeRepository.save(f); 
//	}
}

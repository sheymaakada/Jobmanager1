package com.org.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.spring.dao.ClientsRepository;
import com.org.spring.dao.FreelancerRepository;
import com.org.spring.entities.Client;
import com.org.spring.entities.Freealancer;



@Controller
public class ClientsController {
	
	@Autowired
	private ClientsRepository clientRepository;

	
	@RequestMapping(value="/Clients")
	public String index(Model model)
	{
		model.addAttribute("data",clientRepository.findAll());
		return "Clients";
	}
	@RequestMapping(value="/addClient")
	public String Add(Model model,Model listRoles )
	{
		model.addAttribute("client", new Client());
		return "CreateClient";
	}
	
	@RequestMapping(value="/insertClient")
    public String save(Client c)
	{
		clientRepository.save(c);
		return "redirect:/Clients";
	}
	@RequestMapping(value="/deleteClient")
    public String Delete(int client_id)
	{
		clientRepository.deleteById(client_id);
		return "redirect:/Clients";
	}
	@RequestMapping(value="/editClient")
	public String edit(Model model,int id,Model listRoles )
	{
		Client c = clientRepository.getOne(id);
		model.addAttribute("Client1", c);
		return "UpdateClient";
	}
	@RequestMapping(value="/updateClient")
    public String Update(@ModelAttribute("Client1") Client cl)
	{
		Client c= clientRepository.getOne(cl.getClient_id());
		c.setClient_id(cl.getClient_id());
		c.setFirstname(cl.getFirstname());
		c.setLastname(cl.getLastname());
		c.setEmail(cl.getEmail());
		c.setPassword(cl.getPassword());
		c.setDescription(cl.getDescription());
		c.setUsername(cl.getUsername());
		clientRepository.save(c);
		return "redirect:/Clients";
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

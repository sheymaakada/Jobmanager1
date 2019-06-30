package com.org.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.spring.dao.CategoriesRepository;
import com.org.spring.dao.ClientsRepository;
import com.org.spring.dao.FreelancerRepository;
import com.org.spring.dao.JobsRepository;
import com.org.spring.entities.Categories;
import com.org.spring.entities.Freealancer;
import com.org.spring.entities.Jobs;



@Controller
public class JobsController {
	
	@Autowired
	private JobsRepository jobsRepository;
	@Autowired
	private CategoriesRepository categoriesRepository; 
	@Autowired
	private FreelancerRepository freelancerRepository;
	@Autowired 
	private ClientsRepository clientsRepository;
	
	@RequestMapping(value="/Jobs")
	public String index(Model model)
	{
		model.addAttribute("data",jobsRepository.findAll());
		return "Jobs";
	}
	
	@RequestMapping(value="/addJob")
	public String Add(Model model, Model listCategories,Model listFreelancers, Model listClients)
	{
		model.addAttribute("job", new Jobs());
		listFreelancers.addAttribute("f",freelancerRepository.findAll());
		listCategories.addAttribute("cat",categoriesRepository.findAll());
		listClients.addAttribute("clients",clientsRepository.findAll());
		return "CreateJob";
	}
	@RequestMapping(value="/insertJob")
    public String save(Jobs j)
		{
		jobsRepository.save(j);
		return "redirect:/Jobs";
		}
	@RequestMapping(value="/deleteJob")
    public String Delete(int id)
	{
		jobsRepository.deleteById(id);
		return "redirect:/Jobs";
	}
	@RequestMapping(value="/editJob")
	public String edit(Model model,int id,Model listCategories,Model listFreelancers,Model listClients)
	{
		Jobs j = jobsRepository.getOne(id);
		model.addAttribute("jobs1",j);
		listClients.addAttribute("clients",clientsRepository.findAll());
		listFreelancers.addAttribute("f",freelancerRepository.findAll());
		listCategories.addAttribute("cat",categoriesRepository.findAll());
		
		return "UpdateJob";
	}
	@RequestMapping(value="/updateJob")
    public String Update(@ModelAttribute("jobs1") Jobs jo)
	{
		Jobs j = jobsRepository.getOne(jo.getId());
		j.setDescription(jo.getDescription());
		j.setBudget(jo.getBudget());
		j.setDate_finish(jo.getDate_finish());
		j.setCategory(jo.getCategory());
		j.setStatus(jo.getStatus());
		j.setFreelancerId(jo.getFreelancerId());
		j.setClient_id(jo.getClient_id());
		jobsRepository.save(j);
		return "redirect:/Jobs";
	}
}

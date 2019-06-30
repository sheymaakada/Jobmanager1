package com.org.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.spring.dao.CategoriesRepository;
import com.org.spring.entities.Categories;


@Controller
public class CategoriesController {
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@RequestMapping(value="/Categories")
	public String index(Model model)
	{
		model.addAttribute("data",categoriesRepository.findAll());
		return "Categories";
	}
	
	@RequestMapping(value="/addCategory")
	public String Add(Model model)
	{
		model.addAttribute("Category1", new Categories());
		return "CreateCategory";
	}
	
	@RequestMapping(value="/insertCategory")
    public String save(@ModelAttribute("Category1") Categories c)
	{
		categoriesRepository.save(c);
		return "redirect:/Categories";
	}
	@RequestMapping(value="/deleteCategory")
    public String Delete(int id)
	{
		categoriesRepository.deleteById(id);
		return "redirect:/Categories";
	}
	@RequestMapping(value="/editCategory")
	public String edit(Model model,int id)
	{
		Categories cat = categoriesRepository.getOne(id);
		model.addAttribute("Category1", cat);
		return "UpdateCategory";
	}
	@RequestMapping(value="/updateCategory")
    public String Update(@ModelAttribute("Category1") Categories cat)
	{
		Categories c = categoriesRepository.getOne(cat.getId());
		c.setName(cat.getName());
		categoriesRepository.save(c);
		return "redirect:/Categories";
	}
	public CategoriesController() {
	}

}

package blog.haaga.assignment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import blog.haaga.assignment.domain.Discussion;
import blog.haaga.assignment.domain.DiscussionRepository;


@Controller

public class AdminController {
	@Autowired 
	private DiscussionRepository repository;
	
	@RequestMapping (value ="/blog")
	public String bloggers (Model model){
		model.addAttribute("discussions",repository.findAll());
		return "blog";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteDiscussion(@PathVariable("id") Long discussionId, Model model) {
		repository.delete(discussionId);
		return "redirect:../blog";
	}
	
	@RequestMapping (value ="/add")
	public String addPost(Model model){
		model.addAttribute("discussion",new Discussion());
		return "newpost";
}
	@RequestMapping (value ="/save", method = RequestMethod.POST)
	public String save (Discussion discussion){
		repository.save(discussion);
		return "redirect :blog";
	}
	

		


}
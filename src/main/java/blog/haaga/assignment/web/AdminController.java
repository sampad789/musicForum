package blog.haaga.assignment.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.haaga.assignment.domain.Discussion;
import blog.haaga.assignment.domain.DiscussionRepository;
import blog.haaga.assignment.domain.GenreRepository;


@Controller

public class AdminController {
	@Autowired
	private DiscussionRepository drepository;
	@Autowired
	private GenreRepository grepository;

	@RequestMapping(value = "/blog")
	public String bloggers(Model model) {
		model.addAttribute("discussions", drepository.findAll());
		return "blog";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteDiscussion(@PathVariable("id") Long discussionId, Model model) {
		drepository.delete(discussionId);
		return "redirect:../blog";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long discussionID, Model model) {
		model.addAttribute("discussion", drepository.findOne(discussionID));
		model.addAttribute("genres", grepository.findAll());
		return "editpost";
		}
	@RequestMapping(value = "/add")
	public String addPost(Model model) {
		model.addAttribute("discussion", new Discussion());
		model.addAttribute("genres", grepository.findAll());
		return "newpost";
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Discussion discussion,BindingResult bindingResult,Model model) {
		
		if (bindingResult.hasErrors()){
			//if the form has errors return Error
			return "newpost";
		}
		drepository.save(discussion);
		return "redirect:blog";
	}
	@RequestMapping(value = "/savenew", method = RequestMethod.POST)
	public String save(Discussion discussion) {
		drepository.save(discussion);
		return "blog";
	}

}
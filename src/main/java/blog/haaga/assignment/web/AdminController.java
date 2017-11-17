package blog.haaga.assignment.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.haaga.assignment.domain.Discussion;
import blog.haaga.assignment.domain.DiscussionRepository;
import blog.haaga.assignment.domain.GenreRepository;




@Controller

public class AdminController {
	@Autowired
	private DiscussionRepository drepository;
	@Autowired
	private GenreRepository grepository;

	@RequestMapping(value ="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(path="/*")
	public String index(Discussion discussions,Model model){
		List<Discussion> latest5Discussions=drepository.findTop5ByOrderByDateDesc();
		model.addAttribute("latest5discussions",latest5Discussions);
		
		List<Discussion> latest3Discussions= (List<Discussion>) drepository.findAllByOrderByIdDesc();
		model.addAttribute("latest3discussions",latest3Discussions);
		
		return "index";
	}
	@RequestMapping(value="/posts/view/{id}", method=RequestMethod.GET)
	public String viewPost(@PathVariable("id") Long id, Model model){
		
		
		model.addAttribute("discussion",drepository.findOne(id));
		
		return "view";
	}
	@RequestMapping(value = "/blog")
	public String bloggers(Model model) {
		model.addAttribute("discussions", drepository.findAll());
		return "blog";
	}
	//authorizing the admin only to delete the post but the user can edit it 
	@PreAuthorize("hasAuthority('ADMIN')")
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
	//Saving a new post
	@RequestMapping(value = "/savenew", method = RequestMethod.POST)
	public String save(Discussion discussion) {
		drepository.save(discussion);
		return "blog";
	}
	//Rest service to get all discussions
	@RequestMapping(value="discussions", method=RequestMethod.GET)
    public @ResponseBody List<Discussion> disListRest(){
    		return (List<Discussion>) drepository.findAll(); 
    }
    //Rest service to get discussions by id  
    @RequestMapping(value="/discussion/{id}", method = RequestMethod.GET)
    public @ResponseBody Discussion findDisRest(@PathVariable("id") Long discussionId) {	
    		return drepository.findOne(discussionId);
   }
}
package div.example.demo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import div.example.demo.YoyoCard;
import div.example.demo.data.YoyoCardRepository;

@Controller
@RequestMapping("/")
public class YoyoCardController {
	@Autowired
	private YoyoCardRepository repo;

	public List<YoyoCard> showAll() {
		return repo.findAll();
	}

	public void save(YoyoCard yoyoCard) {
		repo.save(yoyoCard);
	}

	public YoyoCard get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	@GetMapping("/home")
	public String viewHomePage(Model model) {
		List<YoyoCard> listYoyoCard = repo.findAll();
		;
		model.addAttribute("listYoyoCard", listYoyoCard);
		return "home";
	}

	@GetMapping("/new")
	public String showNewCard(Model model) {
		YoyoCard yoyocard = new YoyoCard();
		model.addAttribute("yoyocard", yoyocard);
		return "new_card";
	}

	@PostMapping("/save")
	public String saveCard(@Valid @ModelAttribute("yoyocard") YoyoCard yoyocard, Errors errors) {
		if(errors.hasErrors()) {
			return "new_card";
		}
		repo.save(yoyocard);
		return "redirect:/home";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditCard(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_card");
		YoyoCard yoyocard = repo.getOne(id);
		mav.addObject("yoyocard", yoyocard);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public String deleteCard(@PathVariable(name = "id") long id) {
		repo.deleteById(id);
		return "redirect:/home";
	}
}

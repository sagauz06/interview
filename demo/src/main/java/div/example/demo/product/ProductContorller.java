package div.example.demo.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import div.example.demo.data.Product;

@Controller
public class ProductContorller {
	@Autowired
	private ProductService service;

	@RequestMapping("/productList")
	public String viewList(Model model) {
		List<Product> listProduct = service.listAll();
		model.addAttribute("listProduct", listProduct);
		return "productList";
	}

	@GetMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}

	@PostMapping("/save")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, Errors errors) {
		if (errors.hasErrors()) {
			return "new_product";
		}
		service.save(product);
		return "redirect:/productList";
	}

	@PostMapping("/saveEdit")
	public String saveEditProduct(@Valid @ModelAttribute("product") Product product, Errors errors) {
		if (errors.hasErrors()) {
			return "edit_product";
		}
		service.save(product);
		return "redirect:/productList";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView editProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/productList";
	}
}

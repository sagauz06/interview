//package div.example.demo;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Controller
//@RequestMapping("/home")//valueAdded
//public class ValueAdded {
//
//	@GetMapping
//	public String showIDAndValue(Model model) {
//		List<YoyoCard> card = Arrays.asList(new YoyoCard("1", "Joy", 100)/*, new YoyoCard("2", "John", 100)*/);
//		model.addAttribute("card", card);
//		return "home";
//	}
//	
//	@PostMapping()
//	public String showAddValue(AddedValue addedValue) {
//		
//	return "test2";
//	}
//}
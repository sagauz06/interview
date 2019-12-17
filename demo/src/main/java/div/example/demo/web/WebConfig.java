package div.example.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
//		registry.addViewController("/test").setViewName("test");
		registry.addViewController("/login");
//		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}

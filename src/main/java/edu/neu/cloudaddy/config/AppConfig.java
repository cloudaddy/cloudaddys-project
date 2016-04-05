package edu.neu.cloudaddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "edu.neu.cloudaddy")
@Import({ WebSecurityConfig.class })
public class AppConfig  extends WebMvcConfigurerAdapter{
	private static final String TEMPLATE_RESOLVER_PREFIX = "/resource/templates/";
    private static final String TEMPLATE_RESOLVER_SUFFIX = ".html";
    private static final String TEMPLATE_RESOLVER_TEMPLATE_MODE = "HTML5";
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/clouddaddy");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("admin");
	    return driverManagerDataSource;
	}
	
	 @Bean
	    public ViewResolver viewResolver() {
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine((SpringTemplateEngine) templateEngine());

	        return viewResolver;
	    }

	    @Bean
	    public TemplateEngine templateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());

	        return templateEngine;
	    }

	    @Bean
	    public TemplateResolver templateResolver() {
	        TemplateResolver templateResolver = new ServletContextTemplateResolver();
	        templateResolver.setPrefix(TEMPLATE_RESOLVER_PREFIX);
	        templateResolver.setSuffix(TEMPLATE_RESOLVER_SUFFIX);
	        templateResolver.setTemplateMode(TEMPLATE_RESOLVER_TEMPLATE_MODE);

	        return templateResolver;
	    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/") .setCachePeriod(31556926);
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	    registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	    registry.addResourceHandler("/img/**").addResourceLocations("/img/");
	}
	   
}

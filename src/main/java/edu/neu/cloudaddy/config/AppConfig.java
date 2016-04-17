package edu.neu.cloudaddy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import edu.neu.cloudaddy.interceptors.SourceServerAddressInteceptor;

@EnableWebMvc
@Configuration
@EnableRedisHttpSession
@ComponentScan(basePackages = "edu.neu.cloudaddy")
@PropertySource("classpath:application.properties")
@Import({ WebSecurityConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter {
	private static final String TEMPLATE_RESOLVER_PREFIX = "/resource/templates/";
	private static final String TEMPLATE_RESOLVER_SUFFIX = ".html";
	private static final String TEMPLATE_RESOLVER_TEMPLATE_MODE = "HTML5";

	@Value("${mySql.url}")
	private String mysqlUrl;

	@Value("${mySql.username}")
	private String mysqlUsername;

	@Value("${mySql.password}")
	private String password;

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl(mysqlUrl);
		driverManagerDataSource.setUsername(mysqlUsername);
		driverManagerDataSource.setPassword(password);
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
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		  registry.addInterceptor(new SourceServerAddressInteceptor());
	}
	
	@Bean
    public JedisConnectionFactory connectionFactory() {
            return new JedisConnectionFactory(); 
    }
	
	@Bean
	public static ConfigureRedisAction configureRedisAction() {
	    return ConfigureRedisAction.NO_OP;
	}
}

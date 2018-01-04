package com.timbuchalka.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.timbuchalka.springdemo.interceptors.ExecutionTimerInterceptor;
import com.timbuchalka.springdemo.interceptors.HeaderInterceptor;

@Configuration
@ComponentScan("com.timbuchalka.springdemo")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private HeaderInterceptor headerInterceptor;
	
	@Autowired
	private ExecutionTimerInterceptor executionTimerInterceptor;
	
	@Bean
	public DataSource dataSource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource("jdbc/spring_db");
		return dataSource;
	}
	
	@Bean
	public UrlBasedViewResolver UrlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerInterceptor);
		registry.addInterceptor(executionTimerInterceptor).addPathPatterns("/location");
	}
}

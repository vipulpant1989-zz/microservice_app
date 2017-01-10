package com.bbt.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
public class WebConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*.html").addResourceLocations(
				"/app/views/");
		registry.addResourceHandler("/views/**").addResourceLocations(
				"/app/views/");
		registry.addResourceHandler("/json/**").addResourceLocations(
				"/app/json/");
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/app/css/");
		registry.addResourceHandler("/audio/**").addResourceLocations(
				"/app/audio/");
		registry.addResourceHandler("/scripts/**").addResourceLocations(
				"/app/scripts/");
		registry.addResourceHandler("/placeholders/**").addResourceLocations(
				"/app/placeholders/");
		registry.addResourceHandler("/js/**").addResourceLocations("/app/js/");
		registry.addResourceHandler("/img/**")
				.addResourceLocations("/app/img/");
		registry.addResourceHandler("/favicon/**").addResourceLocations(
				"/app/favicon/");
		registry.addResourceHandler("/dist/**").addResourceLocations(
				"/app/dist/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/app/index.html");
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/app/");
		resolver.setSuffix(".html");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.indentOutput(true).dateFormat(
				new SimpleDateFormat("yyyy-MM-dd"));
		converters
				.add(new MappingJackson2HttpMessageConverter(builder.build()));
		converters.add(new MappingJackson2XmlHttpMessageConverter(builder
				.createXmlMapper(true).build()));
		converters.add(new MappingJackson2HttpMessageConverter(
				new ObjectMapper()));

	}

}

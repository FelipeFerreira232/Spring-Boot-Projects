package com.example.example1;

import org.springframework.boot.autoconfigure.SpringBootApplication;	
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.domain.Parrot;
import com.example.domain.Person;
import com.example.domain.SomeComponent;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.example1")
public class Example1Application {

	public static void main(String[] args) {
		//SpringApplication.run(Example1Application.class, args);
		var context = new AnnotationConfigApplicationContext(Example1Application.class);
		
		/*
		Parrot papagaio1 = context.getBean("palmeiras", Parrot.class);
		Parrot papagaio2 = context.getBean("brasil", Parrot.class);
		
		System.out.println("Nomes dos papagaios no context: ");
		Map<String, Parrot> map = context.getBeansOfType(Parrot.class);
		Collection<Parrot> parrots = map.values();
		
		parrots.forEach(e -> System.out.println(e.getName()));
		*/
		Parrot parrot = context.getBean("papagaio",Parrot.class);
		Person p  = context.getBean("felipe",Person.class);
		//System.out.println("Person's name: " + p.getName());
		//System.out.println("Person's parrot name: " + parrot.getName());
		
		//Getting bean from context defined with @Bean annotation
		Integer num = context.getBean(Integer.class);
		System.out.println("My favorite number is: " + num);
		
		Integer birthYear = context.getBean("96", Integer.class);
		System.out.println("Year I was born: " + birthYear);
		
		//Getting bean from context defined with @Component annotation
		//SomeComponent hope = context.getBean(SomeComponent.class);
		//System.out.println(hope.getHope());
	}	

	
	@Bean(name="felipe")
	public Person person() {
		Person p = new Person();
		p.setName("Felipe");
		p.setParrot(parrot());
		return p;
	}

	@Bean(name="papagaio")
	public Parrot parrot() {
		return new Parrot("Papagaio do Felipe");
	}
	
}

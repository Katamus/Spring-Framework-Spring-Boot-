package com.bolsadeideas.springboot.reactor.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bolsadeideas.springboot.reactor.app.models.Usuario;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootReactorApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux<String> nombres = Flux.just("Andres Guzman","Pedro Fulano","maria Fulana","Juan DelGordo","Manolo Huevo", "Bruce lee", "Bruce Willis");
		Flux<Usuario> usuarios = nombres.map(nombre -> new Usuario(nombre.split(" ")[0].toUpperCase(),nombre.split(" ")[1].toUpperCase()))
				.filter(usuario -> {
					return usuario.getNombre().equalsIgnoreCase("bruce");
					})
				.doOnNext(e-> {
						if(e == null) {
							throw new RuntimeException("Nombres no pueden ser vácios");
						}
						System.out.println(e.getNombre().concat(" ".concat(e.getApellido())));
					})
				.map(usuario-> {
					String nombre =  usuario.getNombre().toLowerCase();
					usuario.setNombre(nombre);
					return usuario;
				})
				;
		
		usuarios.subscribe(
				e -> log.info(e.toString()),
				error -> log.error(error.getMessage()),
				new Runnable() {
					public void run() {
						log.info("Ha finalizado la ejecución del observable con exito");
					}
				}
		);
		
	}

}

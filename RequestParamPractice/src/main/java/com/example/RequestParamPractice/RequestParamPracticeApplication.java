package com.example.RequestParamPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Un alumno de secundaria desea poder contar con una API mediante la cual, al enviar las 3 notas de una materia obtenga como respuesta
// el promedio de la misma. Para el pasaje de notas como parámetro utilizar la annotation @RequestParam.

@SpringBootApplication
public class RequestParamPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestParamPracticeApplication.class, args);
	}


}

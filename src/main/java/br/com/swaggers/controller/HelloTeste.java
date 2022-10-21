package br.com.swaggers.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/exemplos")
@EnableSwagger2
@Api(tags="Exemplos")
@Tag(name = "")
public class HelloTeste {
	
	@GetMapping
	@ApiOperation("get de exemplo com texto simples")
	public String retorno(){
		return "Olá teste..";
		
	}
	
	@PostMapping
	@ApiOperation("POST de exemplo com texto simples")
	public String post() {
		return "Fazendo post";
	}
	@DeleteMapping
	@ApiOperation("Exclusão de exemplo com texto simples")
	public String delete() {
		return "Fazendo delete";
	}	
	
	@PutMapping
	@ApiOperation("Update de exemplo com texto simples")
	public String puts() {
		return "Fazendo put";
	}	

}

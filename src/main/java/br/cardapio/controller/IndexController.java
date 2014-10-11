package br.cardapio.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	@Inject private Result result;

	@Get("/")
	public void getIndex() {
		result.include("message", "GET - Bem Vindo ao nosso Cardápio Virtual!");
	}
	
	@Post("/")
	public void postIndex() {
		result.include("message", "POST - Bem Vindo ao nosso Cardápio Virtual!");
	}
}
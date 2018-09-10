package br.com.ifc.pagarme.controller;

import br.com.ifc.pagarme.model.Resposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagarme")
public class PagarMeController {
	
	@Autowired
	private Environment environment;
	
	@Value("${message:Default}")
    private String message;
	
	@GetMapping("/servico")
	public Resposta parser(@RequestParam(name="msg", required=false) String msg) {		

		Resposta resposta = new Resposta();
		resposta.setPorta(Integer.parseInt(environment.getProperty("local.server.port")));
		resposta.setMensagem(msg);
		resposta.setMensagemSistema(message);
		return resposta;
	}

}

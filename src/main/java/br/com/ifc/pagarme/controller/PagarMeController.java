package br.com.ifc.pagarme.controller;

import br.com.ifc.pagarme.model.Resposta;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RefreshScope
@RequestMapping("/pagarme")
public class PagarMeController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PagarMeController.class);

	@Autowired
	private Environment environment;

	@Value("${message:Default}")
	private String message;

	@GetMapping("/servico")
	@PreAuthorize("hasRole('ADMIN')")
	public Resposta parser(@RequestParam(name = "msg", required = false) String msg) {

		String ip = environment.getProperty("local.server.ip");

		if (ip == null) {
			try {
				ip = InetAddress.getLocalHost().getHostName();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
				
		Resposta resposta = new Resposta();
		resposta.setPorta(Integer.parseInt(environment.getProperty("local.server.port")));
		resposta.setIp(ip);
		resposta.setMensagem(msg);
		resposta.setMensagemSistema(message);
		
		LOGGER.info("Request of PagarME Service with answer " + new Gson().toJson(resposta) + "!");
		return resposta;
	}

}

package br.com.fabricadevs.ativos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadevs.ativos.entity.Crypto;
import br.com.fabricadevs.ativos.service.CryptoService;

@RestController
@RequestMapping("/v1/cryptos")
public class CryptoController {

	@Autowired
	private CryptoService cryptoService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	@CrossOrigin
	public List<Crypto> getCryptos() throws Exception {

		return cryptoService.getAllCryptos();

	}
	
}
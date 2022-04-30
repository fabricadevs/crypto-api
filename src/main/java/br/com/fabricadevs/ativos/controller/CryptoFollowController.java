package br.com.fabricadevs.ativos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadevs.ativos.entity.CryptoFollow;
import br.com.fabricadevs.ativos.service.CryptoFollowService;

@RestController
@RequestMapping("/v1/cryptos/follow")
public class CryptoFollowController {

	@Autowired
	private CryptoFollowService cryptoService;
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@CrossOrigin
	public CryptoFollow saveCryptos(@RequestBody CryptoFollow crypto) throws Exception {

		return cryptoService.saveCrypto(crypto);

	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@CrossOrigin
	public CryptoFollow updateCryptos(@RequestBody CryptoFollow crypto, @PathVariable("id") Long id) throws Exception {

		return cryptoService.updateCryptos(crypto, id);

	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@CrossOrigin
	public List<CryptoFollow> getAllFollows() throws Exception {

		return cryptoService.getAllFallows();

	}
}
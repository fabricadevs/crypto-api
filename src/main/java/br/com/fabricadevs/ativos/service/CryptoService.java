package br.com.fabricadevs.ativos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadevs.ativos.dao.CryptoDao;
import br.com.fabricadevs.ativos.entity.Crypto;

@Service
public class CryptoService {

	@Autowired
	private CryptoDao cryptoDao;
	
	public List<Crypto> getAllCryptos() throws Exception{
		return cryptoDao.findAll();
	}
	
}

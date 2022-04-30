package br.com.fabricadevs.ativos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadevs.ativos.dao.CryptoFollowDao;
import br.com.fabricadevs.ativos.entity.CryptoFollow;

@Service
public class CryptoFollowService {

	@Autowired
	private CryptoFollowDao cryptoDao;

	public CryptoFollow saveCrypto(CryptoFollow crypto) throws Exception {
		Long id = cryptoDao.createCrypto(crypto);
		if(id != null) {
			crypto.setId(id);
			return crypto;
		}else {
			return null;
		}
	}

	public CryptoFollow updateCryptos(CryptoFollow crypto, Long id) throws Exception {
		cryptoDao.updateCrypto(crypto, id);
		return crypto;
	}

	public List<CryptoFollow> getAllFallows() throws Exception {
		return cryptoDao.findAll();
	}
	
	
	
}

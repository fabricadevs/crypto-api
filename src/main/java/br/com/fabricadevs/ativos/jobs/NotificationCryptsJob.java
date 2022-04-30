package br.com.fabricadevs.ativos.jobs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.fabricadevs.ativos.dao.CryptoFollowDao;
import br.com.fabricadevs.ativos.entity.CryptoFollow;
import br.com.fabricadevs.ativos.entity.CurrencyExchangeRate;
import br.com.fabricadevs.ativos.utils.Constants;
import br.com.fabricadevs.ativos.utils.EmailUtil;

@Service
public class NotificationCryptsJob {

	@Autowired
	private CryptoFollowDao cryptoFollowDao;

	@Autowired
	private EmailUtil emailUtil;

	//@Scheduled(fixedDelay = 1000 * 60 * 4)
	public void updateCryptos() {

		try {

			List<CryptoFollow> followCryptos = cryptoFollowDao.findAll();

			if (followCryptos != null && followCryptos.size() > 0) {

				for (CryptoFollow cryptoFollow : followCryptos) {

					RestTemplate restTemplate = new RestTemplate();
					CurrencyExchangeRate pedido = restTemplate.getForObject(
							Constants.API_VANTAGE_URL + Constants.API_VANTAGE_PARAM_CURRENCY_EXCHANGE_RATE
									+ Constants.API_VANTAGE_PARAM_FROM + cryptoFollow.getCrypto().getId()
									+ Constants.API_VANTAGE_PARAM_TO_CURRENCY_BR + Constants.API_VANTAGE_KEY_TOKEN,
							CurrencyExchangeRate.class);

					if (pedido != null && pedido.getRealtimeCurrencyExchangeRate() != null) {
						if (cryptoFollow.getHigherTargetPrice()
								.compareTo(pedido.getRealtimeCurrencyExchangeRate().get5ExchangeRate()) <= 0) {
							emailUtil.sendEmail(null, null,
									"A Moeda: " + cryptoFollow.getCrypto().getId() + " atingiu seu ponto máximo",
									"A Moeda: " + cryptoFollow.getCrypto().getId() + " atingiu seu ponto máximo", "rafaelvalerini@gmail.com",
									null, "Rafael Valerini", false);
						} else if (cryptoFollow.getLowerTargetPrice()
								.compareTo(pedido.getRealtimeCurrencyExchangeRate().get5ExchangeRate()) >= 0) {
							emailUtil.sendEmail(null, null,
									"A Moeda: " + cryptoFollow.getCrypto().getId() + " atingiu seu ponto mínimo",
									"A Moeda: " + cryptoFollow.getCrypto().getId() + " atingiu seu ponto mínimo", "rafaelvalerini@gmail.com",
									null, "Rafael Valerini", false);
						}
					}

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}

package br.com.fabricadevs.ativos.jobs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.fabricadevs.ativos.dao.CryptoDao;
import br.com.fabricadevs.ativos.entity.Crypto;

@Service
public class UpdateCryptsJob {

	@Autowired
	private CryptoDao cryptoDao;
	
//	@Scheduled(fixedDelay = 1000 * 60 * 4)
	@Scheduled(cron = "0 0 4 * * ?")
	public void updateCryptos() {
		
		URL url = null;
		try {

			url = new URL("https://www.alphavantage.co/digital_currency_list/");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

        CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase();

        try(CSVParser csvParser = CSVParser.parse(url, StandardCharsets.UTF_8, csvFormat)) {
            for(CSVRecord csvRecord : csvParser) {
            	Crypto crypto = new Crypto();
            	crypto.setId(csvRecord.get(0));
            	crypto.setName(csvRecord.get(1));
            	try {
					cryptoDao.saveOrUpdate(crypto);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
}

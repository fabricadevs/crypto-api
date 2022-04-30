package br.com.fabricadevs.ativos.utils;

public interface Constants {

	String API_VANTAGE_URL = "https://www.alphavantage.co/query";
	String API_VANTAGE_TOKEN = "YOUR_API_KEY";
	String API_VANTAGE_PARAM_CURRENCY_EXCHANGE_RATE = "?function=CURRENCY_EXCHANGE_RATE";
	String API_VANTAGE_PARAM_TO_CURRENCY_BR = "&to_currency=BRL";
	String API_VANTAGE_KEY_TOKEN = "&apikey=" + API_VANTAGE_TOKEN;
	String API_VANTAGE_PARAM_FROM = "&from_currency=";
}


package br.com.fabricadevs.ativos.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Realtime Currency Exchange Rate" })
public class CurrencyExchangeRate {

	@JsonProperty("Realtime Currency Exchange Rate")
	private RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Realtime Currency Exchange Rate")
	public RealtimeCurrencyExchangeRate getRealtimeCurrencyExchangeRate() {
		return realtimeCurrencyExchangeRate;
	}

	@JsonProperty("Realtime Currency Exchange Rate")
	public void setRealtimeCurrencyExchangeRate(RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate) {
		this.realtimeCurrencyExchangeRate = realtimeCurrencyExchangeRate;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

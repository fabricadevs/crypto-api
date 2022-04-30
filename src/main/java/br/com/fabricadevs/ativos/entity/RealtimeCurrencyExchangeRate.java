
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
@JsonPropertyOrder({ "1. From_Currency Code", "2. From_Currency Name", "3. To_Currency Code", "4. To_Currency Name",
		"5. Exchange Rate", "6. Last Refreshed", "7. Time Zone", "8. Bid Price", "9. Ask Price" })
public class RealtimeCurrencyExchangeRate {

	@JsonProperty("1. From_Currency Code")
	private String _1FromCurrencyCode;
	@JsonProperty("2. From_Currency Name")
	private String _2FromCurrencyName;
	@JsonProperty("3. To_Currency Code")
	private String _3ToCurrencyCode;
	@JsonProperty("4. To_Currency Name")
	private String _4ToCurrencyName;
	@JsonProperty("5. Exchange Rate")
	private Double _5ExchangeRate;
	@JsonProperty("6. Last Refreshed")
	private String _6LastRefreshed;
	@JsonProperty("7. Time Zone")
	private String _7TimeZone;
	@JsonProperty("8. Bid Price")
	private String _8BidPrice;
	@JsonProperty("9. Ask Price")
	private String _9AskPrice;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("1. From_Currency Code")
	public String get1FromCurrencyCode() {
		return _1FromCurrencyCode;
	}

	@JsonProperty("1. From_Currency Code")
	public void set1FromCurrencyCode(String _1FromCurrencyCode) {
		this._1FromCurrencyCode = _1FromCurrencyCode;
	}

	@JsonProperty("2. From_Currency Name")
	public String get2FromCurrencyName() {
		return _2FromCurrencyName;
	}

	@JsonProperty("2. From_Currency Name")
	public void set2FromCurrencyName(String _2FromCurrencyName) {
		this._2FromCurrencyName = _2FromCurrencyName;
	}

	@JsonProperty("3. To_Currency Code")
	public String get3ToCurrencyCode() {
		return _3ToCurrencyCode;
	}

	@JsonProperty("3. To_Currency Code")
	public void set3ToCurrencyCode(String _3ToCurrencyCode) {
		this._3ToCurrencyCode = _3ToCurrencyCode;
	}

	@JsonProperty("4. To_Currency Name")
	public String get4ToCurrencyName() {
		return _4ToCurrencyName;
	}

	@JsonProperty("4. To_Currency Name")
	public void set4ToCurrencyName(String _4ToCurrencyName) {
		this._4ToCurrencyName = _4ToCurrencyName;
	}

	@JsonProperty("5. Exchange Rate")
	public Double get5ExchangeRate() {
		return _5ExchangeRate;
	}

	@JsonProperty("5. Exchange Rate")
	public void set5ExchangeRate(Double _5ExchangeRate) {
		this._5ExchangeRate = _5ExchangeRate;
	}

	@JsonProperty("6. Last Refreshed")
	public String get6LastRefreshed() {
		return _6LastRefreshed;
	}

	@JsonProperty("6. Last Refreshed")
	public void set6LastRefreshed(String _6LastRefreshed) {
		this._6LastRefreshed = _6LastRefreshed;
	}

	@JsonProperty("7. Time Zone")
	public String get7TimeZone() {
		return _7TimeZone;
	}

	@JsonProperty("7. Time Zone")
	public void set7TimeZone(String _7TimeZone) {
		this._7TimeZone = _7TimeZone;
	}

	@JsonProperty("8. Bid Price")
	public String get8BidPrice() {
		return _8BidPrice;
	}

	@JsonProperty("8. Bid Price")
	public void set8BidPrice(String _8BidPrice) {
		this._8BidPrice = _8BidPrice;
	}

	@JsonProperty("9. Ask Price")
	public String get9AskPrice() {
		return _9AskPrice;
	}

	@JsonProperty("9. Ask Price")
	public void set9AskPrice(String _9AskPrice) {
		this._9AskPrice = _9AskPrice;
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

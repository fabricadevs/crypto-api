package br.com.fabricadevs.ativos.entity;

public class CryptoFollow {

	private Long id;
	private Crypto crypto;
	private Double higherTargetPrice;
    private Double lowerTargetPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Crypto getCrypto() {
		return crypto;
	}
	public void setCrypto(Crypto crypto) {
		this.crypto = crypto;
	}
	public Double getHigherTargetPrice() {
		return higherTargetPrice;
	}
	public void setHigherTargetPrice(Double higherTargetPrice) {
		this.higherTargetPrice = higherTargetPrice;
	}
	public Double getLowerTargetPrice() {
		return lowerTargetPrice;
	}
	public void setLowerTargetPrice(Double lowerTargetPrice) {
		this.lowerTargetPrice = lowerTargetPrice;
	}
}

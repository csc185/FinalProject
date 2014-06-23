package wollits.hibernate;

// Generated Jun 14, 2014 7:45:27 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VariableDeliveryRates generated by hbm2java
 */
@Entity
@Table(name = "variable_delivery_rates", catalog = "wollits")
public class VariableDeliveryRates implements java.io.Serializable {

	private int variableDeliveryRateId;
	private Restaurants restaurants;
	private double maximumDistanceKm;
	private byte[] pricePerKm;

	public VariableDeliveryRates() {
	}

	public VariableDeliveryRates(int variableDeliveryRateId,
			Restaurants restaurants, double maximumDistanceKm, byte[] pricePerKm) {
		this.variableDeliveryRateId = variableDeliveryRateId;
		this.restaurants = restaurants;
		this.maximumDistanceKm = maximumDistanceKm;
		this.pricePerKm = pricePerKm;
	}

	@Id
	@Column(name = "variable_delivery_rate_id", unique = true, nullable = false)
	public int getVariableDeliveryRateId() {
		return this.variableDeliveryRateId;
	}

	public void setVariableDeliveryRateId(int variableDeliveryRateId) {
		this.variableDeliveryRateId = variableDeliveryRateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = false)
	public Restaurants getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}

	@Column(name = "maximum_distance_km", nullable = false, precision = 22, scale = 0)
	public double getMaximumDistanceKm() {
		return this.maximumDistanceKm;
	}

	public void setMaximumDistanceKm(double maximumDistanceKm) {
		this.maximumDistanceKm = maximumDistanceKm;
	}

	@Column(name = "price_per_km", nullable = false)
	public byte[] getPricePerKm() {
		return this.pricePerKm;
	}

	public void setPricePerKm(byte[] pricePerKm) {
		this.pricePerKm = pricePerKm;
	}

}
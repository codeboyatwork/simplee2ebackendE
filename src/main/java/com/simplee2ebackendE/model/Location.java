package com.simplee2ebackendE.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	private long locationId;

	private String address;

	private String city;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="\"STATE\"")
	private String state;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	//bi-directional many-to-one association to Warehous
	@OneToMany(mappedBy="location")
	private List<Warehous> warehouses;

	public Location() {
	}

	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Warehous> getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(List<Warehous> warehouses) {
		this.warehouses = warehouses;
	}

	public Warehous addWarehous(Warehous warehous) {
		getWarehouses().add(warehous);
		warehous.setLocation(this);

		return warehous;
	}

	public Warehous removeWarehous(Warehous warehous) {
		getWarehouses().remove(warehous);
		warehous.setLocation(null);

		return warehous;
	}

}
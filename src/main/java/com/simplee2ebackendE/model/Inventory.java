package com.simplee2ebackendE.model;

import java.io.Serializable;
import javax.persistence.*;

import com.simplee2ebackendE.model.*;

import java.math.BigDecimal;

/**
 * The persistent class for the INVENTORIES database table.
 * 
 */
@Entity
@Table(name="INVENTORIES")
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InventoryPK id;

	private BigDecimal quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
//	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	//bi-directional many-to-one association to Warehous
	@ManyToOne
//	@JoinColumn(name="WAREHOUSE_ID")
	private Warehous warehous;

	public Inventory() {
	}

	public InventoryPK getId() {
		return this.id;
	}

	public void setId(InventoryPK id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Warehous getWarehous() {
		return this.warehous;
	}

	public void setWarehous(Warehous warehous) {
		this.warehous = warehous;
	}

}
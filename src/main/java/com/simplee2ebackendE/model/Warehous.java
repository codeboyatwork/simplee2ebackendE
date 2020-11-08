package com.simplee2ebackendE.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the WAREHOUSES database table.
 * 
 */
@Entity
@Table(name="WAREHOUSES")
@NamedQuery(name="Warehous.findAll", query="SELECT w FROM Warehous w")
public class Warehous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WAREHOUSE_ID")
	private long warehouseId;

	@Column(name="WAREHOUSE_NAME")
	private String warehouseName;

	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="warehous")
	private List<Inventory> inventories;

	//bi-directional many-to-one association to Location
	@ManyToOne
//	@JoinColumn(name="LOCATION_ID")
	private Location location;

	public Warehous() {
	}

	public long getWarehouseId() {
		return this.warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return this.warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setWarehous(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setWarehous(null);

		return inventory;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
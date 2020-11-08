package com.simplee2ebackendE.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORDER_ITEMS database table.
 * 
 */
@Embeddable
public class OrderItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORDER_ID", insertable=false, updatable=false)
	private long orderId;

	@Column(name="ITEM_ID")
	private long itemId;

	public OrderItemPK() {
	}
	public long getOrderId() {
		return this.orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getItemId() {
		return this.itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderItemPK)) {
			return false;
		}
		OrderItemPK castOther = (OrderItemPK)other;
		return 
			(this.orderId == castOther.orderId)
			&& (this.itemId == castOther.itemId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.orderId ^ (this.orderId >>> 32)));
		hash = hash * prime + ((int) (this.itemId ^ (this.itemId >>> 32)));
		
		return hash;
	}
}
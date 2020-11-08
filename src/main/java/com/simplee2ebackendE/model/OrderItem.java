package com.simplee2ebackendE.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ORDER_ITEMS database table.
 * 
 */
@Entity
@Table(name="ORDER_ITEMS")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id;

	private BigDecimal quantity;

	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne
//	@JoinColumn(name="ORDER_ID")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
//	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public OrderItem() {
	}

	public OrderItemPK getId() {
		return this.id;
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
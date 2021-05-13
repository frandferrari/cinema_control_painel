package entities;

import java.io.Serializable;

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer quantity;

	public Ticket() {
	}
	
	public Ticket(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Ticket [quantity=" + quantity + "]";
	}
	
	

}

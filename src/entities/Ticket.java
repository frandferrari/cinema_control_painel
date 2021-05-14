package entities;

import java.io.Serializable;

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	private String number;
	private Integer quantity;

	public Ticket() {
	}

	public Ticket(String number, Integer quantity) {
		this.number = number;
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Ticket [number=" + number + ", quantity=" + quantity + "]";
	}

}

package com.espe.tech.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ReservationEvent {

	private final String id;
	private final String passengerName;
	private final Double price;
	private final List<String> emails;

	public ReservationEvent(String id, String passengerName, Double price, List<String> emails) {
		this.id = Objects.requireNonNull(id, "id no puede ser null");
		this.passengerName = Objects.requireNonNull(passengerName, "passengerName no puede ser null");
		this.price = Objects.requireNonNull(price, "price no puede ser null");

		List<String> emailCopy = new ArrayList<>(Objects.requireNonNull(emails, "emails no puede ser null"));
		this.emails = Collections.unmodifiableList(emailCopy);
	}

	public String getId() {
		return id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public Double getPrice() {
		return price;
	}

	public List<String> getEmails() {
		return Collections.unmodifiableList(new ArrayList<>(emails));
	}

	@Override
	public String toString() {
		return "ReservationEvent{" +
				"id='" + id + '\'' +
				", passengerName='" + passengerName + '\'' +
				", price=" + price +
				", emails=" + emails +
				'}';
	}
}
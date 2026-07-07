package com.espe.tech.controller;

import com.espe.tech.model.ReservationEvent;
import com.espe.tech.util.ReservationFilters;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RestController
public class ReservationStreamController {

	private static final ReservationEvent DEFAULT_RESERVATION = new ReservationEvent(
			"DEFAULT",
			"Reserva generica",
			1.0,
			List.of("default@reservations.com")
	);

	@GetMapping(value = "/api/reservations/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ReservationEvent> streamReservations() {
		ReservationEvent reservationOne = new ReservationEvent(
				"R-001",
				"Ana Torres",
				180.50,
				List.of("ana.torres@email.com")
		);

		ReservationEvent reservationTwo = new ReservationEvent(
				"R-002",
				"Luis Mendoza",
				0.0,
				List.of("luis.mendoza@email.com")
		);

		ReservationEvent reservationThree = new ReservationEvent(
				"R-003",
				"Camila Rios",
				245.75,
				List.of("camila.rios@email.com", "contacto.camila@email.com")
		);

		ReservationEvent reservationFour = new ReservationEvent(
				"R-004",
				"Pedro Salazar",
				-35.0,
				List.of()
		);

		ReservationEvent reservationFive = new ReservationEvent(
				"R-005",
				"Maria Gomez",
				320.00,
				List.of("maria.gomez@email.com")
		);

		return Flux.just(
					reservationOne,
					reservationTwo,
					reservationThree,
					reservationFour,
					reservationFive
			)
				.flatMap(reservation -> Mono.justOrEmpty(reservation))
				.filter(ReservationFilters.VALID_RESERVATION)
				.doOnNext(ReservationFilters.PRINT_PROCESSED_EVENT)
				.defaultIfEmpty(DEFAULT_RESERVATION)
				.delayElements(Duration.ofMillis(800));
	}
}
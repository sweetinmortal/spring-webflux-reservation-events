# Spring WebFlux Reservation Events

Proyecto Spring Boot 4.0.6 con WebFlux para procesar eventos de reserva en memoria, sin base de datos y sin JPA.

## Requisitos

- Java 21
- Gradle Wrapper

## Ejecutar

```bash
./gradlew.bat bootRun
```

## Endpoint

```bash
GET http://localhost:8080/api/reservations/stream
```

Prueba sugerida:

```bash
curl.exe -N -H "Accept: text/event-stream" http://localhost:8080/api/reservations/stream
```
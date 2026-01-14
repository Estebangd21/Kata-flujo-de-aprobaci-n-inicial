# Frontend (Angular) – Kata Flujo Genérico de Aprobación

Este frontend en Angular consume el backend Spring Boot expuesto en `http://localhost:8080`.

## Alcance (MVP)
- Crear una solicitud de aprobación.
- Consultar solicitudes pendientes por aprobador.
- Mostrar notificación simulada en la interfaz.

## Arquitectura
- Angular
- HttpClient para consumo de API REST
- Separación por servicios y componentes

## Endpoints consumidos
- POST /api/requests
- GET /api/requests?approverUser={user}&status=PENDING

## Nota
Este frontend es una referencia de implementación. El backend es completamente funcional y puede integrarse directamente con este frontend.

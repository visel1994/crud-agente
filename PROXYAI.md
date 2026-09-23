# crud-agente

POC: CRUD de establecimientos de salud generado por un agente local.

## Stack
- Java 21, Spring Boot 3.2.5, Maven
- Spring Web, Spring Data JPA, Bean Validation
- PostgreSQL en ejecución; H2 en memoria para los tests

## Estructura
- Paquete base: com.poc.crud
- Organizado por funcionalidad: com.poc.crud.establecimiento
- Código común (manejo de errores): com.poc.crud.comun

## Reglas
- Inyección por constructor, nunca @Autowired en campos
- Sin Lombok: escribir constructores, getters y setters a mano
- DTOs como Java records; nunca exponer entidades JPA en los controllers
- Validaciones con jakarta.validation (@NotBlank, @Size, @Valid)
- Usar imports jakarta.*, nunca javax.*
- No crear archivos que no estén en la sección Archivos del ticket

## Tests
- Repositorios: @DataJpaTest
- Services: JUnit 5 + Mockito (@ExtendWith(MockitoExtension.class)), sin contexto de Spring
- Controllers: @WebMvcTest + MockMvc + @MockBean del service
- Los tests nunca hacen llamadas HTTP reales ni usan bases de datos externas

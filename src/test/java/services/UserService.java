package services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    /**
     * Obtener lista de usuarios (paginada).
     *
     * @param page Número de página (ej: 1, 2, etc.)
     * @return Response de la API
     */
    public Response getUsers(int page) {
        return given()
                .queryParam("page", page)
                .when()
                .get("/api/users");
    }

    /**
     * Obtener un usuario por ID.
     *
     * @param userId ID del usuario
     * @return Response
     */
    public Response getUserById(int userId) {
        return given()
                .when()
                .get("/api/users/" + userId);
    }

    /**
     * Crear un nuevo usuario.
     *
     * @param body JSON con los datos del usuario
     * @return Response
     */
    public Response createUser(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/api/users");
    }

    /**
     * Actualizar usuario con PUT.
     *
     * @param userId ID del usuario
     * @param body   JSON actualizado
     * @return Response
     */
    public Response updateUser(int userId, String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("/api/users/" + userId);
    }

    /**
     * Eliminar un usuario.
     *
     * @param userId ID del usuario
     * @return Response
     */
    public Response deleteUser(int userId) {
        return given()
                .when()
                .delete("/api/users/" + userId);
    }
}

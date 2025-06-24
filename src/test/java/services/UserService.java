package services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    /**
     * Obtener lista de usuarios.
     * GET https://jsonplaceholder.typicode.com/users
     *
     * @return Response
     */
    public Response getUsers() {
        return given()
                .when()
                .get("/users");
    }

    /**
     * Obtener usuario por ID.
     * GET https://jsonplaceholder.typicode.com/users/{id}
     *
     * @param userId ID del usuario
     * @return Response
     */
    public Response getUserById(int userId) {
        return given()
                .when()
                .get("/users/" + userId);
    }

    /**
     * Crear nuevo usuario.
     * POST https://jsonplaceholder.typicode.com/users
     *
     * @param body JSON con datos del usuario
     * @return Response
     */
    public Response createUser(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/users");
    }

    /**
     * Actualizar usuario.
     * PUT https://jsonplaceholder.typicode.com/users/{id}
     *
     * @param userId ID del usuario
     * @param body   JSON con datos actualizados
     * @return Response
     */
    public Response updateUser(int userId, String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("/users/" + userId);
    }

    /**
     * Eliminar usuario.
     * DELETE https://jsonplaceholder.typicode.com/users/{id}
     *
     * @param userId ID del usuario
     * @return Response
     */
    public Response deleteUser(int userId) {
        return given()
                .when()
                .delete("/users/" + userId);
    }
}

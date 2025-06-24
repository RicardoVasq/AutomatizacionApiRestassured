package test;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.UserService;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Epic("API JSONPlaceholder")
@Feature("POST Create User")
public class CreateUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test(description = "TC04 - Crear un nuevo usuario")
    @Severity(SeverityLevel.CRITICAL)
    @Story("El usuario crea un nuevo registro usando POST")
    public void testCreateUserSuccessfully() {

        String requestBody = """
                {
                    "name": "Ricardo Vasquez",
                    "username": "ricardoV",
                    "email": "ricardo.vasquez@example.com"
                }
                """;

        Response response = userService.createUser(requestBody);

        Allure.step("Validar status code 201");
        assertEquals(response.getStatusCode(), 201, "El status code esperado es 201");

        Allure.step("Validar que el usuario creado tenga el mismo nombre");
        String name = response.jsonPath().getString("name");
        assertEquals(name, "Ricardo Vasquez", "El nombre creado no coincide");

        Allure.step("Validar que el ID del nuevo usuario no sea nulo");
        Integer id = response.jsonPath().getInt("id");
        assertNotNull(id, "El ID del usuario creado es nulo");
    }
}

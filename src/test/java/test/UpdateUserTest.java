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

@Epic("API JSONPlaceholder")
@Feature("PUT Update User")
public class UpdateUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test(description = "TC05 - Actualizar un usuario existente")
    @Severity(SeverityLevel.CRITICAL)
    @Story("El usuario actualiza un registro usando PUT")
    public void testUpdateUserSuccessfully() {

        int userIdToUpdate = 1;

        String requestBody = """
                {
                    "name": "Ricardo Vasquez Updated",
                    "username": "ricardoV",
                    "email": "ricardo.vasquez.updated@example.com"
                }
                """;

        Response response = userService.updateUser(userIdToUpdate, requestBody);

        Allure.step("Validar status code 200");
        assertEquals(response.getStatusCode(), 200, "El status code esperado es 200");

        Allure.step("Validar que el usuario actualizado tenga el nombre modificado");
        String updatedName = response.jsonPath().getString("name");
        assertEquals(updatedName, "Ricardo Vasquez Updated", "El nombre no fue actualizado correctamente");
    }
}

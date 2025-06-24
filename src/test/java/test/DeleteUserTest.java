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

import static org.testng.Assert.assertTrue;

@Epic("API JSONPlaceholder")
@Feature("DELETE User")
public class DeleteUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test(description = "TC06 - Eliminar un usuario existente")
    @Severity(SeverityLevel.CRITICAL)
    @Story("El usuario elimina un registro usando DELETE")
    public void testDeleteUserSuccessfully() {

        int userIdToDelete = 1;

        Response response = userService.deleteUser(userIdToDelete);

        Allure.step("Validar status code 200 o 204");
        int statusCode = response.getStatusCode();
        assertTrue(statusCode == 200 || statusCode == 204, "El status code esperado es 200 o 204");

        Allure.step("Validar que el cuerpo de la respuesta esté vacío o con objeto vacío");
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.isEmpty() || responseBody.equals("{}"), "El cuerpo de la respuesta debe estar vacío");
    }
}

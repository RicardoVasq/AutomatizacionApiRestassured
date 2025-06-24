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
@Feature("GET User by ID")
public class GetUserByIdTest extends BaseTest {

    UserService userService = new UserService();

    @Test(description = "TC02 - Obtener usuario existente por ID")
    @Severity(SeverityLevel.CRITICAL)
    @Story("El usuario consulta un usuario existente por su ID")
    public void testGetUserByIdSuccessfully() {
        int existingUserId = 1;

        Response response = userService.getUserById(existingUserId);

        Allure.step("Validar status code 200");
        assertEquals(response.getStatusCode(), 200, "El status code no es 200");

        Allure.step("Validar que el usuario devuelto tenga el ID correcto");
        int returnedId = response.jsonPath().getInt("id");
        assertEquals(returnedId, existingUserId, "El ID devuelto no coincide");
    }
}

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
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

@Epic("API JSONPlaceholder")
@Feature("GET Users")
public class GetUsersTest extends BaseTest {

    UserService userService = new UserService();

    @Test(description = "TC01 - Obtener lista de usuarios")
    @Severity(SeverityLevel.CRITICAL)
    @Story("El usuario consulta la lista completa de usuarios")
    public void testGetUsersSuccessfully() {
        Response response = userService.getUsers();

        Allure.step("Validar status code 200");
        assertEquals(response.getStatusCode(), 200, "El status code no es 200");

        Allure.step("Validar que la lista de usuarios no sea vacía");
        assertNotNull(response.jsonPath().getList("$"), "La lista de usuarios es nula");
        assertFalse(response.jsonPath().getList("$").isEmpty(), "La lista de usuarios está vacía");
    }


}

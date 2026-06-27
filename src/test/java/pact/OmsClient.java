//package pact;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import static io.restassured.RestAssured.given;
//public class OmsClient {
//    private final String baseUrl;
//    public OmsClient(String baseUrl) {
//        this.baseUrl = baseUrl;
//    }
//    public Order createOrder(Order order) {
//        return given()
//                .baseUri(baseUrl)
//                .contentType(ContentType.JSON)
//                .body(order)
//                .when()
//                .post("/order")
//                .then()
//                .statusCode(201)
//                .extract()
//                .as(Order.class);
//    }
//    public Order getOrder(int orderId) {
//        Response response = given().baseUri(baseUrl)
//                .when()
//                .get("/order/" + orderId);
//        response.then().statusCode(200);
//        return response.as(Order.class);
//
//    }
//
//    public record Order(
//            int statuscode,
//            int orderId,
//            String status,
//            double total
//
//    ) {}
//
//}

package pact;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OmsClient {

    private final String baseUrl;

    public OmsClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // Create a new food order
    public FoodOrder createFoodOrder(FoodOrder order) {

        return given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post("/foodorder")
                .then()
                .statusCode(201)
                .extract()
                .as(FoodOrder.class);
    }

    // Get an existing food order
    public FoodOrder getFoodOrder(int orderId) {

        Response response = given()
                .baseUri(baseUrl)
                .when()
                .get("/foodorder/" + orderId);

        response.then().statusCode(200);

        return response.as(FoodOrder.class);
    }

    // Food Order Model
    public record FoodOrder(

            int statusCode,
            int orderId,
            String restaurantName,
            String foodItem,
            int quantity,
            double totalAmount,
            String orderStatus

    ) {
    }

}
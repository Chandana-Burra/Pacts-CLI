package pact;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class FoodProviderServer {

    private static WireMockServer server;

    public static void startServer() {

        server = new WireMockServer(4010);

        server.start();

        configureFor("localhost", 4010);

        // GET /foodorder/101
        server.stubFor(get(urlEqualTo("/foodorder/101"))
                .willReturn(okJson("""
                        {
                          "statusCode":200,
                          "orderId":101,
                          "restaurantName":"Pizza Hub",
                          "foodItem":"Veg Pizza",
                          "quantity":2,
                          "totalAmount":598.0,
                          "orderStatus":"CONFIRMED"
                        }
                        """)));

        // GET /restaurant/101
        server.stubFor(get(urlEqualTo("/restaurant/101"))
                .willReturn(okJson("""
                        {
                          "restaurantId":101,
                          "restaurantName":"Pizza Hub",
                          "city":"Chennai",
                          "open":true
                        }
                        """)));

        // POST /foodorder
        server.stubFor(post(urlEqualTo("/foodorder"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                  "statusCode":201,
                                  "orderId":101,
                                  "restaurantName":"Pizza Hub",
                                  "foodItem":"Veg Pizza",
                                  "quantity":2,
                                  "totalAmount":598.0,
                                  "orderStatus":"CONFIRMED"
                                }
                                """)));

        System.out.println("Food Provider started on port 4010");
    }

    public static void stopServer() {

        if (server != null) {
            server.stop();
        }
    }
}
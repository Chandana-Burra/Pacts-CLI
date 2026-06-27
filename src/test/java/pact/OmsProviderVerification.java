package pact;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("food-provider")
@PactBroker(
        url = "http://localhost:9292",
        enablePendingPacts = "true",
        providerTags = "main",
        includeWipPactsSince = "2026-06-26"
)
public class OmsProviderVerification {

    @BeforeAll
    static void beforeAll() {
        FoodProviderServer.startServer();
    }

    @AfterAll
    static void afterAll() {
        FoodProviderServer.stopServer();
    }

    @BeforeEach
    void setup(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", 4010, "/"));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void verify(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State("Food order 101 exists")
    void foodOrderExists() {
    }

    @State("Restaurant Pizza Hub is available")
    void restaurantAvailable() {
    }

    @State("Provider can create food orders")
    void createFoodOrder() {
    }
}
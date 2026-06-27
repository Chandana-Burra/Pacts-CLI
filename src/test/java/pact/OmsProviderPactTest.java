//package pact;
//import au.com.dius.pact.provider.junit5.HttpTestTarget;
//import au.com.dius.pact.provider.junit5.PactVerificationContext;
//import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
//import au.com.dius.pact.provider.junitsupport.Provider;
//import au.com.dius.pact.provider.junitsupport.State;
//import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.TestTemplate;
//import org.junit.jupiter.api.extension.ExtendWith;
//@Provider("oms-provider")
//@PactFolder("target/pacts")
//public class OmsProviderPactTest {
//    @BeforeEach
//    void before(PactVerificationContext context) {
//        context.setTarget(new HttpTestTarget("localhost", 8080));
//    }
//    @TestTemplate
//    @ExtendWith(PactVerificationInvocationContextProvider.class)
//    void verifyPact(PactVerificationContext context) {
//        context.verifyInteraction();
//    }
//    @State("Order exists")
//    public void orderExists() {
//        System.out.println("Order exists");
//    }
//    @State("inventory available for SKU-9")
//    public void inventoryAvailable() {
//        System.out.println("Inventory available for SKU-9");
//    }
//    @State("SKU-9 has stock")
//    public void skuHasStock() {
//        System.out.println("SKU-9 has stock");
//    }
//}

package pact;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("oms-provider")
@PactFolder("target/pacts")
public class OmsProviderPactTest {

    @BeforeEach
    void before(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", 8080));
    }
    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void verifyPact(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State("Food order exists")
    public void foodOrderExists()
    {
        System.out.println("Food order exists");
    }

    @State("Restaurant Pizza Hub is available")
    public void restaurantAvailable() {
        System.out.println("Restaurant Pizza Hub is available");
    }

    @State("Provider can create food orders")
    public void providerCanCreateFoodOrders()
    {
        System.out.println("Provider can create food orders");
    }
}
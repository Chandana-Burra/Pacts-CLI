//package pact;
//import au.com.dius.pact.provider.junit5.HttpTestTarget;
//import au.com.dius.pact.provider.junit5.PactVerificationContext;
//import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
//import au.com.dius.pact.provider.junitsupport.Provider;
//import au.com.dius.pact.provider.junitsupport.State;
//import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.TestTemplate;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//
//@Provider("oms-provider")
//@PactBroker(url = "http://localhost:9292")
//public class OmsProviderVerification {
//
//    @BeforeEach
//    void setup(PactVerificationContext context){
//        context.setTarget(new HttpTestTarget("localhost", 4010, "/"));
//    }
//
//    @TestTemplate
//    @ExtendWith(PactVerificationInvocationContextProvider.class)
//    void verify(PactVerificationContext context){
//        context.verifyInteraction();
//    }
//    @State("Order 123 exists")
//    void isOrderExists(){
//    }
//    @State("Sku-9 has stock")
//    void hasStock(){
//    }
//    @State("Provider can create orders")
//    void createOrder(){
//    }
//
//}
package pact;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("food-provider")
@PactBroker(url = "http://localhost:9292",
        enablePendingPacts = "true",
        providerTags = "main",
        includeWipPactsSince = "2026-06-26"

)

@PactFolder("target/pacts")
public class OmsProviderVerification {

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

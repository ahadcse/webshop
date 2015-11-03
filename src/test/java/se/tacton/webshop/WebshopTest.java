package se.tacton.webshop;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import se.tacton.webshop.exception.WebshopException;
import se.tacton.webshop.model.Cart;
import se.tacton.webshop.model.CustomerInfo;
import se.tacton.webshop.model.Organization;

public class WebshopTest extends TestCase {

    public WebshopTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(WebshopTest.class);
    }

    /**
     * Dummy Test
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testCustomerInfo() {

        Config config = Config.getInstance();
        try {
            CustomerInfo customerInfo = config.getCustomer("123");
            assertEquals(customerInfo.getCustomerId(), "123");
            assertEquals(customerInfo.getOrganization().getOrganization(), "Sub org 4");
            assertEquals(customerInfo.getName(), "MyCustomer");
            assertEquals(customerInfo.getAddress(), "Smart Street 1122");
        } catch (WebshopException e) {
            e.printStackTrace();
        }
    }

    public void testCartJson() {
        Config config = Config.getInstance();
        Cart cart = config.getCart();
        assertEquals(cart.getId(), "12345");
        assertEquals(cart.getCustomerId(), "123");
    }

    // test organization
    // test product
}

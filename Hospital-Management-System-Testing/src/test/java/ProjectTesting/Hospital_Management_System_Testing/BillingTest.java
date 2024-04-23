package ProjectTesting.Hospital_Management_System_Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BillingTest {

    private Billing billing;

    @BeforeEach
    public void setUp() {
        billing = new Billing();
    }

    @Test
    public void testAddInvoice() {
        Billing.Invoice invoice = new Billing.Invoice("John Doe", 100.0);
        billing.addInvoice(invoice);
        List<Billing.Invoice> invoices = billing.getInvoices();
        assertNotNull(invoices);
        assertEquals(1, invoices.size());
        assertEquals(invoice, invoices.get(0));
    }

    @Test
    public void testGenerateBillForPatient() {
        Billing.Invoice invoice1 = new Billing.Invoice("John Doe", 100.0);
        Billing.Invoice invoice2 = new Billing.Invoice("Jane Smith", 200.0);
        billing.addInvoice(invoice1);
        billing.addInvoice(invoice2);

        double billForJohn = billing.generateBillForPatient("John Doe");
        assertEquals(100.0, billForJohn, 0.01); // 0.01 tolerance for double comparison

        double billForJane = billing.generateBillForPatient("Jane Smith");
        assertEquals(200.0, billForJane, 0.01);
    }
}

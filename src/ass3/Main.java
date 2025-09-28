package ass3;

import java.math.BigDecimal;

public final class Main {
    public static void main(String[] args) {
        BankTransfer transfer = new SwiftAdapter(new LegacySwiftClient());
        try {
            String ref = transfer.transfer(
                    "KZ86125KZT123456789",
                    "DE02100100109307118603",
                    new BigDecimal("1250.50"),
                    "KZT",
                    "Invoice #2025-091"
            );
            System.out.println("OK ref=" + ref);
        } catch (RuntimeException e) {
            System.out.println("FAIL " + e.getMessage());
        }
    }
}

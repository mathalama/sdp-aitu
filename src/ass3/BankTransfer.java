package ass3;

import java.math.BigDecimal;

public interface BankTransfer {
    String transfer(String fromIban, String toIban, BigDecimal amount, String currency, String purpose);
}

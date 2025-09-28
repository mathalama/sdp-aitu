package ass3;

import java.math.BigDecimal;

/** Target: единый контракт для клиента. */
public interface BankTransfer {
    /** Возвращает референс перевода или бросает исключение при ошибке. */
    String transfer(String fromIban, String toIban, BigDecimal amount, String currency, String purpose);
}

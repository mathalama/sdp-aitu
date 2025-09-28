package ass3;

import java.math.BigDecimal;
import java.util.Locale;

public final class SwiftAdapter implements BankTransfer {
    private final LegacySwiftClient swift;

    public SwiftAdapter(LegacySwiftClient swift) {
        if (swift == null) throw new IllegalArgumentException("swift null");
        this.swift = swift;
    }

    @Override
    public String transfer(String fromIban, String toIban, BigDecimal amount, String currency, String purpose) {
        validate(fromIban, toIban, amount, currency);
        long minor = toMinorUnits(amount);
        String iso = currency.trim().toUpperCase(Locale.ROOT);
        String memo = purpose == null ? "" : purpose.trim();

        String raw = swift.send(fromIban, toIban, minor, iso, memo);
        if (raw == null || raw.isBlank()) throw new IllegalStateException("no_response");
        if (raw.startsWith("OK:")) return raw.substring(3);
        if (raw.startsWith("ERR:")) throw new IllegalStateException(raw.substring(4));
        throw new IllegalStateException("unknown_response");
    }

    private static void validate(String from, String to, BigDecimal amt, String ccy) {
        if (from == null || to == null || amt == null || ccy == null) {
            throw new IllegalArgumentException("null_argument");
        }
        if (amt.signum() <= 0) throw new IllegalArgumentException("amount_must_be_positive");
        if (amt.scale() > 2) throw new IllegalArgumentException("scale_gt_2");
        if (ccy.trim().length() != 3) throw new IllegalArgumentException("iso3_currency");
    }

    private static long toMinorUnits(BigDecimal amount) {
        return amount.movePointRight(2).longValueExact();
    }
}

package ass3;

import java.util.UUID;

public final class LegacySwiftClient {
    public String send(String from, String to, long minor, String ccy, String purpose) {
        if (from == null || to == null || ccy == null) return "ERR:null_param";
        if (minor <= 0) return "ERR:non_positive_amount";
        if (ccy.length() != 3) return "ERR:bad_currency";
        if (from.equals(to)) return "ERR:same_account";
        return "OK:" + UUID.randomUUID();
    }
}

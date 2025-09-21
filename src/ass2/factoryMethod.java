package ass2;

interface Transaction {
    void execute();
}

final class Deposit implements Transaction {
    public void execute() { System.out.println("Deposit money"); }
}

final class Withdrawal implements Transaction {
    public void execute() { System.out.println("Withdraw money"); }
}

final class TransactionFactory {
    static Transaction create(String type) {
        return switch (type) {
            case "deposit" -> new Deposit();
            case "withdrawal" -> new Withdrawal();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}

public class factoryMethod {
    public static void main(String[] args) {
        Transaction t1 = TransactionFactory.create("deposit");
        Transaction t2 = TransactionFactory.create("withdrawal");
        t1.execute();
        t2.execute();
    }
}
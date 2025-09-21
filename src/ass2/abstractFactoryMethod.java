package ass2;

interface Account { void info(); }
interface Card    { void info(); }

final class RetailAccount implements Account { public void info(){ System.out.println("Retail Account"); } }
final class RetailCard    implements Card    { public void info(){ System.out.println("Retail Debit Card"); } }
final class DigitalAccount implements Account{ public void info(){ System.out.println("Digital Account"); } }
final class DigitalCard   implements Card    { public void info(){ System.out.println("Virtual Card"); } }

interface BankFactory {
    Account createAccount();
    Card createCard();
}

final class RetailBankFactory implements BankFactory {
    public Account createAccount() { return new RetailAccount(); }
    public Card createCard()       { return new RetailCard(); }
}

final class DigitalBankFactory implements BankFactory {
    public Account createAccount() { return new DigitalAccount(); }
    public Card createCard()       { return new DigitalCard(); }
}

public class abstractFactoryMethod {
    public static void main(String[] args) {
        BankFactory retail = new RetailBankFactory();
        retail.createAccount().info();
        retail.createCard().info();

        BankFactory digital = new DigitalBankFactory();
        digital.createAccount().info();
        digital.createCard().info();
    }
}

package Lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

class Card
{
    private final int Id;
    private final LocalDate expireDate;

    Card(int id, LocalDate expireDate) {
        Id = id;
        this.expireDate = expireDate;
    }

    public int getId() {
        return Id;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "Id=" + Id +
                ", expireDate=" + expireDate +
                '}';
    }

    public boolean GoingExpired()
    {
        return expireDate.minusDays(7).isBefore(LocalDate.now());
    }


}

class Account
{
    private final int accountID;
    private final String customerName;
    private final String customerMainNumber;

    private final LinkedList<Card> cards = new LinkedList<>();

    Account(int accountID, String customerName, String customerMainNumber, Card card)
    {
        this.accountID = accountID;
        this.customerName = customerName;
        this.customerMainNumber = customerMainNumber;
        cards.add(card);
    }

    public int getAccountID() {
        return accountID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID=" + accountID +
                ", customerName='" + customerName + '\'' +
                ", customerMainNumber='" + customerMainNumber + '\'' +
                ", cards=" + cards +
                '}';
    }

    public void PrintExpiredCardInfo()
    {
        cards.stream().filter(Card::GoingExpired).forEach(i -> System.out.println("AccountID:" + accountID + " Holder Name:" + customerName + "'s CardID:" + i.getId() + " Expire Date:" + i.getExpireDate() + " is due within 7 days"));

    }


}

class Bank
{
    private final ArrayList<Account> customerAccounts = new ArrayList<>();
    // not at good ideas as bank assign expired date card


    // some cheat way make sure unique id
    private int accId = 0;
    private int cardId = 0;


    public void AddCustomerAccount(String name, String mobileNumber)
    {
        int no1 = (int) (Math.random() * ((2 + 1) + 1));
        int no2 = (int) (Math.random() * ((14 + 1) + 1));
        LocalDate dateTime =  LocalDate.now();
        if(no1 == 0)
        {
            dateTime = dateTime.minusDays(no2);
        }
        else
        {
            dateTime = dateTime.plusDays(no2);
        }
        ++cardId;
        Card card = new Card(cardId,dateTime);
        ++accId;
        customerAccounts.add(new Account(accId,name,mobileNumber,card));
        System.out.println(name + " has assigned AccountID:" + accId + " with CardID:" + cardId + " with expire date:" + dateTime);
    }

    public void GetExpiredCardInfoAndCustomerInfo()
    {
        for (Account customerAccount : customerAccounts) {
            customerAccount.PrintExpiredCardInfo();

        }
    }

    public Card NewGenerateCard(Card o)
    {
        ++cardId;
        LocalDate date = LocalDate.now().plusDays(14);
        System.out.println("Replace CardID:" + o.getId() + " Expire Date:" + o.getExpireDate() + " with CardID:" + cardId + " Expire Date:" + date);
        return new Card(cardId,date);
    }

    public void UpdateAllExpiredCard()
    {
        customerAccounts.forEach(i -> {i.getCards().replaceAll(o -> o.GoingExpired() ? NewGenerateCard(o) : o);});
    }

    public void PrintAllInfo()
    {
        for (Account account : customerAccounts) {
            System.out.println("AccountID:" + account.getAccountID() + " Holder Name:" + account.getCustomerName());
            LinkedList<Card> cards = account.getCards();
            cards.forEach(i -> System.out.println("CardID:" + i.getId() + " Expire Date:" + i.getExpireDate()) );
            System.out.println();
        }
    }



}

public class Lab9Q1 {
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        bank.AddCustomerAccount("Clarence Ng","+65 8845 4484");
        bank.AddCustomerAccount("Ng Min Teck","+65 8756 8759");
        bank.AddCustomerAccount("abc","999");
        bank.AddCustomerAccount("xyz","911");
        System.out.println();
        System.out.println("Check Expired Card");
        bank.GetExpiredCardInfoAndCustomerInfo();
        System.out.println();
        System.out.println("Auto update expired card to new card.");
        bank.UpdateAllExpiredCard();
        System.out.println();
        System.out.println("Print all customer account information.");
        bank.PrintAllInfo();




    }
}

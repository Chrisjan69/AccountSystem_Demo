package za.ac.nwu.ac.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT_TX_DETAILS")
public class AccountTransactionDetails implements Serializable {
    private static final long serialVersionUID = 8761172199210785733L;
    long accountTransactionDetailsId;
    String partnerName;
    AccountTransaction accountTransaction;
    long numberOfItems;

    @Id
    @SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "SCHEMA.ACCOUNT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
    @Column(name = "ACCOUNT_TX_DETAILS")
    public long getAccountTransactionDetailsId(){return accountTransactionDetailsId;}

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TX_ID")
    public AccountTransaction getAccountTransaction(){return accountTransaction;}

    @Column(name = "PARTNER_NAME")
    public String getPartnerName(){return partnerName;}

    @Column(name = "NUMBER_OF_ITEMS")
    public long getNumberOfItems(){return numberOfItems;}

    public AccountTransactionDetails(String partnerName, Long numberOfItems)
    {

    }

    public AccountTransactionDetails(AccountTransaction accountTransaction, String partnerName, long numberOfItems){
        this.accountTransaction = accountTransaction;
        this.partnerName= partnerName;
        this.numberOfItems = numberOfItems;
    }



}

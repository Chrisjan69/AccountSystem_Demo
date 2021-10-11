package za.ac.nwu.ac.domain.persistance;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TX", schema = "hr")
public class AccountTransaction implements Serializable
{
    private static final long serialVersionUID = 2097561612357595217L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
    @SequenceGenerator(name = "GEN_SEQ", sequenceName = "RSA_SEQ", allocationSize = 1)

    @Column(name = "ACCOUNT_TX_ID", nullable = false)
    private long accountTransactionId;

    @Column(name ="ACCOUNT_TYPE_ID")
    private AccountType accountType;

    @Column(name = "MEMBER_ID")
    private long memberId;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name ="TX_DATE")
    private long txDate;
    private LocalDate transactionDate;
    private Object transactionId;


    public AccountTransaction(long transactionId, AccountType accountType, long memberId, long amount, LocalDate transactionDate) {
    }

    public AccountTransaction(Long accountTransactionId,AccountType accountType, long memberId, long amount, long txDate) {
        this.accountTransactionId = accountTransactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }

    public Long getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(Long accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType()
    {
        return accountType;
    }

    public void setAccountType() {
        this.accountType = accountType;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTxDate() {
        return txDate;
    }

    public void setTxDate(long txDate) {
        this.txDate = txDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return accountTransactionId == that.accountTransactionId && memberId == that.memberId && amount == that.amount && txDate == that.txDate && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionId, accountType, memberId, amount, txDate);
    }

    @Override
    public String toString() {

        return "AccountTransaction{" +
                "accountTransactionId=" + accountTransactionId +
                ", accountTypeId=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", txDate=" + txDate +
                '}';
    }
    @OneToOne(targetEntity = AccountTransactionDetails.class, fetch = FetchType.LAZY, mappedBy = "accountTransaction")
    public AccountTransactionDetails getDetails()
    {
        AccountTransactionDetails details = null;
        return details;
    }

    public void setMemberId(Long memberId){this.memberId = memberId;}
    public void setAmount(Long Amount){this.amount = amount;}
    public void setTransactionDate(LocalDate transactionDate){this.transactionDate = transactionDate;}
    public void setAccountType(AccountType accountType){this.accountType = accountType; }



}

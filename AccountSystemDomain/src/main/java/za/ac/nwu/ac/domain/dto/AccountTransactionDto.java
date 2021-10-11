package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistance.AccountTransaction;
import za.ac.nwu.ac.domain.persistance.AccountTransactionDetails;
import za.ac.nwu.ac.domain.persistance.AccountType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TX")
public class AccountTransactionDto implements Serializable {
    private static final long serialVersionUID = -2541136876395043938L;
    private long transactionId;
    @ManyToOne
    @JoinColumn(name = "account_type_account_type_id")
    private AccountType accountType;
    private long memberId;
    private long amount;
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "details_account_tx_details")
    private AccountTransactionDetails details;

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return transactionId == that.transactionId && memberId == that.memberId && amount == that.amount && Objects.equals(accountType, that.accountType) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate, details);
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getMemberId() {
        return memberId;
    }

    public long getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public AccountTransactionDetails getDetails() {
        return details;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public AccountTransactionDto(long transactionId) {
        this.transactionId = transactionId;
    }

    public AccountTransactionDto(AccountTransactionDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", details=" + details +
                '}';
    }
    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType){
        return new AccountTransaction(this.getTransactionId(), accountType,this.getMemberId(),
                this.getAmount(),this.getTransactionDate());
    }
}

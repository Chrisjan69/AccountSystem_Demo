package za.ac.nwu.ac.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "hr")

public class AccountType implements Serializable
{
    private static final long serialVersionUID = -2555373995821359120L;
    private Set<AccountTransaction> accountTransactions;
    @Id
    @SequenceGenerator(name = "GEN_SEQ", sequenceName = "GEN_RSA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID", nullable = false)
    private Long accountTypeId;

    @Column(name = "MNEMONIC")
    private String mnemonic;

    @Column(name = "ACCOUNT_TYPE_NAME")
    private String AccountTypeName;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY,mappedBy = "accountType",orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions()
    {
        return accountTransactions;
    }
    public void setAccountTransactions(Set<AccountTransaction> accountTransactions)
    {
        this.accountTransactions = accountTransactions;
    }
    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.AccountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }
    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate)
    {

    }
    public Long getAccountTypeId() {
        return accountTypeId;
    }
    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
    public String getMnemonic() {
        return mnemonic;
    }
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    public String getAccountTypeName() {
        return AccountTypeName;
    }
    public void setAccountTypeName(String accountTypeName) {
        AccountTypeName = accountTypeName;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(AccountTypeName, that.AccountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, AccountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", AccountTypeName='" + AccountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

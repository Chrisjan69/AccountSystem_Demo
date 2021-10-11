package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistance.AccountTransaction;
import za.ac.nwu.ac.domain.persistance.AccountTransactionDetails;

import java.util.Objects;

public class AccountTransactionDetailsDto {
    String partnerName;
    Long numberOfItems;

    public AccountTransactionDetailsDto() {
    }

    public AccountTransactionDetailsDto(String partnerName, Long numberOfItems) {
        this.partnerName = partnerName;
        this.numberOfItems = numberOfItems;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public Long getNumberOfItems() {
        return numberOfItems;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDetailsDto that = (AccountTransactionDetailsDto) o;
        return Objects.equals(partnerName, that.partnerName) && Objects.equals(numberOfItems, that.numberOfItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerName, numberOfItems);
    }

    @Override
    public String toString() {
        return "AccountTransactionDetailsDto{" +
                "partnerName='" + partnerName + '\'' +
                ", numberOfItems=" + numberOfItems +
                '}';
    }
    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(AccountTransaction accountTransaction)
    {
        return new AccountTransactionDetails(accountTransaction, this.partnerName, this.numberOfItems);
    }
    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(){
        return new AccountTransactionDetails(this.partnerName, this.numberOfItems);
    }
}

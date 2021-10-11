package za.ac.nwu.ac.repo.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistance.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "ACCOUNT_TYPE_ID," +
            "ACCOUNT_TYPE_NAME," +
            "CREATION_DATE," +
            "MNEMONIC " +
            "FROM" +
            "ACCOUNT_SYSTEM " +
            "WHERE MNEMONIC = :mnemonic ",nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

   @Query(value = "SELECT, " +
           "at" +
           "FROM " +
           "AccountType at " +
           "WHERE at.mnemonic = :mnemonic" )
    AccountType getAccountTypeMyMnemonic(String mnemonic);

   @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto(" +
           "at.mnemonic," +
           "at.accountTypeName," +
           "at.creationDate)" +
           "FROM" +
           "accountType at" +
           "WHERE at.mnemonic = :mnemonic")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


    AccountType getAccountTypesByMnemonic(String mnemonic);
}
package za.ac.nwu.ac.logic.flow.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Component
public class ModifyAccountTypeFlowImpl  implements ModifyAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;


    @Autowired
    public ModifyAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        return null;
    }

    @Override
    public AccountTypeDto getAllAccountTypesByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public Object deleteAccountType(String anyString) {
        return null;
    }

    @Override
    public Object updateAccountType(String anyString, String anyString1, LocalDate any) {
        return null;
    }
}

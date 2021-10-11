package za.ac.nwu.ac.logic.flow.impl;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Component("CreateAccountTypeFlowName")
public class CreateAccountTypeFLowImpl implements CreateAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFLowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator=accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        return null;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType)
    {
        if(null == accountType.getCreationDate())
        {
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}

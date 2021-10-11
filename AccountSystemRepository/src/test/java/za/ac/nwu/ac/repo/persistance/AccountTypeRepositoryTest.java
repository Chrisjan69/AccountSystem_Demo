package za.ac.nwu.ac.repo.persistance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import za.ac.nwu.ac.domain.persistance.AccountType;
import za.ac.nwu.ac.repo.config.RepositoryTestConfig;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})


public class AccountTypeRepositoryTest {
    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Before
    public void setUp() throws Exception{

    }
    @After
    public void tearDown() throws Exception{
    }
    @Test
    public void getAccountTypeByMnemonicNativeQueryMiles(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("Miles");
        assertNotNull(miles);
        assertEquals("Miles", miles.getMnemonic());


    }
    @Test
    public void getAccountTypeByMnemonicNativeQuery(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("miles");
        assertNotNull(miles);
        assertEquals("Miles", miles.getMnemonic());
    }




}

package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFLowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeFLowImpl flow;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        when(translator.create(any(AccountTypeDto.class))).thenReturn(null);
       AccountTypeDto result= flow.create(new AccountTypeDto());
       assertNull(result);
       verify(translator).create(any(AccountTypeDto.class));

    }
}
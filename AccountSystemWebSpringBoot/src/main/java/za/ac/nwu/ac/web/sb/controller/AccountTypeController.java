package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistance.AccountType;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController
{
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
    private final ModifyAccountTypeFLow modifyAccountTypeFLow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                 @Qualifier("createAccountTypeFlowName")CreateAccountTypeFlow createAccountTypeFlow,
                                 ModifyAccountTypeFLow modifyAccountTypeFLow)
    {
        this.createAccountTypeFlow = createAccountTypeFlow;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.modifyAccountTypeFLow =modifyAccountTypeFLow;

    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200,message = "Account types returned", response = GeneralResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                    @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
                    @ApiResponse(code = 500,message = "Internal server error", response = GeneralResponse.class)

            })

    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll()
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates new AccountType ins the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "the account was created successfully",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500,message ="Internal server error" )})
    public ResponseEntity<GeneralResponse<AccountTypeDto>>create(
            @ApiParam(value = "request body to create new accountType",required = true)
            @RequestBody AccountTypeDto accountType){
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Deletes the specified account",notes = "Deletes account type corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Type Deleted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class),

    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> deleteAccountType(
            @ApiParam(value = "the mnemonic that uniquely identifies the accountType",
            example = "Miles",
            name = "mnemonic",
            required = true)
            @PathVariable("mnemonic") final String mnemonic){

        AccountTypeDto accountType = modifyAccountTypeFLow.deleteAccountType(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("{mnemonic}")
    @ApiOperation(value = "Updates the specified accountType",notes = "Updates account type corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Type Updated"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class),

    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> updateAccountType(
            @ApiParam(value ="the mnemonic that uniquely identifies the accountType",
            example = "MILES",
            name = "miles",
            required = true)
            @PathVariable("mnemonic") final String mnemonic,

            @ApiParam(value = "The new accountTypeName that the specified AccountType should be updated with.",
            name = "newAccountTypeName",
            required = true)

            @RequestParam("newAccountTypeName") final String newAccountTypeName,
            @ApiParam(value = "The optional new date with which to update the CreationDate in ISO date format (yyyy-MM-dd)",
            name = "newCreationDate")
            @RequestParam(value = "newCreationDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate newCreationDate

    ){
        AccountTypeDto accountType = modifyAccountTypeFLow.updateAccountTypeFlow(mnemonic, newAccountTypeName,newCreationDate);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }




    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetches the specific Account type.",notes = "Fetches account type corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "goal found"),
            @ApiResponse(code= 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Request not found",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error",response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic){
        AccountTypeDto accountType = fetchAccountTypeFlow.getAllAccountTypesByMnemonic(mnemonic);

        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }











}

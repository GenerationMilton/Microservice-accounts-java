package com.livemilton.accounts.service.impl;

import com.livemilton.accounts.constants.AccountsConstants;
import com.livemilton.accounts.dto.CustomerDto;
import com.livemilton.accounts.entity.Accounts;
import com.livemilton.accounts.entity.Customer;
import com.livemilton.accounts.exception.CustomerAlreadyExistsException;
import com.livemilton.accounts.mapper.CustomerMapper;
import com.livemilton.accounts.repository.AccountsRepository;
import com.livemilton.accounts.repository.CustomerRepository;
import com.livemilton.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;


    /**
     *
     * @param customerDto - CustomerDto Object
     *
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        //Inside this method we need to write the logic to create a new account.
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "+customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer= customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }

    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber= 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}

package com.livemilton.accounts.service.impl;

import com.livemilton.accounts.dto.CustomerDto;
import com.livemilton.accounts.repository.AccountsRepository;
import com.livemilton.accounts.repository.CustomerRepository;
import com.livemilton.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


    }
}

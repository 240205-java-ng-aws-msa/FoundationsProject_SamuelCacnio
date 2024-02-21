package dev.cacnio.RevECom.service;

import dev.cacnio.RevECom.entity.Account;
import dev.cacnio.RevECom.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    AccountRepository accountRepository;
    @Autowired
    public  AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Boolean emailMatch(String email){
        return accountRepository.findByEmail(email)!=null;
    }

    public Account registerAccount(Account account){
        return accountRepository.save(account);
    }

    public Account login(Account account){
        return accountRepository.findByEmailAndPassword(account.getEmail(), account.getPassword());
    }
}

package intern.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import intern.project.entity.Account;
import intern.project.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository accRepo;
    @Autowired
    PasswordEncoder encoder;
    public void add_users(Account acc){
        acc.setPassword(encoder.encode(acc.getPassword()));
        accRepo.save(acc);
    }
    public void delete_users(int id){
        Account acc=accRepo.findById(id).get();
        if(acc!=null&&acc.getRole().equals("ADMIN")==false)
            accRepo.deleteById(id);
    }
    public void changeRoles(String roles,int id){
        Account acc=accRepo.findById(id).get();
        if(acc!=null&&acc.getRole().equals("ADMIN")==false){
            acc.setRole(roles);
            accRepo.save(acc);
        }
    }
}

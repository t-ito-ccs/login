package ccs.education.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ccs.education.login.LoginUser;
import ccs.education.login.repository.AccountRepository;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //ユーザの情報を取得し、認証処理に渡すためにUserクラスを継承したデータに入れて返却
        return  new LoginUser(repository.findById(username));
    }
}
package ccs.education.login;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ccs.education.login.entity.Account;

public class LoginUser extends User {

    private Account account;

	// Account情報をDTOクラスに設定する、今回のデモではすべてユーザ権限とする
    public LoginUser(Account account) {
        super(account.getId(), account.getPassword(), AuthorityUtils.createAuthorityList("USER"));
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}

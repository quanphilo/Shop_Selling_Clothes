package BLL;

import java.util.Vector;

import DAL.AccountDAL;
import DTO.AccountDTO;

public class AccountBLL {
    AccountDAL accountDAL = new AccountDAL();
    
    public Vector<AccountDTO> getAccounts() {
        Vector<AccountDTO> listAccount = accountDAL.getAccounts();
        return listAccount;
    }

    public AccountDTO getAccountById(String id_account) {
        AccountDTO accountDTO = accountDAL.getAccountById(id_account);
        return accountDTO;
    }

    public AccountDTO login(AccountDTO account, String position) {
        return accountDAL.login(account, position);
    }

    public int insert(AccountDTO account) {
        int kq = accountDAL.insert(account);
        return kq;
    }
    
    public int update(AccountDTO account) {
        int kq = accountDAL.update(account);
        return kq;
    }

    public int suspend(AccountDTO account) {
        int kq = accountDAL.suspend(account);
        return kq;
    }

    public int active(AccountDTO account) {
        int kq = accountDAL.active(account);
        return kq;
    }
}

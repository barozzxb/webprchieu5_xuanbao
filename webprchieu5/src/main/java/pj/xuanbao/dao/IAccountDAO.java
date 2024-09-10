package pj.xuanbao.dao;

import java.util.List;

import pj.xuanbao.models.AccountModel;

public interface IAccountDAO {

	List<AccountModel> findAll();
	AccountModel findByUsername(String username);
	void insert(AccountModel user);
}

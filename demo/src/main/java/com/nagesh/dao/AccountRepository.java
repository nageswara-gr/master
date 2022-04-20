package com.nagesh.dao;
import com.nagesh.model.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountInfo, Long> {
    AccountInfo save(AccountInfo accountInfo);
}
package dev.cacnio.RevECom.repository;

import dev.cacnio.RevECom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("FROM Account WHERE email = :email")
    Account findByEmail(@Param("email") String email);

    @Query("FROM Account WHERE email = :email AND password = :password")
    Account findByEmailAndPassword(@Param("email") String username, @Param("password") String password);
}

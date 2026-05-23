package com.homeacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    @Query(value = "select * from transactions WHERE user_login = :user_login", nativeQuery = true)
    List<Transactions> findALLByUserLogin(@Param("user_login") String user_login);
}

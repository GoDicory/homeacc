package com.homeacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatSabRepository extends JpaRepository<CatSab,Long> {
    @Query(value = "select * from cat_sab_block WHERE user_login = :user_login", nativeQuery = true)
    List<CatSab> findAllByUserLogin(@Param("user_login") String user_login);
}

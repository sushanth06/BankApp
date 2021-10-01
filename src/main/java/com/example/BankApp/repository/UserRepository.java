package com.example.BankApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.BankApp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByAccountIDEquals(Long accountID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE User c SET c.initialAmt = :initialAmt WHERE c.accountID = :accountID")
	public void updateUser(@Param("accountID") long accountID, @Param("initialAmt") int initialAmt);

}

package com.example.bank.repository;

import com.example.bank.model.UsersDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 10:22 PM
 */
@Repository
public interface UsersDetailsRepository extends CrudRepository<UsersDetails, Long> {

    List<UsersDetails> findByEmail(String email);
}

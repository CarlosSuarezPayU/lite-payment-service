package com.senior.test.litepaymentservice.usecase.share;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

}

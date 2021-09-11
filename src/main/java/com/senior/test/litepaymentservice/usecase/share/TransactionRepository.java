package com.senior.test.litepaymentservice.usecase.share;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.senior.test.litepaymentservice.share.model.repository.Transaction;

/**
 * Transaction repository.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

}

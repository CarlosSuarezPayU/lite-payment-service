package com.senior.test.litepaymentservice.usecase.share;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.senior.test.litepaymentservice.share.model.repository.PaymentOrder;

/**
 * Payment Order Repository.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Repository
public interface PaymentOrderRepository extends CrudRepository<PaymentOrder, Integer> {

}

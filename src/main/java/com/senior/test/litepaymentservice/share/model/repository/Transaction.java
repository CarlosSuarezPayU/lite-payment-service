package com.senior.test.litepaymentservice.share.model.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import com.senior.test.litepaymentservice.share.model.CountryCurrency;
import com.senior.test.litepaymentservice.share.model.TransactionState;
import com.senior.test.litepaymentservice.share.model.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(setterPrefix = "with")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private TransactionType transactionType;

	@NotNull
	private BigDecimal amount;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private TransactionState state;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private CountryCurrency currencyValue;

	@CreationTimestamp
	private Timestamp creationDate;

	@UpdateTimestamp
	private Timestamp lastUpdateDate;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "PAYMENT_ORDER_ID", referencedColumnName = "ID")
	private PaymentOrder paymentOrder;

	private String message;

	private String antiFraudResponse;

	private String networkResponse;

	private String networkCodeResponse;

}

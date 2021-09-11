package com.senior.test.litepaymentservice.share.model.repository;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
public class PaymentOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JoinColumn(name= "payer_id", referencedColumnName = "id")
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Payer payer;

	@JoinColumn(name= "card_id", referencedColumnName = "id")
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private CreditCard card;

	@CreationTimestamp
	private Timestamp creationDate;

	@UpdateTimestamp
	private Timestamp lastUpdateDate;

}

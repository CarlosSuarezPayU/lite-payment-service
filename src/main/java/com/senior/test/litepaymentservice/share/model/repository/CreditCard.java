package com.senior.test.litepaymentservice.share.model.repository;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import com.senior.test.litepaymentservice.share.model.FranchiseCard;
import com.sun.istack.NotNull;
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
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 6577677421557551545L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;

	@NotNull
	@Size(min = 14, max = 19)
	private String panNumber;

	@Transient
	private String cvv2;

	@Transient
	private String expirationDate;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private FranchiseCard franchiseCard;

}

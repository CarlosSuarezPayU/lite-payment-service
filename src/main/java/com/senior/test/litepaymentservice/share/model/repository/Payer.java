package com.senior.test.litepaymentservice.share.model.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import com.senior.test.litepaymentservice.share.model.IdentificationType;
import javax.validation.constraints.NotNull;
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
public class Payer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String fullName;

	@NotNull
	private String identification;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private IdentificationType identificationType;

	@NotNull
	private String email;

	@NotNull
	private String address;

	@NotNull
	private String phone;

}

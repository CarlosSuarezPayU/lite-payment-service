package com.senior.test.litepaymentservice.share.model.repository;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.senior.test.litepaymentservice.share.model.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Payer entity structure.
 *
 * @author <a href='carlos.suarez@payu.com'>Carlos Eduardo Suárez Silvestre</a>
 */
@Builder(setterPrefix = "with")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payer implements Serializable {

	private static final long serialVersionUID = 7698925081452073403L;

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

package br.com.transfinder.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Embeddable
@Data
@EqualsAndHashCode
@ToString
public class Address {

	@Column(name = "cep")
	private String postalCode;

	@Column(name = "cidade")
	private String city;

	@Column(name = "bairro")
	private String neighborhood;

	@Column(name = "rua")
	private String street;

	@Column(name = "numero")
	private String number;

	@Column(name = "complemento")
	private String complement;
}

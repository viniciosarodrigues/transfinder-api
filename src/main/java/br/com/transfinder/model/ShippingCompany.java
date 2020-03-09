package br.com.transfinder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.transfinder.model.enums.ModalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "TRANSPORTADORA")
@Data
@EqualsAndHashCode
@ToString
public class ShippingCompany implements Serializable {

	private static final long serialVersionUID = -2928666651629148613L;

	private Long id;

	private String email;

	@Column(name = "nome")
	private String name;

	private String cnpj;

	@Column(name = "telefone")
	private String phone;

	@Column(name = "celular")
	private String cellphone;

	@Column(name = "modal")
	@Enumerated(EnumType.STRING)
	private ModalType modalType;

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

	@Column(name = "url_logo")
	private String urlLogo;
}

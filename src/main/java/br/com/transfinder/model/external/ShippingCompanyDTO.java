package br.com.transfinder.model.external;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Entidade reduzida para listagem da tela principal
 */
@Data
@EqualsAndHashCode
@ToString
public class ShippingCompanyDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String logo;

	private String name;

	private String cnpj;

	private String number;

	private String cellphone;

	private String email;

}

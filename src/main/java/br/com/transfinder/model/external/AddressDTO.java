package br.com.transfinder.model.external;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = -8716181852382219648L;

	@NotNull(message = "O CEP é obrigatório")
	private String postalCode;

	@NotNull(message = "Informe a Unidade Federativa")
	private String uf;

	@NotNull(message = "A cidade é obrigatória")
	private String city;

	@NotNull(message = "O bairro é obrigatório")
	private String neighborhood;

	@NotNull(message = "A rua/avenida é obrigatória")
	private String street;

	@NotNull(message = "O número do endereço é obrigatório")
	private String number;

	@Size(min = 3, message = "Informe ao menos 3 (três) caracteres para um complemento válido ou não informe nada.")
	private String complement;
}
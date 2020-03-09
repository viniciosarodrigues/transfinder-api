package br.com.transfinder.model.external;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.transfinder.model.enums.ModalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * DTO para comunicação com o Client Angular
 * 
 * @author viniciosarodrigues
 *
 */
@Data
@EqualsAndHashCode
@ToString
public class ShippingCompanyDetailsDTO implements Serializable {
	private static final long serialVersionUID = 3629489711254780982L;

	private Long id;

	@NotNull(message = "O e-mail é obrigatório")
	private String email;

	@NotNull(message = "O nome é obrigatório")
	private String name;

	@CNPJ(message = "Informe um CNPJ válido")
	@NotNull(message = "O CNPJ é obrigatório")
	private String cnpj;

	@NotNull(message = "O telefone é obrigatório")
	private String phone;

	@NotNull(message = "O celularf é obrigatório")
	private String cellphone;

	@NotNull(message = "O modal é obrigatório")
	private ModalType modalType;

	@NotNull(message = "O endereço é obrigatório")
	private AddressDTO address;

	private String urlLogo;
}

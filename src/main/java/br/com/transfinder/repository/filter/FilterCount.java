package br.com.transfinder.repository.filter;

import java.io.Serializable;

import br.com.transfinder.model.enums.ModalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterCount implements Serializable {

	private static final long serialVersionUID = -8647081556065535139L;

	private String type;

	private Long count;

	private String description;

	public FilterCount(String type, Long count, ModalType modal) {
		this.type = type;
		this.count = count;
		this.description = modal.name();
	}

}

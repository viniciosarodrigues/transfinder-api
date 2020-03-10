package br.com.transfinder.repository.filter;

import java.io.Serializable;

import br.com.transfinder.model.enums.ModalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class FilterObject implements Serializable {
	private static final long serialVersionUID = -7571845680560006629L;

	private String name;

	private String uf;

	private String city;

	private ModalType modalType;
}

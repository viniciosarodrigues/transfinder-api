package br.com.transfinder.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.transfinder.model.external.ShippingCompanyDTO;
import br.com.transfinder.repository.filter.FilterObject;

/**
 * Interface com busca filtrada e paginada
 * 
 * @author viniciosarodrigues
 *
 */
public interface ShippingCompanyQuery {

	public Page<ShippingCompanyDTO> resume(FilterObject filter, Pageable pageable);

}

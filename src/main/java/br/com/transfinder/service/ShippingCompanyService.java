package br.com.transfinder.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.transfinder.exception.ObjectNotFoundException;
import br.com.transfinder.model.ShippingCompany;
import br.com.transfinder.model.external.AddressDTO;
import br.com.transfinder.model.external.ShippingCompanyDTO;
import br.com.transfinder.model.external.ShippingCompanyDetailsDTO;
import br.com.transfinder.repository.ShippingCompanyRepository;
import br.com.transfinder.repository.filter.FilterRequest;

/**
 * Camada de serviços.Regras da aplicação, conversões e especificidades devem
 * ser implementadas nesta classe.
 * 
 * @author viniciosarodrigues
 *
 */
@Service
public class ShippingCompanyService {

	@Autowired
	private ShippingCompanyRepository repository;

	/**
	 * Busca a transportadora com informações detalhadas
	 * 
	 * @param id
	 * @return
	 */
	public ShippingCompanyDetailsDTO findById(Long id) {
		ShippingCompany companyFromDb = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Transportadora", id));

		ShippingCompanyDetailsDTO responseDto = convertDomainToDTO(companyFromDb);

		return responseDto;
	}

	public Page<ShippingCompanyDTO> getFilteredList(FilterRequest filter, Pageable pageable) {
		return repository.resume(filter, pageable);
	}

	/**
	 * Converte o objeto completo do banco, para um objeto de resposta (DTO)
	 * 
	 * @param companyFromDb
	 * @return
	 */
	private ShippingCompanyDetailsDTO convertDomainToDTO(ShippingCompany companyFromDb) {
		ShippingCompanyDetailsDTO convertedObject = new ShippingCompanyDetailsDTO();

		BeanUtils.copyProperties(companyFromDb, convertedObject);

		AddressDTO addressDTO = new AddressDTO();

		BeanUtils.copyProperties(companyFromDb, addressDTO);

		convertedObject.setAddress(addressDTO);

		return convertedObject;
	}
}

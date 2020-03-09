package br.com.transfinder.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.transfinder.exception.ObjectNotFoundException;
import br.com.transfinder.model.ShippingCompany;
import br.com.transfinder.model.external.AddressDTO;
import br.com.transfinder.model.external.ShippingCompanyDetailsDTO;
import br.com.transfinder.repository.ShippingCompanyRepository;

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
	private ShippingCompanyDetailsDTO findById(Long id) {
		ShippingCompany companyFromDb = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Transportadora", id));

		ShippingCompanyDetailsDTO responseDto = convertDomainToDTO(companyFromDb);

		return responseDto;
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

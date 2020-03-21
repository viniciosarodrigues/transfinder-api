package br.com.transfinder.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.transfinder.exception.ObjectNotFoundException;
import br.com.transfinder.model.ShippingCompany;
import br.com.transfinder.model.external.AddressDTO;
import br.com.transfinder.model.external.FilterCountDTO;
import br.com.transfinder.model.external.ShippingCompanyDTO;
import br.com.transfinder.model.external.ShippingCompanyDetailsDTO;
import br.com.transfinder.repository.ShippingCompanyQuery;
import br.com.transfinder.repository.ShippingCompanyRepository;
import br.com.transfinder.repository.filter.FilterCount;
import br.com.transfinder.repository.filter.FilterObject;

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

	@Autowired
	private ShippingCompanyQuery customRepository;

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

	public Page<ShippingCompanyDTO> getFilteredList(FilterObject filter, Pageable pageable) {
		return customRepository.getPageFromFilter(filter, pageable);
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

	/**
	 * Realiza a atualização das informações da Transportadora
	 * 
	 * @param id
	 * @param requestObject
	 * @return
	 */
	public ShippingCompanyDetailsDTO updateOrCreate(Long id, @Valid ShippingCompanyDetailsDTO requestObject,
			Boolean isNew) {
		if (!isNew)
			repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Transportadora", id));

		ShippingCompany updatedShippingCompany = new ShippingCompany();

		BeanUtils.copyProperties(requestObject, updatedShippingCompany);
		BeanUtils.copyProperties(requestObject.getAddress(), updatedShippingCompany);
		updatedShippingCompany.setId(id);
		if (isNew)
			updatedShippingCompany.setId(null);
		repository.save(updatedShippingCompany);
		requestObject.setId(updatedShippingCompany.getId());

		return requestObject;
	}

	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);

	}

	/**
	 * Realiza a busca agrupada de filtros
	 * 
	 * @return
	 */
	public FilterCountDTO getFilterCount() {
		List<List<FilterCount>> filterCount = new ArrayList<>();

		filterCount.add(repository.getUFCount());
		filterCount.add(repository.getCityCount());
		filterCount.add(repository.getModalCount());

		return new FilterCountDTO(filterCount);
	}
}

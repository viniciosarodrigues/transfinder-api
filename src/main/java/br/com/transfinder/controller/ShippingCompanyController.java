package br.com.transfinder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transfinder.model.external.FilterCount;
import br.com.transfinder.model.external.ShippingCompanyDTO;
import br.com.transfinder.model.external.ShippingCompanyDetailsDTO;
import br.com.transfinder.repository.filter.FilterObject;
import br.com.transfinder.service.ShippingCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Endpoint - Transportadoras")
@RestController
@RequestMapping("/company")
public class ShippingCompanyController {

	@Autowired
	private ShippingCompanyService service;

	@ApiOperation(nickname = "company-get", value = "Busca informações detalhadas da Transportadora")
	@GetMapping("/{id}")
	private ResponseEntity<ShippingCompanyDetailsDTO> getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@ApiOperation(nickname = "company-get", value = "Busca informações resumidas das Transportadoras")
	@GetMapping()
	public Page<ShippingCompanyDTO> resume(FilterObject filter, Pageable pageable) {
		return service.getFilteredList(filter, pageable);
	}

	@ApiOperation(nickname = "company-post", value = "Realiza a criação da Transportadora")
	@PostMapping
	private ResponseEntity<ShippingCompanyDetailsDTO> update(
			@RequestBody @Valid ShippingCompanyDetailsDTO requestObject) {
		return ResponseEntity.ok().body(service.updateOrCreate(null, requestObject, true));
	}

	@ApiOperation(nickname = "company-put", value = "Realiza a alteração dos dados da Transportadora")
	@PutMapping("/{id}")
	private ResponseEntity<ShippingCompanyDetailsDTO> update(@PathVariable("id") Long id,
			@RequestBody @Valid ShippingCompanyDetailsDTO requestObject) {
		return ResponseEntity.ok().body(service.updateOrCreate(id, requestObject, false));
	}

	@ApiOperation(nickname = "company-delete", value = "Deleta a Transportadora")
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(nickname = "company-get-filter", value = "Busca a lista de filtros agrupada")
	@GetMapping("/filter")
	public List<List<FilterCount>> getFiltersCount() {
		return service.getFilterCount();
	}
}

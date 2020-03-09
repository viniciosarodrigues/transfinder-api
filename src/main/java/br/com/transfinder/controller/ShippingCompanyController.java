package br.com.transfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transfinder.model.external.ShippingCompanyDetailsDTO;
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
}

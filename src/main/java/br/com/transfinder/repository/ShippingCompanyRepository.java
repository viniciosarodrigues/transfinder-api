package br.com.transfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.transfinder.model.ShippingCompany;
import br.com.transfinder.repository.query.ShippingCompanyQuery;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Long>, ShippingCompanyQuery {

}

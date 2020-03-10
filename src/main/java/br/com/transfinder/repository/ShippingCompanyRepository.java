package br.com.transfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.transfinder.model.ShippingCompany;
import br.com.transfinder.repository.filter.FilterCount;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Long> {

	@Query("SELECT NEW br.com.transfinder.repository.filter.FilterCount('CITY', count(obj.city), obj.city) FROM ShippingCompany as obj group by obj.city")
	public List<FilterCount> getCityCount();

	@Query("SELECT NEW br.com.transfinder.repository.filter.FilterCount('MODAL', count(obj.modalType), obj.modalType) FROM ShippingCompany as obj group by obj.modalType")
	public List<FilterCount> getModalCount();

	@Query("SELECT NEW br.com.transfinder.repository.filter.FilterCount('UF', count(obj.uf), obj.uf) FROM ShippingCompany as obj group by obj.uf")
	public List<FilterCount> getUFCount();
}

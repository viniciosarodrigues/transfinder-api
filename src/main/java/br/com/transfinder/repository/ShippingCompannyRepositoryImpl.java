package br.com.transfinder.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.transfinder.model.ShippingCompany;
import br.com.transfinder.model.external.ShippingCompanyDTO;
import br.com.transfinder.repository.filter.FilterObject;

/**
 * Repositório inteligente para busca paginada
 * 
 * @author viniciosarodrigues
 *
 */
@Component
public class ShippingCompannyRepositoryImpl implements ShippingCompanyQuery {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Realiza a busca paginada resumida com filtros
	 */
	@Override
	public Page<ShippingCompanyDTO> getPageFromFilter(FilterObject filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ShippingCompanyDTO> criteria = builder.createQuery(ShippingCompanyDTO.class);
		Root<ShippingCompany> root = criteria.from(ShippingCompany.class);

		criteria.select(builder.construct(ShippingCompanyDTO.class, root.get("id"), root.get("urlLogo"),
				root.get("name"), root.get("cnpj"), root.get("number"), root.get("cellphone"), root.get("email")));

		Predicate[] predicates = createRestrictions(filter, builder, root);
		criteria.where(predicates);

		TypedQuery<ShippingCompanyDTO> query = manager.createQuery(criteria);
		addPagination(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, setPageSetting(filter));
	}

	/**
	 * Realiza o cálculo de páginas
	 * 
	 * @param filter
	 * @return
	 */
	private Long setPageSetting(FilterObject filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<ShippingCompany> root = criteriaQuery.from(ShippingCompany.class);

		Predicate[] predicates = createRestrictions(filter, builder, root);
		criteriaQuery.where(predicates);
		criteriaQuery.select(builder.count(root));

		return manager.createQuery(criteriaQuery).getSingleResult();
	}

	/**
	 * Adiciona paginação enviada pela requisição
	 * 
	 * @param query
	 * @param pageable
	 */
	private void addPagination(TypedQuery<ShippingCompanyDTO> query, Pageable pageable) {
		Integer currentPage = pageable.getPageNumber();
		Integer maxResultsPerPage = pageable.getPageSize();
		Integer firstResult = currentPage * maxResultsPerPage;

		query.setFirstResult(firstResult);
		query.setMaxResults(maxResultsPerPage);
	}

	/**
	 * Cria as restrições para filtragem
	 * 
	 * @param filter
	 * @param builder
	 * @param root
	 * @return
	 */
	private Predicate[] createRestrictions(FilterObject filter, CriteriaBuilder builder, Root<ShippingCompany> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(filter.getName())) {
			predicates.add(builder.like(builder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getUf())) {
			predicates.add(builder.equal(root.get("uf"), filter.getUf()));
		}
		if (!StringUtils.isEmpty(filter.getCity())) {
			predicates.add(builder.equal(root.get("city"), filter.getCity()));
		}
		if (!StringUtils.isEmpty(filter.getModalType())) {
			predicates.add(builder.equal(root.get("modalType"), filter.getModalType()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}

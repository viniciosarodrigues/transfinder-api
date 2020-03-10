package br.com.transfinder.model.external;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.transfinder.repository.filter.FilterCount;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Objeto de saída para filtros agrupados
 * 
 * @author viniciosarodrigues
 *
 */
public class FilterCountDTO implements Serializable {

	private static final long serialVersionUID = -2827093404776439183L;

	private Map<String, List<FilterDetail>> filters;

	public FilterCountDTO(List<List<FilterCount>> filterCount) {
		filters = new HashMap<>();

		filterCount.forEach(filter -> {
			filters.put(filter.get(0).getType(), getListOfFilterDetail(filter));
		});
	}

	private List<FilterDetail> getListOfFilterDetail(List<FilterCount> filter) {
		List<FilterDetail> convertedList = new ArrayList<>();
		filter.forEach(item -> {
			convertedList.add(new FilterDetail(item.getCount(), item.getDescription()));
		});
		return convertedList;
	}

	public Map<String, List<FilterDetail>> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, List<FilterDetail>> filters) {
		this.filters = filters;
	}

	@Data
	@AllArgsConstructor
	class FilterDetail {
		private long count;

		private String description;
	}
}

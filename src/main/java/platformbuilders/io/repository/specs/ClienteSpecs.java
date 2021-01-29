package platformbuilders.io.repository.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import platformbuilders.io.data.model.Cliente;
import platformbuilders.io.filter.ClienteFilter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteSpecs {

	public static Specification<Cliente> withFilter(ClienteFilter filter) {

		return (root, query, builder) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(filter.getNome())) {
				predicates.add(builder.like(builder.lower(root.get("nome")), "%" + filter.getNome().toLowerCase() + "%"));
			}

			if (filter.getCpf() != null) {
				predicates.add(builder.equal(root.get("cpf"), filter.getCpf()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};

	}
}

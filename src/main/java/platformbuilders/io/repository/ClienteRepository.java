package platformbuilders.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import platformbuilders.io.data.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
	
	@Modifying
	@Query("UPDATE Cliente c SET c.ativo = false WHERE c.id =:id")
	void desativarCliente(@Param("id") Long id);

}

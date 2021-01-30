package platformbuilders.io.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import platformbuilders.io.config.Messages;
import platformbuilders.io.converter.DozerConverter;
import platformbuilders.io.data.model.Cliente;
import platformbuilders.io.data.vo.v1.ClienteVO;
import platformbuilders.io.exception.ResourceNotFoundException;
import platformbuilders.io.filter.ClienteFilter;
import platformbuilders.io.repository.ClienteRepository;
import platformbuilders.io.repository.specs.ClienteSpecs;

/**
 * 
 * @author paiva
 *
 */
@Service
@RequiredArgsConstructor
public class ClienteServices {
	
	private final Messages messages;

	private final ClienteRepository repository;

	public ClienteVO create(ClienteVO person) {
		var entity = DozerConverter.parseObject(person, Cliente.class);
		var newEntity = repository.save(entity);
		var vo = DozerConverter.parseObject(newEntity, ClienteVO.class);
		return vo;
	}

	public List<ClienteVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), ClienteVO.class);
	}
	
	public Page<ClienteVO> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToClienteVO);
	}
	
	private ClienteVO convertToClienteVO(Cliente entity) {
		return DozerConverter.parseObject(entity, ClienteVO.class);
	}

	public ClienteVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(messages.get("nenhum.registro.encontrado")));
		return DozerConverter.parseObject(entity, ClienteVO.class);
	}
	
	public ClienteVO update(ClienteVO cliente) {
		var entity = repository.findById(cliente.getKey())
				.orElseThrow(() -> new ResourceNotFoundException(messages.get("nenhum.registro.encontrado")));
		entity.setCpf(cliente.getCpf());
		entity.setDataNascimento(cliente.getDataNascimento());
		entity.setNome(cliente.getNome());
		var vo = DozerConverter.parseObject(repository.save(entity), ClienteVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Cliente entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(messages.get("nenhum.registro.encontrado")));
		repository.delete(entity);
	}
	
	@Transactional
	public ClienteVO desativarCliente(Long id) {
		repository.desativarCliente(id);			
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(messages.get("nenhum.registro.encontrado")));
		return DozerConverter.parseObject(entity, ClienteVO.class);
	}

	public Page<ClienteVO> findClientePorCpfNome(ClienteFilter filter, Pageable pageable) {
		var page = repository.findAll(ClienteSpecs.withFilter(filter), pageable);
		return page.map(this::convertToClienteVO);
	}

}

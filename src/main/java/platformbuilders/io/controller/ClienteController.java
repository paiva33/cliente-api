package platformbuilders.io.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import platformbuilders.io.data.vo.v1.ClienteVO;
import platformbuilders.io.filter.ClienteFilter;
import platformbuilders.io.services.ClienteServices;

@RequiredArgsConstructor
@Api(tags = "ClienteEndpoint")
@RestController
@RequestMapping("/api/cliente/v1")
public class ClienteController {

	private final ClienteServices service;
	
	private final PagedResourcesAssembler<ClienteVO> assembler;

	@ApiOperation(value = "Encontrar todos os clientes")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="limit", defaultValue = "12") int limit,
			@RequestParam(value="direction", defaultValue = "asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "id"));
		
		Page<ClienteVO> clientes = service.findAll(pageable);
		// @formatter:off
		clientes
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(ClienteController.class).findById(p.getKey())).withSelfRel()
				)
			);
		// @formatter:on
		
		PagedResources<?> resources = assembler.toResource(clientes);
		
		return new ResponseEntity(resources, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Encontrar um cliente por cpf e nome" ) 
	@GetMapping(value = "/findPorNomeCpf", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findClientePorCpfNome(
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String cpf,
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="limit", defaultValue = "12") int limit,
			@RequestParam(value="direction", defaultValue = "asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "id"));
		
		ClienteFilter filter = new ClienteFilter(nome, cpf);
		
		Page<ClienteVO> clientes =  service.findClientePorCpfNome(filter, pageable);
		clientes
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(ClienteController.class).findById(p.getKey())).withSelfRel()
				)
			);
		
		PagedResources<?> resources = assembler.toResource(clientes);
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}	

	@ApiOperation(value = "Encontrar cliente por ID")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ClienteVO findById(@PathVariable("id") Long id) {
		ClienteVO clienteVO = service.findById(id);
		clienteVO.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
		return clienteVO;
	}

	@ApiOperation(value = "Criar um cliente")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public ClienteVO create(@RequestBody ClienteVO cliente) {
		ClienteVO clienteVO = service.create(cliente);
		clienteVO.add(linkTo(methodOn(ClienteController.class).findById(clienteVO.getKey())).withSelfRel());
		return clienteVO;
	}

	@ApiOperation(value = "Atualizar um cliente")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public ClienteVO update(@RequestBody ClienteVO person) {
		ClienteVO clienteVO = service.update(person);
		clienteVO.add(linkTo(methodOn(ClienteController.class).findById(clienteVO.getKey())).withSelfRel());
		return clienteVO;
	}

	@ApiOperation(value = "Disable a specific person by your ID")
	@PatchMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ClienteVO disablePerson(@PathVariable("id") Long id) {
		ClienteVO clienteVO = service.desativarCliente(id);
		clienteVO.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
		return clienteVO;
	}

	@ApiOperation(value = "Deletar um cliente")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}

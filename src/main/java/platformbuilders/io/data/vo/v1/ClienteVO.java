package platformbuilders.io.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import lombok.Data;
import lombok.EqualsAndHashCode;
import platformbuilders.io.util.Idade;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder({ "id", "nome", "cpf", "dataNascimento", "ativo" })
public class ClienteVO extends RepresentationModel<ClienteVO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private boolean ativo;
	
	
	public int getIdade() {
		return Idade.calcular(this.dataNascimento);
	}
}

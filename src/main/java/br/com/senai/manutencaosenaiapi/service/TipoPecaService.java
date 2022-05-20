package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.entity.TipoPeca;
import br.com.senai.manutencaosenaiapi.repository.TipoPecaRepository;

@Service
@Validated
public class TipoPecaService {
	
	@Autowired
	private TipoPecaRepository repository;
	
	public TipoPeca inserir(@Valid 
							@NotNull(message = "O tipo da peça não pode ser nulo") TipoPeca novoTipoDePeca) {
		TipoPeca tipoDePecaSalva = repository.save(novoTipoDePeca);
		return tipoDePecaSalva;
	}
		
	public TipoPeca alterar(@Valid
							@NotNull(message = "O Tipo de peça não pode ser nulo") TipoPeca tipoPecaSalva) {
		TipoPeca TipoPecaAtualizada = repository.save(tipoPecaSalva);
		return tipoPecaSalva;
	}
	
	public void removerPor(@NotNull (message = "O id do tipo da peça mão pode ser nulo")
				@Min(value = 1, message = "O id do tipo da peça deve ser maior que zero")Integer id) {
		this.repository.deleteById(id);
	}
	
	public List<TipoPeca> listarPor(
			@NotEmpty(message = "A descrição da busca do tipo da peça é obrigatória")
			@NotBlank(message = "A descrição do tipo da peça não pode conter espaço em branco")
			String descricao){
		return repository.listarPor("%" + descricao + "%");
	}

}


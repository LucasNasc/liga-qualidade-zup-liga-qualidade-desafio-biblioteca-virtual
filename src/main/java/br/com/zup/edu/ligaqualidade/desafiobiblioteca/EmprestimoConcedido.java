package br.com.zup.edu.ligaqualidade.desafiobiblioteca;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;

public class EmprestimoConcedido {

	public final int idEmprestimo;
	public final int idUsuario;
	public final int idExemplar;
	// data em função do tempo de emprestimo
	public final LocalDate dataPrevistaDevolucao;
	// instante da devolução
	private Instant momentoDevolucao;

	/**
	 * 
	 * @param idUsuario id referente ao {@link DadosUsuario}
	 * @param idExemplar id referente ao {@link DadosExemplar}
	 * @param dataPrevistaDevolucao data prevista para devolução em função do número de dias
	 */
	public EmprestimoConcedido(int idEmprestimo, int idUsuario,int idExemplar ,LocalDate dataPrevistaDevolucao) {
		super();
		this.idEmprestimo = idEmprestimo;
		this.idUsuario = idUsuario;
		this.idExemplar = idExemplar;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	
	public void registraDevolucao() {
		this.momentoDevolucao = Instant.now();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public Optional<Instant> getMomentoDevolucao(){
		return Optional.ofNullable(this.momentoDevolucao);
	}

	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPrevistaDevolucao == null) ? 0
				: dataPrevistaDevolucao.hashCode());
		result = prime * result + idExemplar;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmprestimoConcedido other = (EmprestimoConcedido) obj;
		if (dataPrevistaDevolucao == null) {
			if (other.dataPrevistaDevolucao != null)
				return false;
		} else if (!dataPrevistaDevolucao.equals(other.dataPrevistaDevolucao))
			return false;
		if (idExemplar != other.idExemplar)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}
	
	


}

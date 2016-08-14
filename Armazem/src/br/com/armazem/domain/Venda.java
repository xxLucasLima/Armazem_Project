package br.com.armazem.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_vendas")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ven_codigo")
	private Long codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ven_horario", nullable = false)
	private Date horario;
	
	@Column(name="ven_total", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ven_tbl_funcionarios_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
	private Funcionario funcionario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}

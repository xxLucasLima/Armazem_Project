package br.com.armazem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fabricantes")
@NamedQueries({
	@NamedQuery(name="Fabricante.listar", query = "SELECT fabricante FROM Fabricante fabricante"),
	@NamedQuery (name="Fabricante.buscarPorCodigo", query="SELECT fabricante FROM Fabricante fabricante WHERE fabricante.codigo = :codigo")
	})
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fab_codigo")
	private Long codigo;

	@Column (name="fab_descricao", length = 50)
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}

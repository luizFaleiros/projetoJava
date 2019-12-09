
import java.sql.ResultSet;
import java.sql.SQLException;

public class Padaria {
	
	private String idItem; 
	private String nome;
	private String qnt; 
	private String descricao; 
	private String valor;
	
	private String tableName	= "padaria.item";
	private String fieldsName 	= "idItem, nome, qnt, descricao, valor";
	private String fieldKey		= "idUsuario";
	
	DbQuery dbQuery = new DbQuery(tableName, fieldsName, fieldKey);
	
	
	public Padaria(String idItem, String nome, String qnt, String  descricao, String valor) {
		this.idItem = idItem;
		this.nome      = nome;
		this.qnt     = qnt;
		this.descricao     = descricao;
		this.valor     = valor;
	}
	
	public Padaria() {

	}

	private String[] toArray() {
		return(
			new String[]{
					this.idItem,
					this.nome,
					this.qnt,
					this.descricao,
					this.valor	
			}
		);

	}
	
	public void save() {
		if (this.idItem == ""){
			this.idItem = "0";
			dbQuery.insert(this.toArray());
		}else{
			dbQuery.update(this.toArray());
		}
	}
	
	public void delete() {
		if (this.idItem != ""){
			dbQuery.delete(this.toArray());
		}
	}
	
	
	public ResultSet listall() {
		return(dbQuery.select(""));
	}
	
	public ResultSet listOne(String id) {
		return(dbQuery.select("where idItem="+id));
	}

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQnt() {
		return qnt;
	}

	public void setQnt(String qnt) {
		this.qnt = qnt;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

}

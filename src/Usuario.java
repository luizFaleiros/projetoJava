
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
	
	private String idUsuario; 
	private String nome;
	private String email; 
	private String senha; 
	private String nivel;
	
	private String tableName	= "padaria.usuarios";
	private String fieldsName 	= "idUsuario, nome, email, senha, nivel";
	private String fieldKey		= "idUsuario";
	
	DbQuery dbQuery = new DbQuery(tableName, fieldsName, fieldKey);
	
	
	public Usuario(String idUsuario, String nome, String email, String  senha, String nivel) {
		this.idUsuario = idUsuario;
		this.nome      = nome;
		this.email     = email;
		this.senha     = senha;
		this.nivel     = nivel;
	}
	
	public Usuario() {

	}

	private String[] toArray() {
		return(
			new String[]{
				this.idUsuario, 
				this.nome,
				this.email,
				this.senha,
				this.nivel				
			}
		);

	}
	
	public void save() {
		if (this.idUsuario == ""){
			this.idUsuario = "0";
			dbQuery.insert(this.toArray());
		}else{
			dbQuery.update(this.toArray());
		}
	}
	
	public void delete() {
		if (this.idUsuario != ""){
			dbQuery.delete(this.toArray());
		}
	}
	
	public boolean checkLogin() {
		
		ResultSet rs =	dbQuery.select(" (nome = '"+this.nome+"' OR email = '"+this.email+"') AND  senha = '"+this.senha+"' ");
	 	try {
	 		return( rs.next() );
	 	} catch (SQLException e) {
			e.printStackTrace();
		}
	 	return( false );
	}
	
	public ResultSet listall() {
		return(dbQuery.select(""));
	}
	
	public ResultSet listOne(String id) {
		return(dbQuery.select("where idUsuario="+id));
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}

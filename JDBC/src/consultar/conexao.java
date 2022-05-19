package consultar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class conexao {

	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String urlBD = "jdbc:mysql://localhost:3306/reuniao?user=root&password=ewerton";
		String queryBD = "SELECT * FROM Pessoa";
		//String queryBDI = "INSERT INTO pessoa (nome, email, cargo) values ('Ewerton','ewerton.gomes@hotmail.com','Aluno')";
		String queryBDI = "DELETE FROM pessoa WHERE id=9";
		
		
		java.sql.Statement st;
		ResultSet resultado;
		
		try {
			Class.forName(driver);
			Connection conexao = DriverManager.getConnection(urlBD);
			System.out.println("Conectado...");
			
			st = conexao.createStatement();
			resultado = st.executeQuery(queryBD);
				
			while (resultado.next()) {
				System.out.println("id: "+resultado.getString("ID") + "\t nome: "+ resultado.getString("nome")
				+"\t email: "+ resultado.getString("email")+ "\t Cargo: "+ resultado.getString("cargo")) ;
			}
			//Inserir, alterar ou excluir
			System.out.println(st.execute(queryBDI));
			
				
			
		}catch (ClassNotFoundException ex) {
			System.out.println("Driver de Banco de Dados não Localizado");
		}catch (SQLException ex) {
			System.out.println("Ocorreu um erro ao acessar o banco: " +ex.getMessage());
			
		}

	}

}

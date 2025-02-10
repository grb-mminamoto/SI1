import java.sql.*;
import java.util.Scanner;

public class LoginInseguro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Conexão com o banco de dados (SQLite como exemplo)
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:usuarios.db");
             Statement stmt = conn.createStatement()) {

            // 🔴 Vulnerabilidade: Concatenação direta na query SQL
            String query = "SELECT * FROM usuarios WHERE nome = '" + nome + "' AND senha = '" + senha + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Usuário ou senha inválidos!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://mysql-37dd114c-diegofrra083-641f.c.aivencloud.com:12100/cdz_Cavaleiros_Reencarnados?useSSL=true&verifyServerCertificate=false&allowPublicKeyRetrieval=true";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_tu9CMOGxDtJmxvWs7wi";
    private static Connection conn;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão realizada com sucesso!");

            boolean running = true;
            while (running) {
                System.out.println("\nEscolha a tabela para CRUD:");
                System.out.println("1 - CONSTELACOES");
                System.out.println("2 - ARMADURAS");
                System.out.println("3 - CAVALEIROS");
                System.out.println("4 - ERAS");
                System.out.println("5 - REENCARNACOES");
                System.out.println("0 - Sair");
                int opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1 -> crudConstelacoes();
                    case 2 -> crudArmaduras();
                    case 3 -> crudCavaleiros();
                    case 4 -> crudEras();
                    case 5 -> crudReencarnacoes();
                    case 0 -> running = false;
                    default -> System.out.println("Opção inválida!");
                }
            }

            conn.close();
            System.out.println("Conexão encerrada.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --------------------- CRUD CONSTELACOES ---------------------
    private static void crudConstelacoes() throws SQLException {
        System.out.println("\nCRUD CONSTELACOES");
        System.out.println("1 - Inserir");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        int opc = Integer.parseInt(sc.nextLine());

        switch (opc) {
            case 1 -> inserirConstelacao();
            case 2 -> listarConstelacoes();
            case 3 -> atualizarConstelacao();
            case 4 -> deletarConstelacao();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void inserirConstelacao() throws SQLException {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Elemento: ");
        String elemento = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        String sql = "INSERT INTO CONSTELACOES (nome, elemento, descricao) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, elemento);
        ps.setString(3, descricao);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Constelação inserida com sucesso." : "Erro ao inserir constelação.");
    }

    private static void listarConstelacoes() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM CONSTELACOES");
        while (rs.next()) {
            System.out.printf("ID: %d | Nome: %s | Elemento: %s | Descrição: %s%n",
                    rs.getInt("id_constelacao"), rs.getString("nome"), rs.getString("elemento"), rs.getString("descricao"));
        }
    }

    private static void atualizarConstelacao() throws SQLException {
        System.out.print("ID da constelação a atualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo elemento: ");
        String elemento = sc.nextLine();
        System.out.print("Nova descrição: ");
        String descricao = sc.nextLine();

        String sql = "UPDATE CONSTELACOES SET nome = ?, elemento = ?, descricao = ? WHERE id_constelacao = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, elemento);
        ps.setString(3, descricao);
        ps.setInt(4, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Constelação atualizada." : "Erro na atualização.");
    }

    private static void deletarConstelacao() throws SQLException {
        System.out.print("ID da constelação a deletar: ");
        int id = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM CONSTELACOES WHERE id_constelacao = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Constelação deletada." : "Erro na exclusão.");
    }

    // --------------------- CRUD ARMADURAS ---------------------
    private static void crudArmaduras() throws SQLException {
        System.out.println("\nCRUD ARMADURAS");
        System.out.println("1 - Inserir");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        int opc = Integer.parseInt(sc.nextLine());

        switch (opc) {
            case 1 -> inserirArmadura();
            case 2 -> listarArmaduras();
            case 3 -> atualizarArmadura();
            case 4 -> deletarArmadura();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void inserirArmadura() throws SQLException {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Tipo: ");
        String tipo = sc.nextLine();
        System.out.print("Material: ");
        String material = sc.nextLine();
        System.out.print("Poder base: ");
        String poder = sc.nextLine();

        String sql = "INSERT INTO ARMADURAS (nome, tipo, material, poder_base) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, tipo);
        ps.setString(3, material);
        ps.setString(4, poder);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Armadura inserida com sucesso." : "Erro ao inserir armadura.");
    }

    private static void listarArmaduras() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ARMADURAS");
        while (rs.next()) {
            System.out.printf("ID: %d | Nome: %s | Tipo: %s | Material: %s | Poder Base: %s%n",
                    rs.getInt("id_armadura"), rs.getString("nome"), rs.getString("tipo"),
                    rs.getString("material"), rs.getString("poder_base"));
        }
    }

    private static void atualizarArmadura() throws SQLException {
        System.out.print("ID da armadura a atualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo tipo: ");
        String tipo = sc.nextLine();
        System.out.print("Novo material: ");
        String material = sc.nextLine();
        System.out.print("Novo poder base: ");
        String poder = sc.nextLine();

        String sql = "UPDATE ARMADURAS SET nome = ?, tipo = ?, material = ?, poder_base = ? WHERE id_armadura = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, tipo);
        ps.setString(3, material);
        ps.setString(4, poder);
        ps.setInt(5, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Armadura atualizada." : "Erro na atualização.");
    }

    private static void deletarArmadura() throws SQLException {
        System.out.print("ID da armadura a deletar: ");
        int id = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM ARMADURAS WHERE id_armadura = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Armadura deletada." : "Erro na exclusão.");
    }

    // --------------------- CRUD CAVALEIROS ---------------------
    private static void crudCavaleiros() throws SQLException {
        System.out.println("\nCRUD CAVALEIROS");
        System.out.println("1 - Inserir");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        int opc = Integer.parseInt(sc.nextLine());

        switch (opc) {
            case 1 -> inserirCavaleiro();
            case 2 -> listarCavaleiros();
            case 3 -> atualizarCavaleiro();
            case 4 -> deletarCavaleiro();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void inserirCavaleiro() throws SQLException {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        System.out.print("Nível: ");
        String nivel = sc.nextLine();
        System.out.print("ID Constelação: ");
        int idConstelacao = Integer.parseInt(sc.nextLine());
        System.out.print("ID Armadura: ");
        int idArmadura = Integer.parseInt(sc.nextLine());

        String sql = "INSERT INTO CAVALEIROS (nome, idade, nivel, id_constelacao, id_armadura) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setInt(2, idade);
        ps.setString(3, nivel);
        ps.setInt(4, idConstelacao);
        ps.setInt(5, idArmadura);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Cavaleiro inserido com sucesso." : "Erro ao inserir cavaleiro.");
    }

    private static void listarCavaleiros() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT c.id_cavaleiro, c.nome, c.idade, c.nivel, co.nome AS constelacao, a.nome AS armadura " +
                        "FROM CAVALEIROS c " +
                        "LEFT JOIN CONSTELACOES co ON c.id_constelacao = co.id_constelacao " +
                        "LEFT JOIN ARMADURAS a ON c.id_armadura = a.id_armadura"
        );
        while (rs.next()) {
            System.out.printf("ID: %d | Nome: %s | Idade: %d | Nível: %s | Constelação: %s | Armadura: %s%n",
                    rs.getInt("id_cavaleiro"), rs.getString("nome"), rs.getInt("idade"), rs.getString("nivel"),
                    rs.getString("constelacao"), rs.getString("armadura"));
        }
    }

    private static void atualizarCavaleiro() throws SQLException {
        System.out.print("ID do cavaleiro a atualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Nova idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        System.out.print("Novo nível: ");
        String nivel = sc.nextLine();
        System.out.print("Novo ID constelação: ");
        int idConstelacao = Integer.parseInt(sc.nextLine());
        System.out.print("Novo ID armadura: ");
        int idArmadura = Integer.parseInt(sc.nextLine());

        String sql = "UPDATE CAVALEIROS SET nome = ?, idade = ?, nivel = ?, id_constelacao = ?, id_armadura = ? WHERE id_cavaleiro = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setInt(2, idade);
        ps.setString(3, nivel);
        ps.setInt(4, idConstelacao);
        ps.setInt(5, idArmadura);
        ps.setInt(6, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Cavaleiro atualizado." : "Erro na atualização.");
    }

    private static void deletarCavaleiro() throws SQLException {
        System.out.print("ID do cavaleiro a deletar: ");
        int id = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM CAVALEIROS WHERE id_cavaleiro = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Cavaleiro deletado." : "Erro na exclusão.");
    }

    // --------------------- CRUD ERAS ---------------------
    private static void crudEras() throws SQLException {
        System.out.println("\nCRUD ERAS");
        System.out.println("1 - Inserir");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        int opc = Integer.parseInt(sc.nextLine());

        switch (opc) {
            case 1 -> inserirEra();
            case 2 -> listarEras();
            case 3 -> atualizarEra();
            case 4 -> deletarEra();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void inserirEra() throws SQLException {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        String sql = "INSERT INTO ERAS (nome, descricao) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, descricao);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Era inserida com sucesso." : "Erro ao inserir era.");
    }

    private static void listarEras() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ERAS");
        while (rs.next()) {
            System.out.printf("ID: %d | Nome: %s | Descrição: %s%n",
                    rs.getInt("id_era"), rs.getString("nome"), rs.getString("descricao"));
        }
    }

    private static void atualizarEra() throws SQLException {
        System.out.print("ID da era a atualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Nova descrição: ");
        String descricao = sc.nextLine();

        String sql = "UPDATE ERAS SET nome = ?, descricao = ? WHERE id_era = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, descricao);
        ps.setInt(3, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Era atualizada." : "Erro na atualização.");
    }

    private static void deletarEra() throws SQLException {
        System.out.print("ID da era a deletar: ");
        int id = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM ERAS WHERE id_era = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Era deletada." : "Erro na exclusão.");
    }

    // --------------------- CRUD REENCARNACOES ---------------------
    private static void crudReencarnacoes() throws SQLException {
        System.out.println("\nCRUD REENCARNACOES");
        System.out.println("1 - Inserir");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        int opc = Integer.parseInt(sc.nextLine());

        switch (opc) {
            case 1 -> inserirReencarnacao();
            case 2 -> listarReencarnacoes();
            case 3 -> atualizarReencarnacao();
            case 4 -> deletarReencarnacao();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void inserirReencarnacao() throws SQLException {
        System.out.print("ID Cavaleiro: ");
        int idCavaleiro = Integer.parseInt(sc.nextLine());
        System.out.print("ID Era: ");
        int idEra = Integer.parseInt(sc.nextLine());
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        String sql = "INSERT INTO REENCARNACOES (id_cavaleiro, id_era, descricao) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idCavaleiro);
        ps.setInt(2, idEra);
        ps.setString(3, descricao);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Reencarnação inserida." : "Erro ao inserir reencarnação.");
    }

    private static void listarReencarnacoes() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT r.id_reencarnacao, c.nome AS cavaleiro, e.nome AS era, r.descricao " +
                        "FROM REENCARNACOES r " +
                        "LEFT JOIN CAVALEIROS c ON r.id_cavaleiro = c.id_cavaleiro " +
                        "LEFT JOIN ERAS e ON r.id_era = e.id_era"
        );
        while (rs.next()) {
            System.out.printf("ID: %d | Cavaleiro: %s | Era: %s | Descrição: %s%n",
                    rs.getInt("id_reencarnacao"), rs.getString("cavaleiro"),
                    rs.getString("era"), rs.getString("descricao"));
        }
    }

    private static void atualizarReencarnacao() throws SQLException {
        System.out.print("ID da reencarnação a atualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Novo ID Cavaleiro: ");
        int idCavaleiro = Integer.parseInt(sc.nextLine());
        System.out.print("Novo ID Era: ");
        int idEra = Integer.parseInt(sc.nextLine());
        System.out.print("Nova descrição: ");
        String descricao = sc.nextLine();

        String sql = "UPDATE REENCARNACOES SET id_cavaleiro = ?, id_era = ?, descricao = ? WHERE id_reencarnacao = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idCavaleiro);
        ps.setInt(2, idEra);
        ps.setString(3, descricao);
        ps.setInt(4, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Reencarnação atualizada." : "Erro na atualização.");
    }

    private static void deletarReencarnacao() throws SQLException {
        System.out.print("ID da reencarnação a deletar: ");
        int id = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM REENCARNACOES WHERE id_reencarnacao = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int r = ps.executeUpdate();
        System.out.println(r > 0 ? "Reencarnação deletada." : "Erro na exclusão.");
    }
}

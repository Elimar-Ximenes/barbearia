/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import modelo.Agendamento;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgendamentoDAO {

    private Connection connection;
    Long id;
    String nome;
    String data;
    String horario;
    String servico;

    public AgendamentoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void salvar(Agendamento objAgenda) {
        try {
            String sql;
            if (String.valueOf(objAgenda.getId()).isEmpty()) {
                sql = "INSERT INTO agenda(nome,data,horario,servico) VALUES(?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objAgenda.getNome());
                stmt.setString(2, objAgenda.getData());
                stmt.setString(3, objAgenda.getHorario());
                stmt.setString(4, objAgenda.getServico());
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE agenda SET nome = ?, data = ?, horario = ?, servico = ? WHERE agenda.id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(5, objAgenda.getId());
                stmt.setString(1, objAgenda.getNome());
                stmt.setString(2, objAgenda.getData());
                stmt.setString(3, objAgenda.getHorario());
                stmt.setString(4, objAgenda.getServico());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList buscar(Agendamento objAgenda) {
        try {
            String sql = "";
            if (!objAgenda.getNome().isEmpty()) {
                sql = "SELECT * FROM agenda WHERE nome LIKE '%" + objAgenda.getNome() + "%' ";

            } else if (!objAgenda.getData().isEmpty()) {
                sql = "SELECT * FROM agenda WHERE data LIKE '%" + objAgenda.getData() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("data"),
                    rs.getString("horario"),
                    rs.getString("servico")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }

    }

    public void deletar(Agendamento objAgenda) {
        try {
            String sql;
            if (!String.valueOf(objAgenda.getId()).isEmpty()) {
                sql = "DELETE FROM agenda WHERE agenda.id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objAgenda.getId());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList listarTodos() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM agenda");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("data"),
                    rs.getString("horario"),
                    rs.getString("servico")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList");
            return null;
        }
    }

    public static void testarConexao() throws SQLException {
        try (Connection objConnection = new ConnectionFactory().getConnection()) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ");
        }
    }

}

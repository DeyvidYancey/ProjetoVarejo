/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoVarejo.DAO;

import com.itextpdf.text.Document;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import projetoVarejo.JDBC.ConnectionFactory;
import projetoVarejo.OBJECTS.Cliente;
import projetoVarejo.OBJECTS.Vendas;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.swing.JOptionPane;
import projetoVarejo.OBJECTS.Funcionario;

/**
 *
 * @author alex
 */
public class VendasDAO {

    private Connection con;

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarVenda(Vendas obj) {
        try {
            String sql = "insert into vendas (cliente_id, data_venda, total_venda,observacoes,funcionario_id) values (?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getCliente().getId());
            stm.setString(2, obj.getData_venda());
            stm.setDouble(3, obj.getTotal_venda());
            stm.setString(4, obj.getObs());
            stm.setInt(5, obj.getFuncionario().getId());
           // stm.setString(6, obj.getCliente().getNome());
           // stm.setString(7, obj.getProduto().getNome());

            stm.execute();
            stm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro  Cadastrar Venda DAO: " + e);
        }
    }

    public int retornaUltimaVenda() {
        try {
            int idvenda = 0;

            String sql = "select max(id) id from vendas";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vendas p = new Vendas();

                p.setId(rs.getInt("id"));
                idvenda = p.getId();
            }

            return idvenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public double retornaTotalVendaPorData(LocalDate data_venda) {
        try {

            double totalvenda = 0;

            String sql = "select sum(total_venda) as total from vendas where data_venda = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, data_venda.toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalvenda = rs.getDouble("total");
            }

            return totalvenda;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateVenda(Vendas obj) {
        try {
            String sql = "update vendas set cliente_id =?, data_venda=?, total_venda =?, funcionario_id=? where id =?";

            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, obj.getCliente_id());
            stm.setString(2, obj.getData_venda());
            stm.setDouble(3, obj.getTotal_venda());
            stm.setInt(4, obj.getFuncionario_id());
           // stm.setString(5, obj.getCliente_nome());
           // stm.setString(6, obj.getProduto_nome());
           
            stm.setInt(5, obj.getId());

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar Venda! " + e);
        }
    }

    public List<Vendas> listarVendas() {
        try {
            List<Vendas> lista = new ArrayList<>();
            String sql = "Select * from vendas";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();

                Vendas obj = new Vendas();
                obj.setId(rs.getInt("id"));
                obj.setCliente_id(rs.getInt("cliente_id"));
                obj.setData_venda(rs.getString("data_venda"));
                obj.setTotal_venda(rs.getDouble("total_venda"));
                obj.setFuncionario_id(rs.getInt("funcionario_id"));
                //obj.setCliente_nome(rs.getString("nome_cliente"));
               // obj.setProduto_nome(rs.getString("nome_cliente"));

                lista.add(obj);

            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Vendas " + e);
        }
        return null;
    }
    
    
    
 
}
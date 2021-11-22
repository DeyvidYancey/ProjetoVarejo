/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoVarejo.DAO;

import projetoVarejo.JDBC.ConnectionFactory;


import projetoVarejo.OBJECTS.Produto;
import projetoVarejo.interfaces.DAO.IProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetoVarejo.JDBC.ConnectionFactory;

/**
 *
 * @author Deyvid Yancey
 */
public class ProdutoDAO implements IProdutoDAO {

    private Connection con;
    private PreparedStatement pstm;

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection();

    }

    @Override
    public void adicionarProduto(Produto obj) {
        try {
            String sql = "insert into produto (nome, precodecompra, precodevenda, estoque, fornecedor, unidade, porcentagemdelucro, tipo ) values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setDouble(2, obj.getPrecoDeCompra());
            stm.setDouble(3, obj.getPrecoDeVenda());
            stm.setString(4, obj.getEstoque());
            stm.setInt(5, obj.getFornecedor());
            stm.setString(6, obj.getUnidade());
            stm.setDouble(7, obj.getPorcentagem());
            stm.setString(8, obj.getTipo());
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no metodo de adicionar" + e);
        }

    }

    @Override
    /*   public void updateProduto(Produto obj) {

        try {
            String sql = "update produto set nome = ?, precodecompra =?, precodevenda=?, estoque =?, fornecedor = ?, unidade =?, porcentagemdelucro= ? where id =?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setDouble(2, obj.getPrecoDeCompra());
            stm.setDouble(3, obj.getPrecoDeVenda());
            stm.setString(4, obj.getEstoque());
            stm.setInt(5, obj.getFornecedor());
            stm.setString(6, obj.getUnidade());
            stm.setDouble(7, obj.getPorcentagem());
            stm.setInt(8, obj.getId());

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar funcionario! " + e);
        }
    }*/

    public void updateProduto(Produto obj) {
        try {
            String sql = "update produto set nome=?, precoDeCompra=?, precoDeVenda=?, estoque=?, fornecedor=?, unidade=?, porcentagemdelucro=?, tipo=? where id =?";

            System.out.print(obj.getId());
            
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setDouble(2, obj.getPrecoDeCompra());
            stm.setDouble(3, obj.getPrecoDeVenda());
            stm.setString(4, obj.getEstoque());
            stm.setInt(5, obj.getFornecedor());
            stm.setString(6, obj.getUnidade());
            stm.setDouble(7, obj.getPorcentagem());
            stm.setString(8, obj.getTipo());
            stm.setInt(9, obj.getId());
            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "alteração efetuada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto! " + e);
        }
    }

    @Override
    public void deletarProduto(Produto obj) {
        try {
            String sql = "delete from produto where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getId());

            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto" + e);
        }
    }

    @Override
    public List<Produto> listarProduto() {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "Select * from produto";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Produto obj = new Produto();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPrecoDeCompra(rs.getDouble("precodecompra"));
                obj.setPrecoDeVenda(rs.getDouble("precodevenda"));
                obj.setEstoque(rs.getString("estoque"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setUnidade(rs.getString("unidade"));
                obj.setPorcentagem(rs.getDouble("porcentagemdelucro"));
                obj.setTipo(rs.getString("tipo"));
                lista.add(obj);

            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Fornecedor " + e);
        }
        return null;

    }

    @Override
    public List<Produto> buscarProdutoPorNome(String nome) {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "Select * from produto where nome like  ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto obj = new Produto();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPrecoDeCompra(rs.getDouble("precodecompra"));
                obj.setPrecoDeVenda(rs.getDouble("precodevenda"));
                obj.setEstoque(rs.getString("estoque"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setUnidade(rs.getString("unidade"));
                obj.setPorcentagem(rs.getDouble("porcentagemdelucro"));
                obj.setTipo(rs.getString("tipo"));
                lista.add(obj);
            }

            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR PRODUTO POR NOME NO DAO" + e);
            return null;
        }
    }

    @Override
    public ResultSet listarFornecedor() {
        con = new ConnectionFactory().getConnection();
        String sql = "select * from fornecedor";
        try {
            pstm = con.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " erro ao listar COMBOBOX" + e);
            return null;
        }
    }

    public double valorDeVenda(double valorDeCompra, double porcentagem) {

        double valorFinal = valorDeCompra + (porcentagem / 100.0);

        return valorFinal;
    }

    public int retornaEstoqueAtual(int id) {
        try {
            int qtd_estoque = 0;

            String sql = "SELECT estoque from produto where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {           
                qtd_estoque = (rs.getInt("estoque"));    
            }

            return qtd_estoque;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Produto buscaPorCodigo(String codigo) {
     try {

            String sql = "Select * from produto where id = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            Produto obj = new Produto();
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPrecoDeCompra(rs.getDouble("precodecompra"));
                obj.setPrecoDeVenda(rs.getDouble("precodevenda"));
                obj.setEstoque(rs.getString("estoque"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setUnidade(rs.getString("unidade"));
                obj.setPorcentagem(rs.getDouble("porcentagemdelucro"));
                obj.setTipo(rs.getString("tipo"));

            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR PRODUTO POR CODIGO" + e);
            return null;
        }
    
   
} 
    
    public void baixaEstoque(int id, int qtd_nova) {
        try {

            String sql = "update produto  set estoque= ?  where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();

         

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro : " + erro);

        }

    }
 
    
    public void adicionarEstoque(int id, int qtd_nova) {
        try {

            String sql = "update produto  set estoque= ?  where id=?";
           
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();

          

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro : " + erro);

        }

    }
    
    
    
}
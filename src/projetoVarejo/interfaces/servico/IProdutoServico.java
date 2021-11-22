/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoVarejo.interfaces.servico;

import projetoVarejo.OBJECTS.Produto;
import projetoVarejo.exceptions.ProdutoException;
import java.util.List;

/**
 *
 * @author Deyvid Yancey
 */
public interface IProdutoServico {
     public void adicionarProduto(Produto obj) throws ProdutoException;
    public void updateProduto (Produto obj)throws ProdutoException;
    public void deletarProduto (Produto obj)throws ProdutoException;
    public List<Produto> listarProduto()throws ProdutoException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoVarejo.interfaces.servico;

import projetoVarejo.OBJECTS.Funcionario;
import projetoVarejo.exceptions.FornecedorException;
import projetoVarejo.exceptions.FuncionarioException;
import java.util.List;

/**
 *
 * @author Deyvid Yancey
 */
public interface IFuncionarioServico  {
     public void adicionarFornecedor(Funcionario obj)throws FuncionarioException;
    public void updateFornecedor (Funcionario obj)throws FuncionarioException;
    public void deletarFornecedor (Funcionario obj)throws FuncionarioException;
    public List<Funcionario> listarFornecedor()throws FuncionarioException;
}

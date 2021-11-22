/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoVarejo.interfaces.servico;

import projetoVarejo.OBJECTS.Cliente;
import projetoVarejo.exceptions.ClienteException;
import java.util.List;

/**
 *
 * @author Deyvid Yancey
 */
public interface IClienteServico {
     public void adicionarCliente(Cliente obj) throws ClienteException;
    public void updateCliente (Cliente obj)throws ClienteException;
    public void deletarCliente (Cliente obj)throws ClienteException;
    public List<Cliente> listarClientes()throws ClienteException;
}

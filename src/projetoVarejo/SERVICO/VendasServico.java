/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoVarejo.SERVICO;

import javax.swing.JOptionPane;
import projetoVarejo.DAO.VendasDAO;
import projetoVarejo.OBJECTS.Vendas;
import projetoVarejo.exceptions.VendasException;

/**
 *
 * @author Deyvid Yancey
 */
public class VendasServico {
    
    public void updateVenda(Vendas obj) {
        try {
            if ("".equals(obj.getCliente_id()) || "".equals(obj.getData_venda()) || "".equals(obj.getFuncionario_id()) || "".equals(obj.getTotal_venda()) ) {
         throw new VendasException("CERTIFIQUE-SE DE QUE NENHUM CAMPO ESTÁ EM BRANCO");
            }
        VendasDAO dao = new VendasDAO();
        dao.updateVenda(obj);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERRO AO ATUALIZAR CLIENTE NO SERVICO" + e);
        }
        
        }
    
    
    
}

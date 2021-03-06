/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.AgendamentoDAO;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModelTableAgendamento;
import modelo.Agendamento;
/**
 *
 * @author Jackson Meires
 */
public class AgendamentoGUI extends javax.swing.JFrame {

    private Agendamento objAgendamento;
    private AgendamentoDAO objDAO;
    private boolean buscar = false;

    /**
     * Creates new form UsuarioGUI
     */
    public AgendamentoGUI() {

        initComponents();
        setIcon();

        //Centralizando a janela
        this.setLocationRelativeTo(null);
        // Impede que a janela seja redimencionada 
      //this.setResizable(false);
        // Trocando cursor para HAND CURSOR(Maozinha)
        // jButtonRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // Variavel con recebendo a conexao
        carregarTable(null);
    }

    // Metodo que realiza conexao com o banco, faz uma instrucao Query(select)
    // para jogar na JTable atraves do modelo de tabela (ModelTabel.java)
    public void carregarTable(Agendamento objAgendamento) {

        objDAO = new AgendamentoDAO();
        ArrayList dados = new ArrayList();
        if (buscar) {
            dados = objDAO.buscar(objAgendamento);
        } else {
            objAgendamento = new Agendamento();
            dados = objDAO.listarTodos();
        }
        String[] colunas = objAgendamento.getColunas();

        ModelTableAgendamento modelo = new ModelTableAgendamento(dados, colunas);

        tbListagemAgendamento.setModel(modelo);
        tbListagemAgendamento.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbListagemAgendamento.getColumnModel().getColumn(0).setResizable(false);
        tbListagemAgendamento.getColumnModel().getColumn(1).setPreferredWidth(110);
        tbListagemAgendamento.getColumnModel().getColumn(1).setResizable(false);
        tbListagemAgendamento.getColumnModel().getColumn(2).setPreferredWidth(110);
        tbListagemAgendamento.getColumnModel().getColumn(2).setResizable(false);
        tbListagemAgendamento.getTableHeader().setReorderingAllowed(false);
        //  tbListagemUsuario.setAutoResizeMode(tbListagemUsuario.AUTO_RESIZE_ALL_COLUMNS);
        // tbListagemUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Metodo responsavel por selecionar um registro ao clicar ou seguir com as setas do teclado
    // na JTable, e realizar a vinculacao do mesmo nos TextFields
    public void selectRegistryTable() {

        txtID.setText(tbListagemAgendamento.getValueAt(tbListagemAgendamento.getSelectedRow(), 0).toString());

        //Object objNome = tbListagemUsuario.getValueAt(tbListagemUsuario.getSelectedRow(), 1);
        txtNome.setText(tbListagemAgendamento.getValueAt(tbListagemAgendamento.getSelectedRow(), 1).toString());
        txtData.setText(tbListagemAgendamento.getValueAt(tbListagemAgendamento.getSelectedRow(), 2).toString());
        txtHorario.setText(tbListagemAgendamento.getValueAt(tbListagemAgendamento.getSelectedRow(), 3).toString());
        txtServico.setText(tbListagemAgendamento.getValueAt(tbListagemAgendamento.getSelectedRow(), 4).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtServico = new javax.swing.JTextField();
        tbnSalvar = new javax.swing.JButton();
        tbnLimpar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        tbnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListagemAgendamento = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        txtHorario = new javax.swing.JFormattedTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGENDAMENTO");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("ID");

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("NOME:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("DATA:");

        jLabel5.setText("HORÁRIO:");

        jLabel4.setText("SERVIÇO:");

        tbnSalvar.setText("Salvar");
        tbnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSalvarActionPerformed(evt);
            }
        });

        tbnLimpar.setText("Limpar");
        tbnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnLimparActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tbnExit.setText("Alterar");
        tbnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnExitActionPerformed(evt);
            }
        });

        tbListagemAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data", "Horário", "Serviço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListagemAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListagemAgendamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListagemAgendamento);

        jPanel3.setBackground(new java.awt.Color(41, 41, 109));

        jPanel4.setBackground(new java.awt.Color(168, 108, 108));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Agendamento");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tbnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(tbnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHorario)
                                    .addComponent(txtNome))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData)
                            .addComponent(txtServico))))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void tbnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSalvarActionPerformed

        objAgendamento = new Agendamento();
        objAgendamento.setId(txtID.getText());
        objAgendamento.setNome(txtNome.getText());
        objAgendamento.setData(txtData.getText());
        objAgendamento.setHorario(txtHorario.getText());
        objAgendamento.setServico(txtServico.getText());

        // fazendo a valida��o dos dados
        if ((txtNome.getText().isEmpty()) || (txtData.getText().isEmpty()) || (txtHorario.getText().isEmpty()) || (txtServico.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new AgendamentoDAO();
            objDAO.salvar(objAgendamento);
            JOptionPane.showMessageDialog(null, "Usuário " + txtNome.getText() + " agendamento realizado com sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_tbnSalvarActionPerformed

    private void tbnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnLimparActionPerformed
        setClear();
        carregarTable(null);
    }//GEN-LAST:event_tbnLimparActionPerformed

    private void tbnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnExitActionPerformed
        objAgendamento = new Agendamento();
        objAgendamento.setId(txtID.getText());
        objAgendamento.setNome(txtNome.getText());
        objAgendamento.setData(txtData.getText());
        objAgendamento.setHorario(txtHorario.getText());
        objAgendamento.setServico(txtServico.getText());

        // fazendo a valida��o dos dados
        if ((txtNome.getText().isEmpty()) || (txtData.getText().isEmpty()) || (txtHorario.getText().isEmpty()) || (txtServico.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new AgendamentoDAO();
            objDAO.salvar(objAgendamento);
            JOptionPane.showMessageDialog(null, "Usuário " + txtNome.getText() + " seus dados foram alterados com sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_tbnExitActionPerformed

    private void tbListagemAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListagemAgendamentoMouseClicked
        // TODO add your handling code here:
        selectRegistryTable();
    }//GEN-LAST:event_tbListagemAgendamentoMouseClicked

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        
        
        String [] options = {"Não", "Sim"};
    int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja realmente Apagar?", "Título da Janela", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
    if(resposta == 0){
    return;
    }
        if( resposta == 1){
        
        objAgendamento.setId(txtID.getText());

        // fazendo a valida��o dos dados
        if ((txtID.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new AgendamentoDAO();
            objDAO.deletar(objAgendamento);
            JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();
        }  
        
        
        
        
        
       /* objAgendamento.setId(txtID.getText());

        // fazendo a valida��o dos dados
        if ((txtID.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe valores para os campos");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new AgendamentoDAO();
            objDAO.deletar(objAgendamento);
            JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso! ");
        }

        carregarTable(null);

        // apaga os dados preenchidos nos campos de texto
        setClear();*/
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        objAgendamento = new Agendamento();
        objAgendamento.setNome(txtNome.getText());
        objAgendamento.setData(txtData.getText());

        // fazendo a valida��o dos dados
        if ((!txtNome.getText().isEmpty()) || (!txtData.getText().isEmpty())) {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            objDAO = new AgendamentoDAO();
            buscar = true;
            carregarTable(objAgendamento);
        }else{
            buscar = false;
            carregarTable(null);
        }

        // apaga os dados preenchidos nos campos de texto
        setClear();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    public void setClear() {
        txtID.setText(null);
        txtNome.setText(null);
        txtData.setText(null);
        txtHorario.setText(null);
        txtServico.setText(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendamentoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListagemAgendamento;
    private javax.swing.JButton tbnExit;
    private javax.swing.JButton tbnLimpar;
    private javax.swing.JButton tbnSalvar;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtServico;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/icone.png")));
    }
}

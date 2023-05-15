/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

import Conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.sql.*;
import Conexao.ModuloConexao;

/**
 *
 * @author EU
 */
public class Redefinir_User extends javax.swing.JInternalFrame {

    public static boolean cadastrouser;

    //Estas variaveis preparam a conexão e exibem os resultados na conexão
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Redefinir_User
     */
    public Redefinir_User() {
        initComponents();
        //conexão para puxar as informações do banco
        conexao = ModuloConexao.conector();
    }

    private void consultarFunc() {
        String sql = "select * from funcionarios where id_cpf_func=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPes_Func.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNome_Func.setText(rs.getString(2));
                txtNas_Func.setText(rs.getString(3));
                txtCpf_Func.setText(rs.getString(4));
                cboSex_Func.setSelectedItem(rs.getString(5));
                txtTel_Func.setText(rs.getString(6));
                txtEmail_Func.setText(rs.getString(7));
                txtCep_Func.setText(rs.getString(8));
                cboEst_Func.setSelectedItem(rs.getString(9));
                txtCid_Func.setText(rs.getString(10));
                txtBair_Func.setText(rs.getString(11));
                txtEnd_Func.setText(rs.getString(12));
                cboResi_Func.setSelectedItem(rs.getString(14));
                txtN_Resi_Func.setText(rs.getString(15));
            } else {
                JOptionPane.showMessageDialog(null, "funcionario não encontrado 0.o .");
                // limpar os campos após uma consulta invalida 
                txtNome_Func.setText(null);
                txtNas_Func.setText(null);
                txtCpf_Func.setText(null);
                cboSex_Func.setSelectedItem(null);
                txtTel_Func.setText(null);
                txtEmail_Func.setText(null);
                txtCep_Func.setText(null);
                cboEst_Func.setSelectedItem(null);
                txtCid_Func.setText(null);
                txtBair_Func.setText(null);
                txtEnd_Func.setText(null);
                cboResi_Func.setSelectedItem(null);
                txtN_Resi_Func.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterarFunc() {
        String sql = "update funcionarios set  id_cpf_func=?, nome_f=?, cpf_f=?, dt_nasc_f=?, genero_f=?, contato_f=?, email_f=?, cep_f=?, estado_f=?, cidade_f=?, bairro_f=?, endereco_f=?, imovel_f=?, num_casa_f=?  where id_cpf_func=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txtPes_Func.getText());
            pst.setString(2, txtNome_Func.getText());
            pst.setString(3, txtCpf_Func.getText());
            pst.setString(4, txtNas_Func.getText());
            pst.setString(5, cboSex_Func.getSelectedItem().toString());
            pst.setString(6, txtTel_Func.getText());
            pst.setString(7, txtEmail_Func.getText());
            pst.setString(8, txtCep_Func.getText());
            pst.setString(9, cboEst_Func.getSelectedItem().toString());
            pst.setString(10, txtCid_Func.getText());
            pst.setString(11, txtBair_Func.getText());
            pst.setString(12, txtEnd_Func.getText());
            pst.setString(13, cboResi_Func.getSelectedItem().toString());
            pst.setString(14, txtN_Resi_Func.getText());

            //Validação dos campos Obrigatórios
            if ((txtPes_Func.getText().isEmpty())
                    || (txtNome_Func.getText().isEmpty())
                    || (txtCpf_Func.getText().isEmpty())
                    || (txtNas_Func.getText().isEmpty())
                    || (txtTel_Func.getText().isEmpty())
                    || (txtEmail_Func.getText().isEmpty())
                    || (txtCep_Func.getText().isEmpty())
                    || (txtCid_Func.getText().isEmpty())
                    || (txtBair_Func.getText().isEmpty())
                    || (txtEnd_Func.getText().isEmpty())
                    || (txtN_Resi_Func.getText().isEmpty())) {
                //Menssagem caso falte preencher algum campo necessario
                JOptionPane.showMessageDialog(null, "Está faltando preencher algum campo obrigatório -_- .");
            } else {
                //codigo abaixo insere as informações no banco:
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "funcionario atualizado com sucesso °u° .");
                    // limpar os campos após uma consulta invalida 
                    txtNome_Func.setText(null);
                    txtNas_Func.setText(null);
                    txtCpf_Func.setText(null);
                    cboSex_Func.setSelectedItem(null);
                    txtTel_Func.setText(null);
                    txtEmail_Func.setText(null);
                    txtCep_Func.setText(null);
                    cboEst_Func.setSelectedItem(null);
                    txtCid_Func.setText(null);
                    txtBair_Func.setText(null);
                    txtEnd_Func.setText(null);
                     cboResi_Func.setSelectedItem(null);
                    txtN_Resi_Func.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel55 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        txtId_Func = new javax.swing.JTextField();
        txtNome_Func = new javax.swing.JTextField();
        txtCpf_Func = new javax.swing.JFormattedTextField();
        jLabel157 = new javax.swing.JLabel();
        txtNas_Func = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cboSex_Func = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtTel_Func = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        txtEnd_Func = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCep_Func = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        cboEst_Func = new javax.swing.JComboBox<>();
        txtBair_Func = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtEmail_Func = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCid_Func = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cboResi_Func = new javax.swing.JComboBox<>();
        txtN_Resi_Func = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        bttAtu_Func = new javax.swing.JButton();
        txtPes_Func = new javax.swing.JTextField();
        txtPesq_func = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        txtId_user_Func = new javax.swing.JTextField();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        txt_user = new javax.swing.JTextField();
        cbo_Tp_User = new javax.swing.JComboBox<>();
        jPanel58 = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        passSenha_user = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        passCont_Senha_user = new javax.swing.JPasswordField();
        txtPes_Func1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtPesq_func1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Redefinição de usuário");
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1210, 880));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));
        jPanel1.setLayout(null);

        jButton19.setBackground(new java.awt.Color(250, 233, 255));
        jButton19.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(0, 204, 255));
        jButton19.setText("Redefinir");
        jButton19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19);
        jButton19.setBounds(970, 10, 100, 30);

        jButton22.setBackground(new java.awt.Color(250, 233, 255));
        jButton22.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton22.setForeground(new java.awt.Color(0, 204, 255));
        jButton22.setText("Cadastro");
        jButton22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton22);
        jButton22.setBounds(870, 10, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 30, 1080, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Usuários"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton21.setBackground(new java.awt.Color(250, 233, 255));
        jButton21.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton21.setForeground(new java.awt.Color(0, 204, 255));
        jButton21.setText("Analizar");
        jButton21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(820, 140, 280, 600);

        jPanel55.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jPanel55.setLayout(null);

        jLabel155.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel155.setText("Nome completo:");
        jPanel55.add(jLabel155);
        jLabel155.setBounds(20, 220, 132, 23);

        jLabel156.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel156.setText("Id do funcionario:");
        jPanel55.add(jLabel156);
        jLabel156.setBounds(500, 220, 150, 23);
        jPanel55.add(txtId_Func);
        txtId_Func.setBounds(500, 250, 180, 30);
        jPanel55.add(txtNome_Func);
        txtNome_Func.setBounds(20, 250, 140, 32);

        try {
            txtCpf_Func.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel55.add(txtCpf_Func);
        txtCpf_Func.setBounds(20, 320, 140, 32);

        jLabel157.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel157.setText("Cpf:");
        jPanel55.add(jLabel157);
        jLabel157.setBounds(20, 290, 31, 23);

        try {
            txtNas_Func.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel55.add(txtNas_Func);
        txtNas_Func.setBounds(20, 400, 140, 32);

        jLabel21.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel21.setText("Nascimento:");
        jLabel21.setToolTipText("");
        jPanel55.add(jLabel21);
        jLabel21.setBounds(20, 360, 95, 34);

        jLabel22.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel22.setText("Gênero:");
        jPanel55.add(jLabel22);
        jLabel22.setBounds(20, 450, 64, 23);

        cboSex_Func.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboSex_Func.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "masculino", "femenino", "outros" }));
        cboSex_Func.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel55.add(cboSex_Func);
        cboSex_Func.setBounds(20, 480, 112, 28);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setText("Contato:");
        jLabel7.setToolTipText("");
        jPanel55.add(jLabel7);
        jLabel7.setBounds(180, 220, 67, 23);

        try {
            txtTel_Func.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel55.add(txtTel_Func);
        txtTel_Func.setBounds(180, 250, 140, 32);

        jLabel24.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel24.setText("Email:");
        jPanel55.add(jLabel24);
        jLabel24.setBounds(180, 290, 50, 23);
        jPanel55.add(txtEnd_Func);
        txtEnd_Func.setBounds(340, 400, 140, 32);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel9.setText("Cep:");
        jLabel9.setToolTipText("");
        jPanel55.add(jLabel9);
        jLabel9.setBounds(180, 360, 35, 23);

        try {
            txtCep_Func.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel55.add(txtCep_Func);
        txtCep_Func.setBounds(180, 400, 140, 32);

        jLabel23.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel23.setText("Estado:");
        jPanel55.add(jLabel23);
        jLabel23.setBounds(180, 450, 60, 23);

        cboEst_Func.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboEst_Func.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "Su", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel55.add(cboEst_Func);
        cboEst_Func.setBounds(180, 480, 100, 28);
        jPanel55.add(txtBair_Func);
        txtBair_Func.setBounds(340, 320, 140, 32);

        jLabel25.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel25.setText("Cidade:");
        jPanel55.add(jLabel25);
        jLabel25.setBounds(340, 220, 60, 23);
        jPanel55.add(txtEmail_Func);
        txtEmail_Func.setBounds(180, 320, 140, 32);

        jLabel26.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel26.setText(" Bairro:");
        jLabel26.setToolTipText("");
        jPanel55.add(jLabel26);
        jLabel26.setBounds(340, 290, 80, 23);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setText("Endereço:");
        jLabel8.setToolTipText("");
        jPanel55.add(jLabel8);
        jLabel8.setBounds(340, 360, 82, 23);
        jPanel55.add(txtCid_Func);
        txtCid_Func.setBounds(340, 250, 140, 32);

        jLabel27.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel27.setText("Residência:");
        jPanel55.add(jLabel27);
        jLabel27.setBounds(340, 450, 94, 23);

        cboResi_Func.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboResi_Func.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "casa", "apartamento" }));
        jPanel55.add(cboResi_Func);
        cboResi_Func.setBounds(340, 480, 133, 28);
        jPanel55.add(txtN_Resi_Func);
        txtN_Resi_Func.setBounds(500, 450, 40, 32);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("Nº:");
        jPanel55.add(jLabel28);
        jLabel28.setBounds(460, 450, 31, 22);

        jPanel56.setBackground(new java.awt.Color(51, 204, 255));
        jPanel56.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));

        jLabel159.setFont(new java.awt.Font("Bahnschrift", 1, 48)); // NOI18N
        jLabel159.setText("Redefinição de Usuário");

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel159)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel159))
        );

        jPanel55.add(jPanel56);
        jPanel56.setBounds(1, 23, 642, 72);

        jLabel1.setText("Obs. A ID é o CPF sem as pontuações.");
        jPanel55.add(jLabel1);
        jLabel1.setBounds(500, 280, 190, 14);

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));

        bttAtu_Func.setBackground(new java.awt.Color(250, 233, 255));
        bttAtu_Func.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        bttAtu_Func.setForeground(new java.awt.Color(0, 204, 255));
        bttAtu_Func.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/updates.png"))); // NOI18N
        bttAtu_Func.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        bttAtu_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAtu_FuncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(bttAtu_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(bttAtu_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel55.add(jPanel8);
        jPanel8.setBounds(640, 130, 96, 51);

        txtPes_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPes_FuncjTextField21ActionPerformed(evt);
            }
        });
        jPanel55.add(txtPes_Func);
        txtPes_Func.setBounds(110, 150, 160, 30);

        txtPesq_func.setBackground(new java.awt.Color(250, 233, 255));
        txtPesq_func.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtPesq_func.setForeground(new java.awt.Color(0, 204, 255));
        txtPesq_func.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/lupa 16.png"))); // NOI18N
        txtPesq_func.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        txtPesq_func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesq_funcActionPerformed(evt);
            }
        });
        jPanel55.add(txtPesq_func);
        txtPesq_func.setBounds(270, 150, 30, 30);

        jLabel39.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel39.setText("Funcionario:");
        jPanel55.add(jLabel39);
        jLabel39.setBounds(110, 120, 140, 30);

        jTabbedPane4.addTab("Funcionario", jPanel55);

        jPanel57.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jPanel57.setLayout(null);

        jLabel160.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel160.setText("Usuário:");
        jPanel57.add(jLabel160);
        jLabel160.setBounds(50, 220, 68, 23);

        jLabel162.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel162.setText("Senha:");
        jPanel57.add(jLabel162);
        jLabel162.setBounds(50, 320, 55, 23);

        jLabel163.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel163.setText("Contra senha");
        jPanel57.add(jLabel163);
        jLabel163.setBounds(380, 320, 109, 23);
        jPanel57.add(txtId_user_Func);
        txtId_user_Func.setBounds(380, 250, 233, 30);

        jButton53.setBackground(new java.awt.Color(250, 233, 255));
        jButton53.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton53.setForeground(new java.awt.Color(0, 204, 255));
        jButton53.setText("Cancelar");
        jButton53.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jPanel57.add(jButton53);
        jButton53.setBounds(570, 460, 98, 42);

        jButton54.setBackground(new java.awt.Color(250, 233, 255));
        jButton54.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton54.setForeground(new java.awt.Color(0, 204, 255));
        jButton54.setText("Concluir");
        jButton54.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        jPanel57.add(jButton54);
        jButton54.setBounds(460, 460, 98, 42);
        jPanel57.add(txt_user);
        txt_user.setBounds(50, 250, 233, 30);

        cbo_Tp_User.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADM", "COM" }));
        cbo_Tp_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Tp_UserActionPerformed(evt);
            }
        });
        jPanel57.add(cbo_Tp_User);
        cbo_Tp_User.setBounds(280, 250, 60, 30);

        jPanel58.setBackground(new java.awt.Color(51, 204, 255));
        jPanel58.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));

        jLabel164.setFont(new java.awt.Font("Bahnschrift", 1, 48)); // NOI18N
        jLabel164.setText("Cadastro de Usuário");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(jLabel164)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel164))
        );

        jPanel57.add(jPanel58);
        jPanel58.setBounds(1, 23, 677, 72);

        jLabel158.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel158.setText("Id do funcionario:");
        jPanel57.add(jLabel158);
        jLabel158.setBounds(380, 220, 150, 23);

        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Obs. A ID é o CPF sem as pontuações.");
        jPanel57.add(jLabel3);
        jLabel3.setBounds(380, 290, 190, 14);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/eye.png"))); // NOI18N
        jPanel57.add(jLabel4);
        jLabel4.setBounds(240, 360, 20, 16);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel57.add(jCheckBox1);
        jCheckBox1.setBounds(260, 360, 20, 20);

        passSenha_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passSenha_userActionPerformed(evt);
            }
        });
        jPanel57.add(passSenha_user);
        passSenha_user.setBounds(50, 350, 233, 35);

        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Obs.senha direcionado só para ADM.");
        jPanel57.add(jLabel6);
        jLabel6.setBounds(390, 390, 190, 14);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel57.add(jCheckBox3);
        jCheckBox3.setBounds(590, 360, 20, 20);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/eye.png"))); // NOI18N
        jPanel57.add(jLabel29);
        jLabel29.setBounds(570, 360, 20, 16);

        passCont_Senha_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passCont_Senha_userActionPerformed(evt);
            }
        });
        jPanel57.add(passCont_Senha_user);
        passCont_Senha_user.setBounds(380, 350, 230, 35);

        txtPes_Func1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPes_Func1jTextField21ActionPerformed(evt);
            }
        });
        jPanel57.add(txtPes_Func1);
        txtPes_Func1.setBounds(110, 150, 160, 30);

        jLabel40.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel40.setText("Usuário:");
        jPanel57.add(jLabel40);
        jLabel40.setBounds(110, 120, 94, 30);

        txtPesq_func1.setBackground(new java.awt.Color(250, 233, 255));
        txtPesq_func1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtPesq_func1.setForeground(new java.awt.Color(0, 204, 255));
        txtPesq_func1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/lupa 16.png"))); // NOI18N
        txtPesq_func1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        txtPesq_func1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesq_func1ActionPerformed(evt);
            }
        });
        jPanel57.add(txtPesq_func1);
        txtPesq_func1.setBounds(270, 150, 30, 30);

        jTabbedPane4.addTab("Usuário", jPanel57);

        getContentPane().add(jTabbedPane4);
        jTabbedPane4.setBounds(70, 120, 745, 620);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fundo-azul GG.jpg"))); // NOI18N
        jLabel10.setText(".");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 10, 1928, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton19jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19jButton10ActionPerformed

    private void jButton21jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21jButton12ActionPerformed
        // TODO add your handling code here:         

    }//GEN-LAST:event_jButton21jButton12ActionPerformed

    private void jButton22jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22jButton12ActionPerformed
        // aqui imprime a tela de configuração de administrador:
        this.dispose();
        Cadastro_User cadastrouser = new Cadastro_User();
        Menu.MenujDesktopPane1.add(cadastrouser);
        cadastrouser.setVisible(true);
    }//GEN-LAST:event_jButton22jButton12ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // chama o metodo adicionar:
    }//GEN-LAST:event_jButton54ActionPerformed

    private void cbo_Tp_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_Tp_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_Tp_UserActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // Mostrar ou ocultar senha ao ser digitada
        if (jCheckBox1.isSelected()) {
            passSenha_user.setEchoChar((char) 0);
        } else {
            passSenha_user.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void passSenha_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passSenha_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passSenha_userActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // Mostrar ou ocultar senha ao ser digitada
        if (jCheckBox3.isSelected()) {
            passCont_Senha_user.setEchoChar((char) 0);
        } else {
            passCont_Senha_user.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void passCont_Senha_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passCont_Senha_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passCont_Senha_userActionPerformed

    private void txtPesq_funcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesq_funcActionPerformed
        // Chamando o metodo consultar:
        consultarFunc();
    }//GEN-LAST:event_txtPesq_funcActionPerformed

    private void txtPes_FuncjTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPes_FuncjTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPes_FuncjTextField21ActionPerformed

    private void bttAtu_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAtu_FuncActionPerformed
        // chama o metodo alterar:
        alterarFunc();
    }//GEN-LAST:event_bttAtu_FuncActionPerformed

    private void txtPes_Func1jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPes_Func1jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPes_Func1jTextField21ActionPerformed

    private void txtPesq_func1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesq_func1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesq_func1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttAtu_Func;
    private javax.swing.JComboBox<String> cboEst_Func;
    private javax.swing.JComboBox<String> cboResi_Func;
    private javax.swing.JComboBox<String> cboSex_Func;
    private javax.swing.JComboBox<String> cbo_Tp_User;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JPasswordField passCont_Senha_user;
    private javax.swing.JPasswordField passSenha_user;
    private javax.swing.JTextField txtBair_Func;
    private javax.swing.JFormattedTextField txtCep_Func;
    private javax.swing.JTextField txtCid_Func;
    private javax.swing.JFormattedTextField txtCpf_Func;
    private javax.swing.JTextField txtEmail_Func;
    private javax.swing.JTextField txtEnd_Func;
    private javax.swing.JTextField txtId_Func;
    private javax.swing.JTextField txtId_user_Func;
    private javax.swing.JTextField txtN_Resi_Func;
    private javax.swing.JFormattedTextField txtNas_Func;
    private javax.swing.JTextField txtNome_Func;
    private javax.swing.JTextField txtPes_Func;
    private javax.swing.JTextField txtPes_Func1;
    private javax.swing.JButton txtPesq_func;
    private javax.swing.JButton txtPesq_func1;
    private javax.swing.JFormattedTextField txtTel_Func;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}


import java.sql.*;
import Conexao.ModuloConexao;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author EU
 */
public class Cliente extends javax.swing.JInternalFrame {

    public static boolean filapedido;
    public static boolean estoque;
    public static boolean cadastrocliente;
    public static boolean clientes;

    //Estas variaveis preparam a conexão e exibem os resultados na conexão
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        //conexão para puxar as informações do banco
        conexao = ModuloConexao.conector();
    }
    
private void consultar() {
        String sql = "select * from clientes where id_cpf_client=?";
        try {
            pst = conexao.prepareStatement(sql);
         //   pst.setString(1, txtPes_Cliente.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNome_Cliente.setText(rs.getString(2));
                txtCpf_Cliente.setText(rs.getString(3));
                txtNas_Cliente1.setText(rs.getString(4));
                cboSex_Cliente.setSelectedItem(rs.getString(5));
                txtTel_Cliente.setText(rs.getString(6));
                txtEmail_Cliente.setText(rs.getString(7));
                txtCep_Cliente.setText(rs.getString(8));
                cboEst_Cliente.setSelectedItem(rs.getString(9));
                txtCid_Cliente.setText(rs.getString(10));
                txtBair_Cliente.setText(rs.getString(11));
                txtEnd_Cliente.setText(rs.getString(12));
                txtComp_Cliente.setText(rs.getString(13));
                cboResi_Cliente.setSelectedItem(rs.getString(14));
                txtN_Resi_Cliente.setText(rs.getString(15));

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado 0.o .");
                // limpar os campos após uma consulta invalida 
                txtNome_Cliente.setText(null);
                txtCpf_Cliente.setText(null);
                txtNas_Cliente1.setText(null);
                cboSex_Cliente.setSelectedItem(null);
                txtTel_Cliente.setText(null);
                txtEmail_Cliente.setText(null);
                txtCep_Cliente.setText(null);
                cboEst_Cliente.setSelectedItem(null);
                txtCid_Cliente.setText(null);
                txtBair_Cliente.setText(null);
                txtEnd_Cliente.setText(null);
                txtComp_Cliente.setText(null);
                cboResi_Cliente.setSelectedItem(null);
                txtN_Resi_Cliente.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showInputDialog(null, e);
        }
    }

private void alterar() {
        String sql = "update clientes set  nome_c=?, cpf_c=?, dt_nasc_c=?, genero_c=?, contato_c=?, email_c=?, cep_c=?, estado_c=?, cidade_c=?, bairro_c=?, endereco_c=?, complemento_c=?, imovel_c=?, num_casa_c=? where id_cpf_client=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txtNome_Cliente.getText());
            pst.setString(2, txtCpf_Cliente.getText());
            pst.setString(3, txtNas_Cliente1.getText());
            pst.setString(4, cboSex_Cliente.getSelectedItem().toString());
            pst.setString(5, txtTel_Cliente.getText());
            pst.setString(6, txtEmail_Cliente.getText());
            pst.setString(7, txtCep_Cliente.getText());
            pst.setString(8, cboEst_Cliente.getSelectedItem().toString());
            pst.setString(9, txtCid_Cliente.getText());
            pst.setString(10, txtBair_Cliente.getText());
            pst.setString(11, txtEnd_Cliente.getText());
            pst.setString(12, txtComp_Cliente.getText());
            pst.setString(13, cboResi_Cliente.getSelectedItem().toString());
            pst.setString(14, txtN_Resi_Cliente.getText());
            pst.setString(15, txtPes_Cliente.getText());
            //Validação dos campos Obrigatórios
            if ((txtNome_Cliente.getText().isEmpty())
                    || (txtCpf_Cliente.getText().isEmpty())
                    || (txtNas_Cliente1.getText().isEmpty())
                    || (txtTel_Cliente.getText().isEmpty())
                    || (txtEmail_Cliente.getText().isEmpty())
                    || (txtCep_Cliente.getText().isEmpty())
                    || (txtCid_Cliente.getText().isEmpty())
                    || (txtBair_Cliente.getText().isEmpty())
                    || (txtEnd_Cliente.getText().isEmpty())
                    || (txtComp_Cliente.getText().isEmpty())
                    || (txtN_Resi_Cliente.getText().isEmpty())
                    || (txtPes_Cliente.getText().isEmpty())) {
                //Menssagem caso falte preencher algum campo necessario
                JOptionPane.showMessageDialog(null, "Está faltando preencher algum campo obrigatório -_- .");
            } else {
                //codigo abaixo insere as informações no banco:
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso °u° .");
                    txtNome_Cliente.setText(null);
                    txtCpf_Cliente.setText(null);
                    cboSex_Cliente.setSelectedItem(null);
                    txtTel_Cliente.setText(null);
                    txtEmail_Cliente.setText(null);
                    txtCep_Cliente.setText(null);
                    cboEst_Cliente.setSelectedItem(null);
                    txtCid_Cliente.setText(null);
                    txtBair_Cliente.setText(null);
                    txtEnd_Cliente.setText(null);
                    txtComp_Cliente.setText(null);
                    cboResi_Cliente.setSelectedItem(null);
                    txtN_Resi_Cliente.setText(null);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNome_Cliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtBair_Cliente = new javax.swing.JTextField();
        txtCid_Cliente = new javax.swing.JTextField();
        txtN_Resi_Cliente = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPes_Cliente = new javax.swing.JTextField();
        bttPes_Cliente = new javax.swing.JButton();
        cboResi_Cliente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComp_Cliente = new javax.swing.JTextArea();
        cboEst_Cliente = new javax.swing.JComboBox<>();
        bttNew_Cliente = new javax.swing.JButton();
        txtCep_Cliente = new javax.swing.JFormattedTextField();
        txtEmail_Cliente = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTel_Cliente = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCpf_Cliente = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        cboSex_Cliente = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bttRel_Cliente = new javax.swing.JButton();
        txtEnd_Cliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNas_Cliente1 = new javax.swing.JFormattedTextField();
        jPanel8 = new javax.swing.JPanel();
        bttRel_Cliente2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cliente");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1210, 880));
        getContentPane().setLayout(null);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 204, 255), new java.awt.Color(51, 204, 255), new java.awt.Color(51, 204, 255), new java.awt.Color(51, 204, 255)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Nome completo:");
        jLabel5.setToolTipText("");

        jLabel6.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Cep:");
        jLabel9.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("   Bairro:");
        jLabel11.setToolTipText("");

        txtNome_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome_ClienteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Residência:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Nº:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Cidade:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Estado:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Complementos:");

        txtBair_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBair_ClienteActionPerformed(evt);
            }
        });

        txtCid_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCid_ClienteActionPerformed(evt);
            }
        });

        txtN_Resi_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtN_Resi_ClienteActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel3.setText("   Código Do Cliente:");
        jLabel3.setToolTipText("");

        txtPes_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPes_ClienteActionPerformed(evt);
            }
        });

        bttPes_Cliente.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        bttPes_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/lupa 16.png"))); // NOI18N
        bttPes_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttPes_ClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPes_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bttPes_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPes_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bttPes_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cboResi_Cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboResi_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "casa", "apartamento" }));
        cboResi_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboResi_ClienteActionPerformed(evt);
            }
        });

        txtComp_Cliente.setColumns(20);
        txtComp_Cliente.setRows(5);
        jScrollPane1.setViewportView(txtComp_Cliente);

        cboEst_Cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboEst_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "Su", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cboEst_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEst_ClienteActionPerformed(evt);
            }
        });

        bttNew_Cliente.setBackground(new java.awt.Color(250, 233, 255));
        bttNew_Cliente.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        bttNew_Cliente.setForeground(new java.awt.Color(0, 204, 255));
        bttNew_Cliente.setText("Novo Cliente ");
        bttNew_Cliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        bttNew_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttNew_ClienteActionPerformed(evt);
            }
        });

        try {
            txtCep_Cliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCep_ClienteActionPerformed(evt);
            }
        });

        txtEmail_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail_ClienteActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Email:");

        try {
            txtTel_Cliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Contato:");
        jLabel7.setToolTipText("");

        try {
            txtCpf_Cliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("Cpf:");
        jLabel21.setToolTipText("");

        cboSex_Cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboSex_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "masculino", "femenino", "outros" }));
        cboSex_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboSex_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSex_ClienteActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Gênero:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel10.setText("Nascimento:");
        jLabel10.setToolTipText("");

        bttRel_Cliente.setBackground(new java.awt.Color(250, 233, 255));
        bttRel_Cliente.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        bttRel_Cliente.setForeground(new java.awt.Color(0, 204, 255));
        bttRel_Cliente.setText("Relatórios");
        bttRel_Cliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        bttRel_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRel_ClienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Endereço:");
        jLabel8.setToolTipText("");

        try {
            txtNas_Cliente1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));

        bttRel_Cliente2.setBackground(new java.awt.Color(250, 233, 255));
        bttRel_Cliente2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        bttRel_Cliente2.setForeground(new java.awt.Color(0, 204, 255));
        bttRel_Cliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/updates.png"))); // NOI18N
        bttRel_Cliente2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        bttRel_Cliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRel_Cliente2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(bttRel_Cliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(bttRel_Cliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel19))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(54, 54, 54)
                                                        .addComponent(bttNew_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(bttRel_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel14)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cboResi_Cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtEnd_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(13, 13, 13)
                                                        .addComponent(jLabel15)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtN_Resi_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCep_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtBair_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCid_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cboEst_Cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(jLabel5))
                                .addGap(131, 131, 131))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtTel_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel24)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtEmail_Cliente))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNas_Cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cboSex_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jLabel21)
                                            .addGap(0, 0, 0)
                                            .addComponent(txtCpf_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtNome_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(txtCpf_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(cboSex_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNas_Cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(txtEmail_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTel_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtBair_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtCid_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cboEst_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEnd_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtN_Resi_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cboResi_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bttNew_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttRel_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(316, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(489, 489, 489))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(190, 240, 1040, 830);

        jPanel2.setForeground(new java.awt.Color(0, 204, 255));
        jPanel2.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 204, 255));
        jLabel20.setText("Clientes");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(30, 110, 93, 30);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Estoque");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 390, 91, 30);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 204, 255));
        jLabel12.setText("Pedido");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(28, 250, 90, 30);

        jButton42.setBackground(new java.awt.Color(250, 233, 255));
        jButton42.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton42.setForeground(new java.awt.Color(0, 204, 255));
        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/clientes 64.png"))); // NOI18N
        jButton42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton42);
        jButton42.setBounds(10, 10, 130, 130);

        jButton43.setBackground(new java.awt.Color(250, 233, 255));
        jButton43.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton43.setForeground(new java.awt.Color(0, 204, 255));
        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/estoque 64.png"))); // NOI18N
        jButton43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton43);
        jButton43.setBounds(10, 290, 130, 130);

        jButton44.setBackground(new java.awt.Color(250, 233, 255));
        jButton44.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton44.setForeground(new java.awt.Color(0, 204, 255));
        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/pedido 64.png"))); // NOI18N
        jButton44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 255), 1, true));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton44);
        jButton44.setBounds(10, 150, 130, 130);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 240, 150, 830);

        jLabel40.setFont(new java.awt.Font("Bahnschrift", 1, 70)); // NOI18N
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cliente.png"))); // NOI18N
        jLabel40.setText("  Cliente ");
        getContentPane().add(jLabel40);
        jLabel40.setBounds(220, 80, 670, 130);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 90, 650, 100);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logo manasysF.png"))); // NOI18N
        getContentPane().add(jLabel41);
        jLabel41.setBounds(1360, 580, 480, 470);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fundo-azul GG.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1910, 1070);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBair_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBair_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBair_ClienteActionPerformed

    private void txtCid_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCid_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCid_ClienteActionPerformed

    private void txtN_Resi_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtN_Resi_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtN_Resi_ClienteActionPerformed

    private void txtPes_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPes_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPes_ClienteActionPerformed

    private void cboResi_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboResi_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboResi_ClienteActionPerformed

    private void bttNew_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttNew_ClienteActionPerformed
        // botão que leva a tela de cadastro de cliente:
        this.dispose();
        Cadastro_de_Cliente cadastrocliente = new Cadastro_de_Cliente();
        Menu.MenujDesktopPane1.add(cadastrocliente);
        cadastrocliente.setVisible(true);
    }//GEN-LAST:event_bttNew_ClienteActionPerformed

    private void txtCep_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCep_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCep_ClienteActionPerformed

    private void txtEmail_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail_ClienteActionPerformed

    private void cboSex_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSex_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSex_ClienteActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        //Botão que leva para tela de pedidos
        Fila_de_Pedido filapedido = new Fila_de_Pedido();
        Menu.MenujDesktopPane1.add(filapedido);
        filapedido.setVisible(true);

    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        //Botão que leva para tela de estoque
        Estoque estoque = new Estoque();
        Menu.MenujDesktopPane1.add(estoque);
        estoque.setVisible(true);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void bttRel_Cliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRel_Cliente2ActionPerformed
        // chama o metodo alterar:

    }//GEN-LAST:event_bttRel_Cliente2ActionPerformed

    private void txtNome_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome_ClienteActionPerformed

    private void cboEst_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEst_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEst_ClienteActionPerformed

    private void bttPes_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttPes_ClienteActionPerformed
        // Chamando o metodo consultar:
        consultar();
    }//GEN-LAST:event_bttPes_ClienteActionPerformed

    private void bttRel_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRel_ClienteActionPerformed
        //Botão que leva para tela de estoque

        this.dispose();
        Clientes clientes = new Clientes();
        Menu.MenujDesktopPane1.add(clientes);
        clientes.setVisible(true);
    }//GEN-LAST:event_bttRel_ClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttNew_Cliente;
    private javax.swing.JButton bttPes_Cliente;
    private javax.swing.JButton bttRel_Cliente;
    private javax.swing.JButton bttRel_Cliente2;
    private javax.swing.JComboBox<String> cboEst_Cliente;
    private javax.swing.JComboBox<String> cboResi_Cliente;
    private javax.swing.JComboBox<String> cboSex_Cliente;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBair_Cliente;
    private javax.swing.JFormattedTextField txtCep_Cliente;
    private javax.swing.JTextField txtCid_Cliente;
    private javax.swing.JTextArea txtComp_Cliente;
    private javax.swing.JFormattedTextField txtCpf_Cliente;
    private javax.swing.JTextField txtEmail_Cliente;
    private javax.swing.JTextField txtEnd_Cliente;
    private javax.swing.JTextField txtN_Resi_Cliente;
    private javax.swing.JFormattedTextField txtNas_Cliente1;
    private javax.swing.JTextField txtNome_Cliente;
    private javax.swing.JTextField txtPes_Cliente;
    private javax.swing.JFormattedTextField txtTel_Cliente;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.sql.*;

/**
 *
 * @author EU
 */
public class ModuloConexao {

    //metodo de conexão com o banco 
    public static Connection conector() {
        java.sql.Connection conexao = null;
        //está linha chama o driver
        String driver = "com.mysql.jdbc.Driver";
        //Armazenagem
        String url = "jdbc:mysql://localhost:3306/caprichosa_db";
        String user = "root";
        String password = "S3nh@";
        //conexão do banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("banco conectado com sucesso °u° ");
            return conexao;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a conexão com o banco 0.o");
            return null;
        }
    }

}

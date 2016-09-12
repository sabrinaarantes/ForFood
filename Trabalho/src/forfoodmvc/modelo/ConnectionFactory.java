package forfoodmvc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();

    public static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/forfood";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    private ConnectionFactory() {
        try {
            //registra o driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null ;
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERRO: erro na conexão com o banco  de dados");
        }
        return connection ;
    }
    
    
    public static Connection getConnection(){
        return instance.createConnection();
    }
}


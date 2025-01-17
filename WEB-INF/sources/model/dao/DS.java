package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DS {

    private final Properties p;
    private static final Logger logger = Logger.getLogger(DS.class.getName());

    public DS() {
        p = new Properties();
        loadProperties("../webapps/pizzalandapi/WEB-INF/ressources/config.conf");
    }

    public void loadProperties(String path) {
        try (FileInputStream input = new FileInputStream(new File(path))) {
            p.load(input);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        String url = p.getProperty("url");
        String nom = p.getProperty("login");
        String mdp = p.getProperty("password");

        try {
            Class.forName(p.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            logger.warning(e.getMessage());
        }

        return DriverManager.getConnection(url, nom, mdp);
    }

}

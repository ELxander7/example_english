package ru.kpfu.itis.oris.armanov.example_english.config;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class PostgreSQLDS {

    private static DataSource ds;

    static {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432); // Порт по умолчанию для PostgreSQL
        dataSource.setDatabaseName("example_english_db");
        dataSource.setUser("postgres"); // Измените на ваше имя пользователя
        dataSource.setPassword("mar83@ryash16");  // Измените на ваш пароль
        // Настройки, специфичные для PostgreSQL
        ds = dataSource;
    }

    private PostgreSQLDS() { }

    public static DataSource getDs() {
        return ds;
    }
}

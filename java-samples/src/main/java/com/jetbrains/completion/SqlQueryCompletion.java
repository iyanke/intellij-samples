package com.jetbrains.completion;

import java.sql.Connection;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class SqlQueryCompletion {
    public void query(Connection connection) {
        try {
            //Configure data source, then edit query with schema completion
            connection.prepareCall("SELECT * FROM customer WHERE customer.first_name LIKE 'J%'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
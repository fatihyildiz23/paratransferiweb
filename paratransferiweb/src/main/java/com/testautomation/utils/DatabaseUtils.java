package com.testautomation.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {
    
    public static String executeQuery(String query) {
        String result = "";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            if (rs.next()) {
                result = rs.getString(1);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("SQL sorgusu çalıştırılırken hata: " + e.getMessage());
        }
        return result;
    }
    
    private static Connection getConnection() {
        // Veritabanı bağlantı kodları
        return null; // Kendi bağlantı kodlarınızı ekleyin
    }
} 
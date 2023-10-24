package com.example.travelappoctober2023.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQuery {

    // Les informations de connexion à la base de données PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/nom_de_votre_base_de_donnees";
    private static final String UTILISATEUR = "votre_utilisateur";
    private static final String MOT_DE_PASSE = "votre_mot_de_passe";

    public static void main(String[] args) {
        // Charger le pilote JDBC PostgreSQL
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote PostgreSQL introuvable. Assurez-vous d'avoir ajouté le pilote JDBC à votre projet.");
            e.printStackTrace();
            return;
        }

        // Établir la connexion à la base de données
        try (Connection connection = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE)) {
            System.out.println("Connexion à la base de données établie.");

            // Exécuter la requête SQL
            String sql = "SELECT * FROM nom_de_votre_table";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                // Traiter les résultats de la requête
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    // Faites quelque chose avec les résultats
                    System.out.println("ID : " + id + ", Nom : " + nom);
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de l'exécution de la requête.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données.");
            e.printStackTrace();
        }
    }
}



package com.restoran.repository;

import com.restoran.config.Database;
import com.restoran.entities.Pesanan; // Import Pesanan entity

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PesananRepositoryDbImpl implements PesananRepository {
    private final Database database;

    public PesananRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public Pesanan[] getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM pesanan"; // Changed to the appropriate table name
        List<Pesanan> pesananList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pesanan pesanan = new Pesanan();
                Integer id = resultSet.getInt("id"); // Use column name for better readability
                String nama = resultSet.getString("nama");
                String item = resultSet.getString("item");
                int kuantitas = resultSet.getInt("kuantitas");
                String status = resultSet.getString("status");

                pesanan.setId(id);
                pesanan.setNama(nama);
                pesanan.setItem(item);
                pesanan.setKuantitas(kuantitas);
                pesanan.setStatus(status);
                pesananList.add(pesanan);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pesananList.toArray(Pesanan[]::new);
    }

    @Override
    public void add(Pesanan pesanan) {
        Connection connection = database.getConnection();
        String sqlStatement = "INSERT INTO pesanan(nama, item, kuantitas, status) VALUES(?, ?, ?, ?)"; // Fixed SQL to match columns

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesanan.getNama());
            preparedStatement.setString(2, pesanan.getItem());
            preparedStatement.setInt(3, pesanan.getKuantitas());
            preparedStatement.setString(4, pesanan.getStatus());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Insert Successful!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Integer getDbId(final Integer number) {
        Pesanan[] pesananList = getAll();
        Long countElement = Arrays.stream(pesananList).filter(Objects::nonNull).count();

        if (countElement.intValue() == 0) {
            return null;
        }
        return pesananList[number - 1].getId();
    }

    @Override
    public Boolean remove(final Integer number) {
        String sqlStatement = "DELETE FROM pesanan WHERE id = ?"; // Changed to the appropriate table name
        Connection connection = database.getConnection();
        var dbId = getDbId(number);
        if (dbId == null) {
            return false;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, dbId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Delete Successful!");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean edit(final Pesanan pesanan) {
        String sqlStatement = "UPDATE pesanan SET nama = ?, item = ?, kuantitas = ?, status = ? WHERE id = ?"; // Changed to the appropriate table name
        Connection connection = database.getConnection();
        var dbId = getDbId(pesanan.getId());
        if (dbId == null) {
            return false;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesanan.getNama());
            preparedStatement.setString(2, pesanan.getItem());
            preparedStatement.setInt(3, pesanan.getKuantitas());
            preparedStatement.setString(4, pesanan.getStatus());
            preparedStatement.setInt(5, dbId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Update Successful!");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void tambahPesanan(Pesanan pesanan) {

    }

    @Override
    public List<Pesanan> lihatSemuaPesanan() {
        return List.of();
    }

    @Override
    public void hapusPesanan(int index) {

    }

    @Override
    public void updatePesanan(int index, Pesanan pesanan) {

    }
}
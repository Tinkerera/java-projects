package BankingApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AccountDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/banking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void addAccount(Account account) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO account (account_id, account_type, balance, name) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, account.getAccountId());
            statement.setString(2, account.getAccountType());
            statement.setDouble(3, account.getBalance());
            statement.setString(4, account.getAccountName());
            statement.executeUpdate();
            System.out.println("Hesap başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getLastAccountId() {
        int lastAccountId = 0;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT MAX(account_id) AS last_id FROM account";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lastAccountId = resultSet.getInt("last_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastAccountId;
    }

    // Yeni bir kullanıcı için bir sonraki ID'yi oluşturan fonksiyon
    public static int getNextCustomerId() {
        // Son hesap ID'sini al
        int lastAccountId = getLastAccountId();
        // Bir sonraki kullanıcı ID'sini oluştur
        int nextCustomerId = lastAccountId + 1;
        return nextCustomerId;
    }
    public static Account findAccountByNumber(int accountNumber) {
        Account account = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM account WHERE account_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int accountId = resultSet.getInt("account_id");
                String accountType = resultSet.getString("account_type");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                account = new Account(accountId, accountType, balance, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    // Hesabın bakiyesini artırma ve veritabanını güncelleme
    public static void depositToAccount(int accountNumber, double depositAmount) {
        // Hesabı bul
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                // Bakiyeyi artır
                double newBalance = account.getBalance() + depositAmount;

                // Bakiyeyi güncelle
                String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDouble(1, newBalance);
                statement.setInt(2, account.getAccountId());
                statement.executeUpdate();

                // Güncellenmiş bakiyeyi göster
                System.out.println("Yeni bakiye: " + newBalance);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Hesap bulunamadı.");
        }
    }

    // Hesabın bakiyesini azaltma ve veritabanını güncelleme
    public static void withdrawFromAccount(int accountNumber, double withdrawAmount) {
        // Hesabı bul
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                // Bakiyeyi azalt
                double newBalance = account.getBalance() - withdrawAmount;
                if (newBalance >= 0) {
                    // Bakiyeyi güncelle
                    String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setDouble(1, newBalance);
                    statement.setInt(2, account.getAccountId());
                    statement.executeUpdate();

                    // Güncellenmiş bakiyeyi göster
                    System.out.println("Yeni bakiye: " + newBalance);
                } else {
                    System.out.println("Yetersiz bakiye.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Hesap bulunamadı.");
        }
    }
    public static void checkBalance(int accountNumber) {
        AccountDAO accountDAO = new AccountDAO();
        Account account = accountDAO.findAccountByNumber(accountNumber);
        if (account != null) {
            System.out.println("Bakiye: " + account.getBalance());
        } else {
            System.out.println("Hesap bulunamadı.");
        }
    }

}

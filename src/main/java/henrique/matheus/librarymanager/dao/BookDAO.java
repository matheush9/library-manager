package henrique.matheus.librarymanager.dao;

import henrique.matheus.librarymanager.dbconnection.DBConnectionManager;
import henrique.matheus.librarymanager.model.Book;

import java.sql.*;
import java.time.ZoneId;
import java.util.UUID;

public class BookDAO {

    public Book GetBook(String id) {
        Connection conn = DBConnectionManager.getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM BOOK B WHERE B.ID = ?");
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                rs.next();

                Book book = new Book();
                book.name = rs.getString("name");
                book.dateTimeReleased = rs.getTimestamp("datetimereleased").toInstant().atZone(ZoneId.systemDefault());
                book.pages = rs.getInt("pages");

                ps.close();
                return book;
            } catch (SQLException e) {
                System.out.printf("Error while getting book: %s", e.getMessage());
            }
        }
        return null;
    }

    public Boolean AddBook(Book book) {
        Connection conn = DBConnectionManager.getConnection();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM BOOK",
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = pstmt.executeQuery();

                rs.moveToInsertRow();
                rs.updateString("id", UUID.randomUUID().toString());
                rs.updateString("name", book.name);
                rs.updateTimestamp("datetimereleased", Timestamp.valueOf(book.dateTimeReleased.toLocalDateTime()));
                rs.updateInt("pages", book.pages);
                rs.insertRow();
                rs.moveToCurrentRow();

                Boolean rowInserted = rs.rowInserted();
                pstmt.close();

                return rowInserted;
            } catch (SQLException e) {
                System.out.printf("Error while inserting book: %s", e.getMessage());
            }
        }
        return null;
    }

    public Boolean DeleteBook(String id) {
        Connection conn = DBConnectionManager.getConnection();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT * FROM BOOK B WHERE B.ID = ?",
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                pstmt.setString(1, id);

                ResultSet rs = pstmt.executeQuery();
                if (!rs.next()) {
                    rs.close();
                    return false;
                }

                rs.deleteRow();
                rs.beforeFirst();
                Boolean rowDeleted = rs.rowDeleted();
                rs.close();
                return rowDeleted;
            } catch (SQLException e) {
                System.out.printf("Error while deleting book: %s", e.getMessage());
            }
        }
        return null;
    }

    public Boolean UpdateBook(String id, Book book){
        Connection conn = DBConnectionManager.getConnection();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT * FROM BOOK B WHERE B.ID = ?",
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                pstmt.setString(1, id);

                ResultSet rs = pstmt.executeQuery();
                if (!rs.last()) {
                    return false;
                }

                rs.updateString("name", book.name);
                rs.updateTimestamp("datetimereleased", Timestamp.valueOf(book.dateTimeReleased.toLocalDateTime()));
                rs.updateInt("pages", book.pages);
                rs.updateRow();

                Boolean rowUpdated = rs.rowUpdated();
                rs.close();
                return rowUpdated;
            } catch (SQLException e) {
                System.out.printf("Error while updating book: %s", e.getMessage());
            }
        }
        return null;
    }
}

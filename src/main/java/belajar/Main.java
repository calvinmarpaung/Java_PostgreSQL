package belajar;

import java.sql.Connection;

public class Main{
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        Connection con = db.connect_to_db("db", "postgres", "123456789");
        //create table inside the database
        //db.createTable(con, "employee");

        //insert data in table employee
        //db.insert_row(con, "employee", "Calvin", "Medan");
        //db.insert_row(con, "employee", "Andreas", "Jakarta");
        //db.insert_row(con, "employee", "Josua", "Yogyakarta");

        //update name
        //db.update_name(con, "employee", "Calvin", "Marpaung");

        //search by name
        //db.search_byName(con, "employee", "Marpaung");

        //read data
        //db.read_data(con, "employee");

        //delete data
        //db.delete_row_by_name(con, "employee", "Marpaung");

        //delete table
        db.deleteTable(con, "employee");
    }
}

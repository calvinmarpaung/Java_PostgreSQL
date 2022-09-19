package belajar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect_to_db(String db, String user, String pass){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ db, user, pass);
            if(con!=null){
                System.out.println("Connection success");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e){
            System.out.println(e);
        } return con;
    }

    public void createTable(Connection con, String table_name){
        Statement statement;
            try{
                String query = "create table " + table_name + "(empid SERIAL,name varchar(200),address varchar(200),primary key(empid));";
                statement = con.createStatement();
                statement.executeUpdate(query);
                System.out.println("Table created successfully");
            } catch(Exception e){
                System.out.println(e);
            }
        }

        public void insert_row(Connection con,String table_name, String name, String address){
            Statement statement;
            try{
                String query = String.format("insert into %s(name,address) values ('%s', '%s');",table_name, name, address );
                statement = con.createStatement();
                statement.executeUpdate(query);
                System.out.println("Successfully insert row");
            } catch (Exception e){
                System.out.println(e);
            }
        }

        public void read_data(Connection con,String table_name){
            Statement statement;
            ResultSet rs;
            try{
                String query = String.format("select * from %s", table_name );
                statement = con.createStatement();
                rs = statement.executeQuery(query);
                while(rs.next()){
                    System.out.print(rs.getString("empid")+ " ");
                    System.out.print(rs.getString("name")+ " ");
                    System.out.println(rs.getString("address")+ " ");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }
        public void update_name(Connection con, String table_name, String old_name, String new_name){
            Statement statement;
            try{
                String query = String.format("update %s set name='%s' where name='%s' ",table_name, new_name, old_name);
                statement = con.createStatement();
                statement.executeUpdate(query);
                System.out.println("Successfully update name from " + old_name + "to " + new_name);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        public void search_byName(Connection con, String table_name, String name){
            Statement statement;
            ResultSet rs = null;

            try{
                String query = String.format("select * from %s where name='%s'", table_name, name);
                statement = con.createStatement();
                rs = statement.executeQuery(query);
                while(rs.next()){
                    System.out.print(rs.getString("empid")+ " ");
                    System.out.print(rs.getString("name")+ " ");
                    System.out.println(rs.getString("address")+ " ");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }

        public void delete_row_by_name(Connection con, String table_name, String name){
            Statement statement;
            try{
                String query = String.format("delete from '%s' where name='%s'", table_name, name);
                statement = con.createStatement();
                statement.executeUpdate(query);
                System.out.println("Data deleted");
            } catch (Exception e){
                System.out.println(e);
            }
        }

        public void deleteTable(Connection con, String table_name){
        Statement statement;
        try{
            String query = String.format("drop table %s",table_name);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted");
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }


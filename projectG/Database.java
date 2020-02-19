/**
 * Required packages to be imported
 */

import java.sql.*;

/**
 *
 */
public class Database {

    String url;
    String uname;
    String pass;

    Connection con;
    Statement st;
    PreparedStatement pst;
    ResultSet data;

    public Database(){
        url = "jdbc:mysql://remotemysql.com:3306/LtR8HkXbTo";
        uname = "LtR8HkXbTo";
        pass = "0TuZ7o8Uyx";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,uname,pass);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String insertObservatory(Observatory o) throws SQLException {

        String query = "INSERT INTO observatories (observatoryName, countryName, areaCovered, yearStarted) " +
                "VALUES (?, ?, ?, ?)";
        pst = con.prepareStatement(query);

        pst.setString(1, o.getObservatoryName());
        pst.setString(2, o.getCountryName());
        pst.setInt(3, o.getAreaCovered());
        pst.setInt(4, o.getYearStarted());

        int count = pst.executeUpdate();

        return count + " number of rows affected";
    }

    public void initialLoad() throws SQLException{

        String query = "SELECT * FROM observatories";
        st = con.createStatement();
        data = st.executeQuery(query);

        while(data.next()){
            Observatory o = new Observatory(data.getString(2), data.getString(3), data.getInt(4),
                    data.getInt(5));
        }

    }

    public String insertGalamsey(Galamsey g) throws SQLException{

        String query = "INSERT INTO galamseys(vegColor, colorValue, latitude, longitude, yearRecorded, observatoryName)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        pst = con.prepareStatement(query);

        pst.setString(1, g.getVegColor().toString());
        pst.setInt(2, g.getColourValue());
        pst.setDouble(3, g.getPosition().getLatitude());
        pst.setDouble(4, g.getPosition().getLongitude());
        pst.setInt(5, g.getYearOfEevent());
        pst.setString(6, g.getObservatory().getObservatoryName());

        int count = pst.executeUpdate();
        return count + " number of rows affected";

    }

    public void loadGalamseys() throws SQLException{

        String query = "SELECT * FROM galamseys";
        st = con.createStatement();
        data = st.executeQuery(query);

        while(data.next()){
            Galamsey g = new Galamsey(Galamsey.colour.valueOf(data.getString(2).toLowerCase()), data.getInt(3),
                    new Position(data.getDouble(4), data.getDouble(5)), data.getInt(6));


            for (Observatory o:
                 Monitoring.observatories) {
                if(data.getString(7).equals(o.getObservatoryName())){
                    o.addToEvents(g);
                }
            }
        }
    }

    public ResultSet showObservatories() throws SQLException{

        String query = "SELECT * FROM observatories";
        st = con.createStatement();
        data = st.executeQuery(query);

        return data;
    }

    public ResultSet showRecordsGreaterThanValue(int value) throws SQLException{

        String query = "SELECT * FROM galamseys WHERE colorValue > " + value;
        st = con.createStatement();
        data = st.executeQuery(query);

        return data;
    }

    public ResultSet showAllRecords() throws SQLException{

        String query = "SELECT vegColor, colorValue, latitude, longitude, yearRecorded, observatoryName FROM galamseys";
        pst = con.prepareStatement(query);

        return pst.executeQuery();
    }

    public int countRecords(int colourValue) throws SQLException{

        int value = 0;

        String query = "select COUNT(colorValue) from galamseys where colorValue = ?";
        pst = con.prepareStatement(query);

        pst.setInt(1, colourValue);
        data = pst.executeQuery();

        while(data.next()){
            value = data.getInt(1);
        }

        return value;
    }

}

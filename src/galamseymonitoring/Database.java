package galamseymonitoring;
/*
  Required packages to be imported
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

    //Constructor to initiate database connection
    public Database(){
        url = "jdbc:mysql://35.184.137.103:3306/galamseydb";
        uname = "root";
        pass = "financialmanagement";

        //Try...catch block to load mysql jdbc driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,uname,pass);
        }
        catch (Exception e){
            System.out.println("Failed to get connection to database. Please check your internet connection.");
            System.exit(0);
        }
    }

    /**
     *
     * @param o Observatory object which would be added to the database
     * @return the number of rows affected by update statement
     * @throws SQLException Method throws SQLException
     */
    public String insertObservatory(Observatory o) throws SQLException {

        //sql query
        String query = "INSERT INTO observatories (observatoryName, countryName, areaCovered, yearStarted) " +
                "VALUES (?, ?, ?, ?)";
        pst = con.prepareStatement(query); //prepared statement for sql query


        //Set values for the prepared statements
        pst.setString(1, o.getObservatoryName());
        pst.setString(2, o.getCountryName());
        pst.setInt(3, o.getAreaCovered());
        pst.setInt(4, o.getYearStarted());

        int count = pst.executeUpdate();

        return count + " number of rows affected";
    }

    /**
     * Method which loads observatories from the database
     * @throws SQLException Method throws SQLException
     */
    public void initialLoad() throws SQLException{

        // sql query
        String query = "SELECT * FROM observatories";
        st = con.createStatement(); //statement
        data = st.executeQuery(query); //result-set

        while(data.next()){
            // Create an observatory object using the tuples from the database
            Observatory o = new Observatory(data.getString(2), data.getString(3), data.getInt(4),
                    data.getInt(5));
        }

    }

    /**
     *
     * @param g Galamsey object which would be inserted into the database
     * @return the number of rows affected by the update statement
     * @throws SQLException Method throws SQLException
     */
    public String insertGalamsey(Galamsey g) throws SQLException{

        //sql statement
        String query = "INSERT INTO galamseys(vegColor, colorValue, latitude, longitude, yearRecorded, observatoryName)\n" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        pst = con.prepareStatement(query); //prepared statement

        //Set values for the sql prepared statement
        pst.setString(1, g.getVegColor().toString());
        pst.setInt(2, g.getColourValue());
        pst.setDouble(3, g.getPosition().getLatitude());
        pst.setDouble(4, g.getPosition().getLongitude());
        pst.setInt(5, g.getYearOfEevent());
        pst.setString(6, g.getObservatory().getObservatoryName());

        int count = pst.executeUpdate();
        return count + " number of rows affected";

    }

    /**
     * Load galamsey objects from the database
     * @throws SQLException Method throws SQLException
     */
    public void loadGalamseys() throws SQLException{

        // sql query
        String query = "SELECT * FROM galamseys";
        st = con.createStatement(); //statement
        data = st.executeQuery(query); //result-set

        while(data.next()){
            //create a galamsey object for each tuple in the database
            Galamsey g = new Galamsey(Galamsey.colour.valueOf(data.getString(2).toLowerCase()), data.getInt(3),
                    new Position(data.getDouble(4), data.getDouble(5)), data.getInt(6));

            /*loop through the programme's list of observatories and
            add galamsey objects to respective observatories*/
            for (Observatory o:
                 Monitoring.observatories) {
                if(data.getString(7).equals(o.getObservatoryName())){
                    o.addToEvents(g);
                }
            }
        }
    }

    /**
     * Method to query database for all observatories
     * @return the result set of observatories
     * @throws SQLException Method throws SQLException
     */
    public ResultSet showObservatories() throws SQLException{

        //sql query
        String query = "SELECT * FROM observatories";
        st = con.createStatement(); //statement
        data = st.executeQuery(query); //result-set

        return data;
    }

    /**
     * Method to query database for records greater than a specific value
     * @param value Number to compare when selecting tuples
     * @return result set of galamsey records greater than a specific value
     * @throws SQLException Method throws SQLException
     */
    public ResultSet showRecordsGreaterThanValue(int value) throws SQLException{

        String query = "SELECT vegColor, colorValue, latitude, longitude, yearRecorded, observatoryName FROM galamseys WHERE colorValue > " + value;
        st = con.createStatement();
        data = st.executeQuery(query);

        return data;
    }

    /**
     * Method to show all galamsey records
     * @return result set of all galamsey records
     * @throws SQLException Method throws SQLException
     */
    public ResultSet showAllRecords() throws SQLException{

        String query = "SELECT vegColor, colorValue, latitude, longitude, yearRecorded, observatoryName FROM galamseys";
        pst = con.prepareStatement(query);

        return pst.executeQuery();
    }

    /**
     * Method to show the count of records
     * @param colourValue Values of galamsey records
     * @return count of records
     * @throws SQLException Method throws SQLException
     */
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

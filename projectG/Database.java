import java.sql.*;

public class Database {

    String url;
    String uname;
    String pass;

    Connection con;
    Statement st;
    PreparedStatement pst;
    ResultSet data;

    public Database(){
        url = "jdbc:mysql://localhost:3306/galamsey";
        uname = "root";
        pass = "%loulou%";

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
}

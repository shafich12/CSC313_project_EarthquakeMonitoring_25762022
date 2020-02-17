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
            Monitoring.observatories.add(o);
        }

    }




}

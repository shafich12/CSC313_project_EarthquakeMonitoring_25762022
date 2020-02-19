package galamseymonitoring;

import java.sql.*;

public class DBTest {

    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/galamsey";
        String uname = "root";
        String pass = "root";
        String query = "INSERT INTO observatories (observatoryName, countryName, areaCovered, yearStarted)\n" +
                "VALUES (?, ?, ?, ?)";

        String observatoryName = "Jamestown";
        String countryName = "France";
        int areaCovered = 22;
        int yearStarted = 2009;

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);

        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(query);
        //ResultSet rs = st.executeQuery(query);
        //String observatoryData = "";

        st.setString(1, observatoryName);
        st.setString(2, countryName);
        st.setInt(3, areaCovered);
        st.setInt(4, yearStarted);

        int count = st.executeUpdate();

        System.out.println(count + " number of rows affected.");

        /*
        while(rs.next()) {
            observatoryData = rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getString(3)
                    + ":" + rs.getInt(4) + ":" + rs.getInt(5);
            System.out.println(observatoryData);
        }*/

        st.close();
        con.close();

    }
}

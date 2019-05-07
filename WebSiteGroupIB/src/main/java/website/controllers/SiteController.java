package website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SiteController {

    /*sin on veut pas que le code cherche un template il faut
    ajouter
    @ResponseBody
    */

    @GetMapping("/")
    public String home() {
        return "pages/frontEnd";
    }

    @GetMapping("/backend/")
    public String homeBack() {
        return "pages/backEnd";
    }

    @GetMapping("/companyDetails/")
    public String companyDetails(@RequestParam(required = false, defaultValue = "1") int id, ModelMap modelMap) {
        try {

            Connection conn = openConnection();

            Statement stmt = conn.createStatement();

            String name = "";
            String location = "";
            String industry = "";

            String strSelect = "select name, location, industry  from company where id=" + id;
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                name = rset.getString("name");
                location = rset.getString("location");
                industry = rset.getString("industry");
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", name);
            map.put("location", location);
            map.put("industry", industry);
            map.put("id", Integer.toString(id));
            modelMap.putAll(map);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pages/companyDetails/";
    }

    @GetMapping("/backend/companyAdd/")
    public String companyAdd() {
        return "pages/companyAdd";
    }












    public Connection openConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String mysqlConnUrl = "jdbc:mysql://localhost:3306/cyberattacks";

            String mysqlUserName = "root";

            String mysqlPassword = "";

            conn = DriverManager.getConnection(mysqlConnUrl, mysqlUserName, mysqlPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

}

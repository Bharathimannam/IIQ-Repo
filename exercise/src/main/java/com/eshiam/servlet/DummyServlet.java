package com.eshiam.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;


@WebServlet("/Exercise/DummyServlet")
public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DummyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet");
        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");

        String selectedOption = request.getParameter("selectedOption");
        System.out.println("selectedOption: " + selectedOption);  // Log to check value
        List<Item> itemList = new ArrayList<>();

        if (selectedOption != null && !selectedOption.isEmpty()) {
            Connection connection = null;
            try {
                connection = getDBConnection();
                Statement stmt = connection.createStatement();
                if (selectedOption.equals("role")) {
                    System.out.println("Inside Role");
                    ResultSet rs = stmt.executeQuery("SELECT id, work_queue_name FROM sys.work_queue");
                    while (rs.next()) {
                        int workQueueId = rs.getInt("id");
                        String workQueueName = rs.getString("work_queue_name");
                        itemList.add(new Item(workQueueId, workQueueName));
                    }
                } else if (selectedOption.equals("user")) {
                    System.out.println("Inside User");
                    ResultSet rs = stmt.executeQuery("SELECT id, first_name FROM sys.user");
                    while (rs.next()) {
                        int userId = rs.getInt("id");
                        String userFirstName = rs.getString("first_name");
                        itemList.add(new Item(userId, userFirstName));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (Item item : itemList) {
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id", item.getId())
                .add("name", item.getName());
            jsonArrayBuilder.add(jsonObjectBuilder.build());
        }
        javax.json.JsonArray jsonArray = jsonArrayBuilder.build();
        System.out.println(jsonArray.toString());
        pw.println(jsonArray.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private static Connection getDBConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Qwerty@22");
    }

    class Item {
        private int id;
        private String name;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}

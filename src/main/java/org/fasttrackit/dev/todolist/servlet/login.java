package org.fasttrackit.dev.todolist.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;


@WebServlet("/login")
public class login extends HttpServlet {
//    ArrayList<User> list = new ArrayList<User>();
//
//
//    public ArrayList<User> demoRead() throws ClassNotFoundException, SQLException {
//        try {// 1. load driver
//            Class.forName("org.postgresql.Driver");
//
//            // 2. define connection params to db
//            final String URL = "jdbc:postgresql://54.93.65.5/4_Manu";
//            final String USERNAME = "fasttrackit_dev";
//            final String PASSWORD = "fasttrackit_dev";
//
//            // 3. obtain a connection
//            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            // 4. create a query statement
//            Statement st = conn.createStatement();
//
//            // 5. execute a query
//            ResultSet rs = st.executeQuery("SELECT username,password FROM login");
//
//            // 6. iterate the result set and print the values
//
//
//            while (rs.next()) {
//                User user = new User();
//                String usr = rs.getString("username").trim();
//                String pass = rs.getString("password").trim();
//                user.setU(usr);
//                user.setP(pass);
//                list.add(user);
//                System.out.println(user.getU() + " - " + user.getP());
//            }
//
//
//            // 7. close the objects
//            rs.close();
//            st.close();
//            conn.close();
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//

//    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();

//        String username = request.getParameter("u");
//        String password = request.getParameter("p");

        // read user and password introduced by the user in the UI
        String user = request.getParameter("u");
        String passwd = request.getParameter("p");

        // static & simulated db row
        final String dbu="manu";
        final String dbp="manu";
        final String userid="356";


//        try {
//            demoRead();
//            System.out.println("hello");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        boolean log = false;
//
//        for (User u : list) {
//            if (u.getU().equals(username) && u.getP().equals(password)) {
//                log = true;
//                break;
//            }
//
//        }

        if(dbu.equals(user) && dbp.equals(passwd)){


//        if (log == true) {
            // userul exista in db



            HttpSession session = request.getSession(true);
            session.setAttribute("username",user);
            session.setAttribute("usernameid",userid);


            String success = "/addToList.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(success);
            dispatcher.forward(request, response);
        }
        else {

            String back = "/index.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
            dispatcher.forward(request, response);

        }



    }
}
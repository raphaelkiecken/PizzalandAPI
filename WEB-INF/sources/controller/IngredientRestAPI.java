package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.dao.IngredientDAO;
import model.dao.IngredientDAOJdbc;
import model.pogo.Ingredient;
import jakarta.servlet.annotation.WebServlet;

import java.util.Collection;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ingredients/*")
public class IngredientRestAPI extends HttpServlet {

    private static final Logger logger = Logger.getLogger(IngredientRestAPI.class.getName());

    public static IngredientDAO ingredientDAO = new IngredientDAOJdbc();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String info = req.getPathInfo();
        logger.info("GET /ingredients" + info);
        res.setContentType("application/json;charset=UTF-8");

        PrintWriter out = res.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        if (info == null || info.equals("/")) {
            Collection<Ingredient> l = ingredientDAO.findAll();
            String jsonstring = objectMapper.writeValueAsString(l);
            out.print(jsonstring);
            return;
        }

        String[] splits = info.split("/");
        if (splits.length != 2) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String id = splits[1];
        Ingredient i = ingredientDAO.findById(Integer.parseInt(id));
        if (i == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        out.print(objectMapper.writeValueAsString(i));
        return;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String info = req.getPathInfo();
        logger.info("POST /ingredients" + info);
        res.setContentType("application/json;charset=UTF-8");

        PrintWriter out = res.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        StringBuilder data = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            data.append(line);
        }

        Ingredient i = objectMapper.readValue(data.toString(), Ingredient.class);
        if (!IngredientRestAPI.ingredientDAO.save(i)) {
            res.sendError(HttpServletResponse.SC_CONFLICT);
            return;
        }
        out.print(objectMapper.writeValueAsString(i));
        return;
    }
}
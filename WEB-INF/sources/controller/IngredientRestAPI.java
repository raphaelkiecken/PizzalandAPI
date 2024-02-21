package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.dao.IngredientDAOJdbc;
import model.pogo.IngredientGET;
import model.pogo.IngredientPOST;
import jakarta.servlet.annotation.WebServlet;

import java.util.Collection;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ingredients/*")
public class IngredientRestAPI extends RestAPI {

    private static final Logger logger = Logger.getLogger(IngredientRestAPI.class.getName());

    public static IngredientDAOJdbc ingredientDAO = new IngredientDAOJdbc();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String info = req.getPathInfo() == null ? "" : req.getPathInfo();
        logger.info("GET /ingredients" + info);
        res.setContentType("application/json;charset=UTF-8");

        PrintWriter out = res.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        if (info.equals("/") || info.equals("")) {
            Collection<IngredientGET> l = ingredientDAO.findAll();
            out.print(objectMapper.writeValueAsString(l));
            return;
        }

        String[] splits = info.split("/");
        if (splits.length > 3) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String id = splits[1];
        IngredientGET i = ingredientDAO.findById(Integer.parseInt(id));
        if (i == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        if (splits.length == 3) {
            if (splits[2].equals("name")) {
                out.print(objectMapper.writeValueAsString(i.getIname()));
                return;
            }
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        out.print(objectMapper.writeValueAsString(i));
        return;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String info = req.getPathInfo() == null ? "" : req.getPathInfo();
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
        IngredientPOST i = objectMapper.readValue(data.toString(), IngredientPOST.class);
        if (!IngredientRestAPI.ingredientDAO.save(i)) {
            res.sendError(HttpServletResponse.SC_CONFLICT);
            return;
        }
        out.print(objectMapper.writeValueAsString(i));
        return;
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String info = req.getPathInfo() == null ? "" : req.getPathInfo();
        logger.info("DELETE /ingredients" + info);
        res.setContentType("application/json;charset=UTF-8");

        PrintWriter out = res.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        if (info.equals("/") || info.equals("")) {
            if (!ingredientDAO.deleteAll()) {
                res.sendError(HttpServletResponse.SC_CONFLICT);
                return;
            }
            out.print(objectMapper.writeValueAsString("All ingredients deleted"));
            return;
        }

        String[] splits = info.split("/");
        if (splits.length != 2) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String id = splits[1];
        IngredientGET i = ingredientDAO.findById(Integer.parseInt(id));
        if (i == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        if (!ingredientDAO.delete(i)) {
            res.sendError(HttpServletResponse.SC_CONFLICT);
            return;
        }
        out.print(objectMapper.writeValueAsString(i));
        return;
    }
}
package com.emergentes.controlador;

import com.emergentes.dao.CateDAO;
import com.emergentes.dao.CateDAOimpl;
import com.emergentes.modelo.cate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CateController", urlPatterns = {"/CateController"})
public class CateController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CateDAO dao = new CateDAOimpl();
        
        cate lib = new cate ();
        int id ;
        
        
       String action =(request.getParameter("action") != null )?request.getParameter("action"): "view";
       switch(action){
           case "add":
               request.setAttribute("libro", lib);
               request.getRequestDispatcher("frmcate.jsp").forward(request, response);
               
           break;
           case "edit":
               
               id = Integer.parseInt(request.getParameter("id"));
               //obtener al objeto que coresponde alr egistro
            
                try {
                    lib = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener Registro"+ ex.getMessage());
                }
            
               //colocar comoatributo
                request.setAttribute("libro",  lib);
               request.getRequestDispatcher("frmcate.jsp").forward(request, response);
               // transferiri el control d e frmcate.jsp
           break;

           case"delete":
               id = Integer.parseInt(request.getParameter("id"));
            
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("error al eliminar"+ ex.getMessage());
                }
            
               response.sendRedirect("CateController");
           break;

           case"view":
               List<cate> lista= new ArrayList<cate>();
            try {
                lista = dao.getAll();
            } catch (Exception ex) {
                System.out.println("Erro al listar"+ ex.getMessage());
            }
               request.setAttribute("cate", lista);
               request.getRequestDispatcher("cate.jsp").forward(request, response);
           break;
           default:
                break;
            }
       
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int  id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        String categoria = request.getParameter("categoria");
        
        cate  lib = new cate();
        
        lib.setId(id);
        
        lib.setCategoria(categoria);
        
       CateDAO dao = new CateDAOimpl();
        
        if (id == 0){
            try {
                //nuevo
                dao.insert(lib);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ ex.getMessage());
            }
        }
        else{
            try {
                //edicion
                dao.update(lib);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ ex.getMessage());
            }
        }
        response.sendRedirect("CateController");
            
    }

    

}

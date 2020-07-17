/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletConfig;

/**
 *
 * @author lunar
 */
public class servlet1 extends HttpServlet {
    //primero debemos de establcer la coenxion con db
    
    private Connection con;//es el objeto para establecer la conexion con DB
    private Statement set; // es para poder preparar la query (insert, alterm create)
    private ResultSet rs; //es el objeto para poder realizar consultar (select)
    
    //METODO GET Y SET

     //GET CONEXION
    public Connection getCon() {
        return con;
    }
    //SET CONEXION
    public void setCon(Connection con) {
        this.con = con;
    }
    //GET STATEMENT
    public Statement getSet() {
        return set;
    }
    //SET STATEMENT
    public void setSet(Statement set) {
        this.set = set;
    }
    //GET RESULTSET
    public ResultSet getRs() {
        return rs;
    }
    //SET RESULSET
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    
  /*
    Es un lenguaje altemente tipado significa que jayq ue ser precisos en el tipo de dato
    
    Es un lenguaje orientado a objetos, herencia, polimorfismo, encapsulamiento, abstraccion, sobrecarga
    
    Es un lenguaje que ocupa objetos a partir de la instanceacion de clases
    Primero se crea una clase para poder hacer una intancia del objeto (la manipulacion)
    de la clase hijo a partir de la instanceacion de un objeto
    
    Polimorfismo es la propiedad de un objeto de cambiar su  forma(sus propiedades pueden
    ser modificadas a partir del mismo objeto) p e
    Clase Persona clase estudiante un estudiante es un persona, converit una persona en est
    clase policia, clase bombemo, clase docente, todos son personas.
    Comportamientos (metodos) pueden compartirse
    
    Encapsulamiento es la propiedad de aisgnar a una clase metodos de acceso privado, para
    que los variable y/o metodos no sean midificados(get y set)
    
    Abstraccion es poder realizar la separacion de los comportamientos del mundo real a programacion y puede crear
    interpretes(interface, clase interface)
    
    Sobrecarga, paticularidad de poo, de poder realizar un constructor, un metodo y otro metodo
    ylee que sean necesarios bajo el mismo nombre, solo que ca,biando el paso de parametros PE
    
    Construcotr : nos sirve pra poder inicializar los objetos, variable y parametros de un
    AgregarU()
    
    Metodo:
    AgregarU(int bol,string nom)
    
    Metodo sobrecargado:
    AgregarU(int bol, string nom, string appat, string appat)
    
    Metodo sobrecargado:
    AgregarU(boolean i, String nom, String appat)
    */
    //es el metodo para la conecxion con la base de datos
    @Override
    public void init(ServletConfig cfg) throws ServletException{
      //override es un metodo propio de netsban para saber donde iniicia y finaliza un metodo
      //se traza la ruta de la conexion con la bd
      String URL = "jdbc:mysql:3306//localhost/saeo";
      //usuario de la db
      String userName = "root";
      //password
      String password = "";
      try{
          //colocar el driver de la conexion mysql, sql,firebase, con el manejador
          Class.forName("com.mysql.jdbc.Driver");
          
          //a veces por la version del manejador de mysql
          //url ="jdbc://localhost/saeo";
          
          //Hacemos uso de los objetos de con y set
          con = DriverManager.getConnection(URL, userName, password);
          //con set prepararamos la sentencia
          set = con.createStatement();
          
          System.out.println("conecto con la DB");
      }catch(Exception e){
          System.out.println("No conecto con la DB");
          //donde fue el error
          System.out.println(e.getMessage());
          System.out.println(e.getStackTrace());
      }
    }
    
    //procesos
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom, apa, ama, email;
            int edad;
            
            nom = request.getParameter("nombre");
            apa = request.getParameter("appat");
            ama = request.getParameter("ampat");
            email = request.getParameter("email");
            edad = Integer.parseInt(request.getParameter("edad"));
               
            try{
                String g = "insert into registro(nom_reg, appat_reg, apmat_reg, edad_reg, email_reg)"
                        + "values ('"+nom+"','"+apa+"','"+ama+"','"+edad+"','"+email+"')";
                
                set.executeUpdate(g);
                System.out.println("Dato agregado");
            /* TODO output your page here. You may use following sample code. */
                      
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Usuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Gracias por Registrarte</h1>"
            +"<a href='index.html'>Regresar</a>");
            out.println("</body>");
            out.println("</html>");
            }catch(Exception e){
            
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package es.daw.simpson.controller;

import java.io.*;
import java.util.List;

import es.daw.simpson.model.Personaje;
import es.daw.simpson.repository.PersonajeRepository;
import es.daw.simpson.service.PersonajeService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/personajes")
public class PersonajeServlet extends HttpServlet {

        //NO VAMOS A USAR REPOSITORIOS DIRECTAMENTE DEL SERVLET

        private final PersonajeService personajeService= new PersonajeService();

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //1. LEER LOS PARAMETROS DEL REQUEST
        //PENDIENTE!!
        String lugar=request.getParameter("lugar");
        System.out.println("lugar:"+lugar);

        String edadMax=request.getParameter("edadMax"); //Cuidado!! llega como un String pero la edad la trata como un int
        System.out.println("edadMax:"+edadMax);
//        Integer edadMin=Integer.valueOf(request.getParameter("edadMin"));
        int edadMin=Integer.parseInt(request.getParameter("edadMin"));
//        int edadMin2=Integer.parseInt(request.getParameter("edadMin"));


        String edadMin=request.getParameter("edadMin");
        //continuará...

        //boolean descendente=Boolean.parseBoolean(request.getParameter("descendente"));
        boolean descendente=request.getParameter("descendente")!=null; //Si no esta marcado no se envia
        System.out.println("descendente:"+descendente);

        //2. VALIDAR LOS DATOS DE LOS PARAMETROS


        //3. LÓGICA DE NEGOCIO QUE HARÄ UN SERVICIO. OBTENER LA LISTA DE LOS PERSONAJES (con o sin filtro, con o sin ordenacion ...)
        List<Personaje> personajes=personajeService.buscar();


        //4. ENVIAR A LA VISTA LA INFORMACION PERTINENTE

        request.setAttribute("personajes", personajes);

        //5. REENVIAR A LA VISTA (JSP)
        request.getRequestDispatcher("/personajes.jsp").forward(request,response);
    }




}

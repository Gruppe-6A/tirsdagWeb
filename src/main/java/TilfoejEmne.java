import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet(name = "TilfoejEmne", value = "/TilfoejEmne")
public class TilfoejEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Oversigt.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String emne = request.getParameter("emne");

        HttpSession session = request.getSession();

        ServletContext context = request.getServletContext();

        HashSet<String> emneListeContext = (HashSet<String>) context.getAttribute("emneListeContext");

        HashSet<String> emneListe = (HashSet<String>) session.getAttribute("emneListe");

        if(emneListeContext == null) {
            emneListeContext = new HashSet<>();
        }

        int contextSize = emneListeContext.size();

        if(emneListe == null) { //if loopet bliver kun kørt første gang vi er forbi!!
            emneListe = new HashSet<>();
        }

        if( !emneListeContext.contains(emne)){
            emneListeContext.add(emne);
        }

        emneListe.add(emne);

        int emneListeSize = emneListe.size();

        context.setAttribute("emneListeContext", emneListeContext);
        context.setAttribute("ContextSize", contextSize);

        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeSize", emneListeSize);
        request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request,response);
    }
}
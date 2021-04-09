import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet(name = "SletEmne", value = "/SletEmne")
public class SletEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("emne");
        HttpSession session = request.getSession();

        HashSet<String> stringList = (HashSet<String>) session.getAttribute("emneListe");

        if(stringList == null) {
            stringList = new HashSet<>();
        }

        stringList.remove(s);

        session.setAttribute("emneListe",stringList);

        request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request,response);
    }
}

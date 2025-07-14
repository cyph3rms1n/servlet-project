import java.io.PrintWriter;

public class RdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String s = "Before Dispatcher";
        out.println(s);

        try {
            RequestDispatcher rd = req.getRequestDispatcher("/demo");
            rd.include(req, res);
            // rd.forward(req, res);
        }
        catch (Exception e) {
            out.println(e);
        }

        out.print("<")
    }
}

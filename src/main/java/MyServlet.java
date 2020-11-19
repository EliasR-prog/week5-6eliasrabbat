import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.stream.Collectors;
import com.google.gson.Gson;


@WebServlet(urlPatterns={"/patients"},loadOnStartup = 1)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.getWriter().write("<HTML>\n" +
                "\n" +
                "<HEAD>\n" +
                "\n" +
                "<TITLE>Your Title Here</TITLE>\n" +
                "\n" +
                "</HEAD>\n" +
                "\n" +
                "<BODY BGCOLOR=\"FFFFFF\">\n" +
                "\n" +
                "<CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> </CENTER>\n" +
                "\n" +
                "<HR>\n" +
                "\n" +
                "<a href=\"http://somegreatsite.com\">Link Name</a>\n" +
                "\n" +
                "is a link to another nifty site\n" +
                "\n" +
                "<H1>This is a Header</H1>\n" +
                "\n" +
                "<H2>This is a Medium Header</H2>\n" +
                "\n" +
                "Send me mail at <a href=\"mailto:support@yourcompany.com\">\n" +
                "\n" +
                "support@yourcompany.com</a>.\n" +
                "\n" +
                "<P> This is a new paragraph!\n" +
                "\n" +
                "<P> <B>This is a new paragraph!</B>\n" +
                "\n" +
                "<BR> <B><I>This is a new sentence without a paragraph break, in bold italics.</I></B>\n" +
                "\n" +
                "<HR>\n" +
                "\n" +
                "</BODY>\n" +
                "\n" +
                "</HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        resp.setContentType("application/json");
        resp.getWriter().write("Thank you client! "+reqBody);
        System.out.println(reqBody);
        Gson gson = new Gson();
        Patient p=gson.fromJson(reqBody,Patient.class);
    }
}

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FinalizarCompra extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String pagamento = req.getParameter("pagamento");
        String valor = req.getParameter("valor");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Confirmação</title></head><body>");
        out.println("<h2>✅ Compra Finalizada</h2>");
        out.println("<p><strong>Cliente:</strong> " + nome + "</p>");
        out.println("<p><strong>Valor:</strong> R$" + valor + "</p>");
        out.println("<p><strong>Método de Pagamento:</strong> ");

        switch (pagamento) {
            case "credito":
                out.println("Cartão de Crédito</p>");
                out.println("<p>Transação aprovada.</p>");
                break;
            case "debito":
                out.println("Cartão de Débito</p>");
                out.println("<p>Transação aprovada.</p>");
                break;
            case "pix":
                out.println("PIX</p>");
                out.println("<p>Chave PIX: contato@tanope.com<br>Aguardando confirmação...</p>");
                break;
            case "boleto":
                out.println("Boleto Bancário</p>");
                out.println("<p>Linha digitável: 34191.79001 01043.510047 91020.150008 7 12345678901234</p>");
                break;
            default:
                out.println("Desconhecido</p>");
        }

        out.println("<a href='compra.html'>🔙 Voltar</a>");
        out.println("</body></html>");
    }
}

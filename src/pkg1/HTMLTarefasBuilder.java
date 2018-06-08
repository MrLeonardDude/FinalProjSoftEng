package pkg1;

import java.io.PrintWriter;
import java.util.ArrayList;

public class HTMLTarefasBuilder {
    public void makeHome(ArrayList<Tarefa> pendente){

        try(PrintWriter out = new PrintWriter("/opt/tomcat/webapps/orkut/tarefas.html")){
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" +
                    "  <link rel=\"stylesheet\" href=\"https://v40.pingendo.com/assets/4.0.0/default/theme.css\" type=\"text/css\">\n" +
                    "  <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\"> </head>\n" +
                    "\n" +
                    "<body class=\"bg-dark\">\n" +
                    "<div class=\"py-3\">\n" +
                    "  <div class=\"container-fluid py-0\">\n" +
                    "    <div class=\"row\">\n" +
                    "      <div class=\"col-md-12\">\n" +
                    "        <ul class=\"nav flex-column\" id=\"listaTarefas\">\n" +
                    "          <div class=\"row\">\n" +
                    "            <h1>Tarefas</h1>\n" +
                    "          </div>\n");
            for(int i =0; i < pendente.size(); i++) {
                out.println(
                        "<li class=\"nav-item dropdown\">\n" +
                                "            <a class=\"nav-link text-dark nav-item bg-primary w3-border-dark-grey dropdown-toggle \" href=\"tarefas.html\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"
                );
                out.println(pendente.get(i).getDefinicao());
                out.println("</a>\n" +
                        "            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n" +
                        "              <a class=\"dropdown-item\" href=\"historico_tarefa.html\" target=\"conteudo\">Histórico</a>\n" +
                        "              <a class=\"dropdown-item\" href=\"editar_tarefa.html\">Editar Tarefa</a>\n" +
                        "              <a class=\"dropdown-item\" href=\"tarefas.html\">Excluir Tarefa</a>\n" +
                        "              <a class=\"dropdown-item\" href=\"tarefas.html\">Concluir Tarefa</a>\n" +
                        "            </div>");
            }
            out.println("</ul>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                    "\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>");
        }catch(Exception e){

        }
    }

}

package pkg1;

import java.io.PrintWriter;
import java.util.ArrayList;

public class HTMLBuilder {

    public void makeHome(ArrayList<Membro> user, ArrayList<Membro> userOff, ArrayList<Tarefa> pendente, String Name){

        try(PrintWriter out = new PrintWriter("/opt/tomcat/webapps/orkut/orkut_"+ Name+ ".html")){
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "\n" +
                    "<head>\n" +
                    //"  <meta http-equiv=\"refresh\" content=\"120\" />" +
                    "<meta charset=\"utf-8\">\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1\">\n" +
                    "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n" +
                    "  <link rel=\"stylesheet\" href=\"https://v40.pingendo.com/assets/4.0.0/default/theme.css\" type=\"text/css\"> </head>\n" +
                    "\n" +
                    "<body >\n" +
                    "\n" +
                    "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
                    "    <div class=\"container\">\n" +
                    "      <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\">\n" +
                    "        <span class=\"navbar-toggler-icon\"></span>\n" +
                    "      </button>\n" +
                    "      <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                    "        <ul class=\"navbar-nav mr-auto\">\n" +
                    "          <li class=\"nav-item\">\n" +
                    "            <a class=\"nav-link\" href=\"inicio.html\" target=\"conteudo\">Home</a>\n" +
                    "          </li>\n");

                    out.println("<li class=\"nav-item dropdown\" >" +
                                "<a class=\"nav-link dropdown-toggle\" href=\"tarefas_"+Name+".html\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Tarefas </a>"+
                                "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">"+
                                  "<a class=\"dropdown-item\" href=\"tarefas_"+Name+".html\" target=\"conteudo\">Listar Tarefas</a>"+
                                  "<a class=\"dropdown-item\" href=\"adicionar_tarefa.html\" target=\"conteudo\">Adicionar Tarefa</a>"+
                                "</div>"+
                              "</li>");


                    out.println(
                    "          <li class=\"nav-item dropdown\" >\n" +
                    "            <a class=\"nav-link dropdown-toggle\" href=\"reunioes_"+Name + ".html\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Reuniões </a>\n" +
                    "            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n" +
                    "              <a class=\"dropdown-item\" href=\"reunioes_"+ Name+ ".html\" target=\"conteudo\">Listar Reuniões</a>\n" +
                    "              <a class=\"dropdown-item\" href=\"criar_reuniao.html\" target=\"conteudo\">Criar Reunião</a>\n" +
                    "            </div>\n" +
                    "          </li>\n" +
                    "          <li class=\"nav-item\">\n" +
                    "            <a class=\"nav-link disabled\" target=\"conteudo\">Agenda</a>\n" +
                    "          </li>\n" +
                    "          <li class=\"nav-item\">\n" +
                    "            <a class=\"nav-link disabled\" target=\"conteudo\">Discussões</a>\n" +
                    "          </li>\n" +
                    "        </ul>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    " <form action=\"logout\" method=\"get\">\n" +
                    "        <button type=\"submit\" class=\"btn btn-secondary\">Logout</button>\n" +
                    "    </form></nav>\n" +
                    "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                    "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                    "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                    "\n" +
                    "  <div class=\"container-fluid\" style=\"height:84.20%;\">\n" +
                    "    <div class=\"row\" style=\"height:100%; width=100%;\">\n" +
                    "      <iframe src=\"inicio.html\" name=\"conteudo\" style=\"border:none;\" width=\"85%\">\n" +
                    "\n" +
                    "      </iframe>\n" +
                    "      <div class=\"col bg-dark\">\n" +
                    "        <h3 class=\"my-2\">Online</h3>\n" +
                    "        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <ul class=\"\">\n");
                for(int i =0; i < user.size(); i++) {
                    out.println("<li><a href=\"contato.html\" target=\"conteudo\">"+user.get(i).getNome()+"</a></li>\n");
                }
                out.println("</ul>\n</div>\n</div>\n");
                out.println("        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <h3 class=\"my-2\">Offline</h3>\n" +
                    "            <div class=\"col-md-12\">\n" +
                    "              <ul class=\"\">\n");
            for(int i =0; i < userOff.size(); i++) {
                out.println("<li>"+userOff.get(i).getNome()+"</li>\n");
            }
            out.println("</ul>\n</div>\n</div>\n</div>");
            out.println("        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <h3 class=\"my-2\">Para fazer</h3>\n" +
                    "            <ul class=\"\">\n");
            for(int i = 0; i < pendente.size(); i++){
                out.println(        "              <li>"+ pendente.get(i).getDefinicao()+"</li>\n");}

            out.println(        "            </ul>\n" +
                    "          </div>\n" +
                    "        </div>\n");
             out.println("        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <h3 class=\"my-2\">Dúvidas</h3>\n" +
                    "            <ul class=\"\">\n" +
                    "              <li>Como programar em HTML ?</li>\n" +
                    "              <li>Como fazer uma interface responsiva ?</li>\n" +
                    "            </ul>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n" +
                    "    <p>Status: Online   -    Project: Orkut's Project</p>\n" +
                    "  </nav>\n" +
                    "</body>\n" +
                    "</html>\n");
        }catch(Exception e){

        }
    }
}

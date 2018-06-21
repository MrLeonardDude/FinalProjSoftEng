package pkg1;


import java.io.PrintWriter;
import java.util.ArrayList;


public class HTMLBuilderReuniao {

    public void makeHome(ArrayList<Reuniao> reuniao, String Name) {
        try(PrintWriter out = new PrintWriter("/opt/tomcat/webapps/orkut/reunioes_"+ Name +".html")){
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
                    "<body style=\"background-repeat:no-repeat;background-size:cover;\" class=\"bg-dark\">\n" +
                    "  <div class=\"py-3\">\n" +
                    "    <div class=\"container-fluid py-0\">\n" +
                    "      <div class=\"row\">\n" +
                    "        <div class=\"col-md-12\">\n" +
                    "          <ul class=\"nav nav-pills flex-column\">\n" +
                    "            <h1 class=\"\">Reuniões</h1>\n");
                   for(int i =0; i < reuniao.size(); i++) {

                       out.println(
                               "            <li class=\"nav-item w3-teal\" style=\"border-left: 4px solid #fff; border-bottom: 1px solid #fff\">\n" +
                                       "              <button onclick=\"myFunction('reuniao1')\" class=\"w3-button w3-block w3-left-align w3-text-black\"> Reuniao #" + reuniao.get(i).getID() + " - Local :"+reuniao.get(i).getLocal()+" -  Data :" + reuniao.get(i).getData()+ "</button>\n" +
                                       "              <div id=\"reuniao"+ reuniao.get(i).getID()+ "\" class=\"w3-container w3-hide w3-blue-grey\">\n" +
                                       "                <h4>Data : "+reuniao.get(i).getData() + " e Local : "+ reuniao.get(i).getLocal()+"</h4>\n" +
                                       "                <p>" + reuniao.get(i).getPauta()+ "</p>\n" +
                                       "                              <a class=\"btn btn-primary\"onclick=\"window.location.href = 'r1.html';\" class=\"w3-button w3-left w3-text-white w3-teal\" href=\"reuniao_13.html\" style=\"border-top: 1px solid #fff; border-right: 1px solid #fff; border-left: 1px solid #fff\">\n" +
                                       "                Reunião 13/06&nbsp; </a>\n" +
                                       "            </div>\n" +
                                       "      </li>\n");
                   }

                    out.println(

                    "          </ul>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                    "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                    "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                    "  <!-- Esse script serve para fazer o acordeão das reunioes -->\n" +
                    "  <script>\n" +
                    "    function myFunction(id) {\n" +
                    "      var x = document.getElementById(id);\n" +
                    "      if (x.className.indexOf(\"w3-show\") == -1) {\n" +
                    "          x.className += \" w3-show\";\n" +
                    "      } else {\n" +
                    "          x.className = x.className.replace(\" w3-show\", \"\");\n" +
                    "      }\n" +
                    "    }\n" +
                    "  </script>\n" +
                    "\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>\n");

        }catch(Exception e){

        }
    }

}
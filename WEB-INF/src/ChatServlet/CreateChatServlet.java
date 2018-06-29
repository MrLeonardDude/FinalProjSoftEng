package ChatServlet;

import pkg1.Reuniao;

import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateChatServlet {

    public void makeHome(ArrayList<Reuniao> reuniao, String ID1, String ID2, String Name) {
        try (PrintWriter out = new PrintWriter("/opt/tomcat/webapps/orkut/contatos_" + ID1+ "_" + ID2 +  ".html")) {
            out.println("<!DOCTYPE html>\n" +
                    "<!--O que falta: Atualizar com o background, fazer ele abrir em um lugar menor, diminuir ele -->\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "  <script type='text/javascript' src='https://cdn.scaledrone.com/scaledrone.min.js'></script>\n" +
                    "  <!--<script type='text/javascript' src='http://0.0.0.0:8080/scaledrone.js'></script>-->\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width\">\n" +
                    "  <style>\n" +
                    "    body {\n" +
                    "      box-sizing: border-box;\n" +
                    "      margin: auto;\n" +
                    "      width: 50%;\n" +
                    "      padding: 10px;\n" +
                    "      font-family: -apple-system, BlinkMacSystemFont, sans-serif;\n" +
                    "    }\n" +
                    "    .members-count,\n" +
                    "    .members-list,\n" +
                    "    .messages {\n" +
                    "      background-color: black;\n" +
                    "      color: white;\n" +
                    "      border: 1px solid #e4e4e4;\n" +
                    "      padding: 15px;\n" +
                    "      margin-bottom: 15px;\n" +
                    "    }\n" +
                    "    .messages {\n" +
                    "      background-color: grey;\n" +
                    "      flex-shrink: 1;\n" +
                    "      overflow: auto;\n" +
                    "      color: white;\n" +
                    "    }\n" +
                    "    .message {\n" +
                    "      padding: 5px 0;\n" +
                    "    }\n" +
                    "    .message .member {\n" +
                    "      display: inline-block;\n" +
                    "    }\n" +
                    "    .member {\n" +
                    "      padding-right: 10px;\n" +
                    "      position: relative;\n" +
                    "    }\n" +
                    "    .message-form {\n" +
                    "\n" +
                    "      display: flex;\n" +
                    "      flex-shrink: 0;\n" +
                    "    }\n" +
                    "    .message-form__input {\n" +
                    "      flex-grow: 1;\n" +
                    "      border: 1px solid #dfdfdf;\n" +
                    "      padding: 10px 15px;\n" +
                    "      font-size: 16px;\n" +
                    "    }\n" +
                    "    .message-form__button {\n" +
                    "      background-color: white;\n" +
                    "      margin: 10px;\n" +
                    "      border: none;\n" +
                    "    }\n" +
                    "  </style>\n" +
                    "</head>\n" +
                    "<body style=\"background-image: url('download.jpg');background-repeat:no-repeat;background-size:cover;\">\n" +
                    "  <div class=\"members-count\">-</div>\n" +
                    "  <div class=\"members-list\">-</div>\n" +
                    "  <div class=\"messages\"></div>\n" +
                    "  <form class=\"message-form\" onsubmit=\"return false;\">\n" +
                    "    <input class=\"message-form__input\" placeholder=\"Type a message..\" type=\"text\"/>\n" +
                    "    <input class=\"message-form__button\" value=\"Send\" type=\"submit\"/>\n" +
                    "  </form>\n" +
                    "  <script src=\"./script_" + ID1 + "_"+ ID2 + ".js\"></script>\n" +
                    "</body>\n" +
                    "</html>\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter("/opt/tomcat/webapps/orkut/script_" + ID1 + "_"+ ID2 + ".js")) {
            out.println("// PS! Replace this with your own channel ID\n" +
                    "// If you use this channel ID your app will stop working in the future\n" +
                    "const CLIENT_ID = '"+ ID1 + ID2 + "t4rFLNDDotC';\n" +
                    "\n" +
                    "const drone = new ScaleDrone(CLIENT_ID, {\n" +
                    "  data: { " +
                    "    name: " + Name + ",\n" +
                    "    color: 0xFFFFFF,\n" +
                    "  },\n" +
                    "});\n" +
                    "\n" +
                    "let members = [];\n" +
                    "\n" +
                    "drone.on('open', error => {\n" +
                    "  if (error) {\n" +
                    "    return console.error(error);\n" +
                    "  }\n" +
                    "  console.log('Successfully connected to Scaledrone');\n" +
                    "\n" +
                    "  const room = drone.subscribe('observable-mc426');\n" +
                    "  room.on('open', error => {\n" +
                    "    if (error) {\n" +
                    "      return console.error(error);\n" +
                    "    }\n" +
                    "    console.log('Successfully joined room');\n" +
                    "  });\n" +
                    "\n" +
                    "  room.on('members', m => {\n" +
                    "    members = m;\n" +
                    "    updateMembersDOM();\n" +
                    "  });\n" +
                    "\n" +
                    "  room.on('member_join', member => {\n" +
                    "    members.push(member);\n" +
                    "    updateMembersDOM();\n" +
                    "  });\n" +
                    "\n" +
                    "  room.on('member_leave', ({id}) => {\n" +
                    "    const index = members.findIndex(member => member.id === id);\n" +
                    "    members.splice(index, 1);\n" +
                    "    updateMembersDOM();\n" +
                    "  });\n" +
                    "\n" +
                    "  room.on('data', (text, member) => {\n" +
                    "    if (member) {\n" +
                    "      addMessageToListDOM(text, member);\n" +
                    "    } else {\n" +
                    "      // Message is from server\n" +
                    "    }\n" +
                    "  });\n" +
                    "});\n" +
                    "\n" +
                    "drone.on('close', event => {\n" +
                    "  console.log('Connection was closed', event);\n" +
                    "});\n" +
                    "\n" +
                    "drone.on('error', error => {\n" +
                    "  console.error(error);\n" +
                    "});\n" +
                    "\n" +
                    "function getRandomColor() {\n" +
                    "  return '#' + Math.floor(Math.random() * 0xFFFFFF).toString(16);\n" +
                    "}\n" +
                    "\n" +
                    "//------------- DOM STUFF\n" +
                    "\n" +
                    "const DOM = {\n" +
                    "  membersCount: document.querySelector('.members-count'),\n" +
                    "  membersList: document.querySelector('.members-list'),\n" +
                    "  messages: document.querySelector('.messages'),\n" +
                    "  input: document.querySelector('.message-form__input'),\n" +
                    "  form: document.querySelector('.message-form'),\n" +
                    "};\n" +
                    "\n" +
                    "DOM.form.addEventListener('submit', sendMessage);\n" +
                    "\n" +
                    "function sendMessage() {\n" +
                    "  const value = DOM.input.value;\n" +
                    "  if (value === '') {\n" +
                    "    return;\n" +
                    "  }\n" +
                    "  DOM.input.value = '';\n" +
                    "  drone.publish({\n" +
                    "    room: 'observable-mc426',\n" +
                    "    message:': ' + value,\n" +
                    "  });\n" +
                    "}\n" +
                    "\n" +
                    "function createMemberElement(member) {\n" +
                    "  const { name, color } = member.clientData;\n" +
                    "  const el = document.createElement('div');\n" +
                    "  el.appendChild(document.createTextNode(name));\n" +
                    "  el.className = 'member';\n" +
                    "  el.style.color = color;\n" +
                    "  return el;\n" +
                    "}\n" +
                    "\n" +
                    "function updateMembersDOM() {\n" +
                    "  DOM.membersCount.innerText = `${members.length} users in room:`;\n" +
                    "  DOM.membersList.innerHTML = '';\n" +
                    "  members.forEach(member =>\n" +
                    "    DOM.membersList.appendChild(createMemberElement(member))\n" +
                    "  );\n" +
                    "}\n" +
                    "\n" +
                    "function createMessageElement(text, member) {\n" +
                    "  const el = document.createElement('div');\n" +
                    "  el.appendChild(createMemberElement(member));\n" +
                    "  el.appendChild(document.createTextNode(text));\n" +
                    "  el.className = 'message';\n" +
                    "  return el;\n" +
                    "}\n" +
                    "\n" +
                    "function addMessageToListDOM(text, member) {\n" +
                    "  const el = DOM.messages;\n" +
                    "  const wasTop = el.scrollTop === el.scrollHeight - el.clientHeight;\n" +
                    "  el.appendChild(createMessageElement(text, member));\n" +
                    "  if (wasTop) {\n" +
                    "    el.scrollTop = el.scrollHeight - el.clientHeight;\n" +
                    "  }\n" +
                    "}\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
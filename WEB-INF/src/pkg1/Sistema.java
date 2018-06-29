package pkg1;

import ChatServlet.CreateChatServlet;

import java.sql.SQLException;

public class Sistema {
	private static Sistema uniqueInstance;
	private static SistemaTarefa sistTarefa;
	private static SistemaComunicacao sistComunicacao;
	private static SistemaReuniao sistReuniao;
	private static MysqlConnect mysql;
	private static HTMLBuilder htmlBuild;
	private static HTMLBuilderReuniao htmlBuildReuniao;
	private static Membro usr;
	private static HTMLTarefasBuilder tarBUild;
	private static CreateChatServlet chatBuild;


	public Sistema() throws SQLException, ClassNotFoundException {
		sistTarefa = new SistemaTarefa();
		sistComunicacao = new SistemaComunicacao();
		sistReuniao = new SistemaReuniao();
		mysql = new MysqlConnect();
		htmlBuild = new HTMLBuilder();
        tarBUild = new HTMLTarefasBuilder();
        htmlBuildReuniao = new HTMLBuilderReuniao();
		chatBuild = new CreateChatServlet();
	}

	public static synchronized  Sistema getInstance() throws SQLException, ClassNotFoundException{
	    if(uniqueInstance == null)
	        uniqueInstance = new Sistema();
	    return uniqueInstance;
    }
    public static Membro getMembro() {
        return usr;
    }

    public static void setMembro(Membro mem) {
        Sistema.usr = mem;
    }

	public static SistemaTarefa getSistTarefa() {
		return sistTarefa;
	}

	public static void setSistTarefa(SistemaTarefa sistTarefa) {
		Sistema.sistTarefa = sistTarefa;
	}

	public static SistemaComunicacao getSistComunicacao() {
		return sistComunicacao;
	}

	public static void setSistComunicacao(SistemaComunicacao sistComunicacao) {
		Sistema.sistComunicacao = sistComunicacao;
	}

	public static SistemaReuniao getSistReuniao() {
		return sistReuniao;
	}

	public static void setSistReuniao(SistemaReuniao sistReuniao) {
		Sistema.sistReuniao = sistReuniao;
	}

	public static MysqlConnect getMysql() {
		return mysql;
	}

	public static void setMysql(MysqlConnect mysql) {
		Sistema.mysql = mysql;
	}

	public static HTMLBuilder getHtmlBuild() {
		return htmlBuild;
	}

	public static void setHtmlBuild(HTMLBuilder htmlBuild) {
		Sistema.htmlBuild = htmlBuild;
	}

    public static HTMLTarefasBuilder getHtmlTarefasBuilder() {
        return tarBUild;
    }

	public static HTMLBuilderReuniao getHtmlReuniaoBuilder() {
		return htmlBuildReuniao;
	}

	public static CreateChatServlet getChatBuilder(){return chatBuild;}

	public static void setHtmlTarefasBuilder(HTMLTarefasBuilder htmlBuild) {
        Sistema.tarBUild = htmlBuild;
    }

}

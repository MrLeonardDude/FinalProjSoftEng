package pkg1;


import java.util.ArrayList;

public class SqlTst {
    private static MysqlConnect mysql;
    private static Sistema sist;
    public static void main(String Args[]){
        try{
            sist = Sistema.getInstance();
            mysql = sist.getMysql();
            String querry = "Select nome,username,funcao from membros where status = 0 AND username <> 'leo@leo.leo'";
            ArrayList<String> str =mysql.sqlSelect(querry, 3);
            if(str.size() > 0) {
                for (int i = 0; i < str.size(); i = i + 3) {
                    Membro m = new Membro(str.get(i), str.get(i + 2), str.get(i + 1), Boolean.TRUE);
                    sist.getSistComunicacao().addMembroOffline(m);
                }
                System.out.println(sist.getSistComunicacao().getMembrosOffline().get(1).getNome());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}

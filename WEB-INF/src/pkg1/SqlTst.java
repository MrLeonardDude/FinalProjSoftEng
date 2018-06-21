package pkg1;


public class SqlTst {
    private static MysqlConnect mysql;
    private static Sistema sist;
    public static void main(String Args[]){
        try{
            sist = Sistema.getInstance();
            mysql = sist.getMysql();
            String nomeTarefa = "D";
            String descricao = "D";
            String dataTarefa = "DD";
            String querry = "INSERT INTO reuniao (data, local, pauta) values ('"+ dataTarefa +"', '"+nomeTarefa+"', '"+descricao+"' )";
            System.out.println(querry);
            mysql.sqlInsertTarefa(querry);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}

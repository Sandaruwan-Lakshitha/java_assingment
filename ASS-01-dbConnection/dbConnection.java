import java.sql.*;
import java.util.Scanner;


public class dbConnection {
    public static class Details{
      String id,name,address,tel;
    }
    private static final Details d = new Details();
    public static void main(String[] args) {

        System.out.println("Enter Data-->>format{CUS01 Sarath No.231,Mahagma 0714561237}");
        getData();
        insert();
        showData();

    }

    public static void getData(){
        Scanner scan = new Scanner(System.in);
        d.id =scan.next();
        d.name =scan.next();
        d.address =scan.next();
        d.tel =scan.next();
    }

    public  static void  insert(){
        try {
            String url="jdbc:mysql://localhost:3306/test";
            String admin="sandaruwan";
            String adminpwd="sandaruwanpwd";
            Connection conn=DriverManager.getConnection(url,admin,adminpwd);

            Statement stat=conn.createStatement();
            String sql = "insert into customer values('"+d.id+"','"+d.name+"','"+d.address+"',"+d.tel+")";
            stat.executeUpdate(sql);
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public static void showData(){
        try{
            String url="jdbc:mysql://localhost:3306/test";
            String admin="sandaruwan";
            String adminpwd="sandaruwanpwd";

            Connection conn=DriverManager.getConnection(url,admin,adminpwd);

            Statement stat=conn.createStatement();
            String sql="select *from customer";
            ResultSet rs =stat.executeQuery(sql);
            System.out.println("ID"+"  "+"Name"+"  "+"Address"+"  "+"Tel-Number");
            while(rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("name");
                String address=rs.getString("address");
                double tel=rs.getDouble("tel");
                //String p=id+"  "+name+"  "+address+"  "+tel+" ";
                System.out.printf("%s  %s  %s  %10.0f \n",id,name,address,tel);
            }
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }
}

//CUS02 chamal NO.123,Galle 0712345678
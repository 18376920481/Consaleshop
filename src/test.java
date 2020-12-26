import java.io.File;
import java.util.Scanner;
public class Test {
    private static String Username;

    public static void main(String[] args) {
        System.out.println("请输入用户名;");
        Scanner sc = new Scanner(System.in);
        String Username = sc.next();//阻塞方法
        System.out.println("您输入的用户名：" + Username);
        System.out.println("请输入密码：");
        String Password = sc.next();
        System.out.println("您输入的密码是：" + Password);
        File file = new File("C:\\Users\\lenovo\\IdeaProjects\\Consaleshop\\src\\test.xlsx");
        ReadExcel readExcel = new ReadExcel();//创建对象
        User users[] = readExcel.readExcel(file);
        for (int i = 0; i < users.length; i++) {
            if(Username.equals(users[i].getUsername()) && Password.equals(users[i].getPassword())){
            //if (Username.equals(users[i]).getUsername()) && Password.equals(users[i].getPassword());{
                break;
            }else{
                System.out.println("登录失败");
            }
        }
    }
}
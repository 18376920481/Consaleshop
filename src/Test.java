import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, ClassNotFoundException {
        boolean bo = true;
        while (bo) {
            System.out.println("请输入用户名;");
            Scanner sc = new Scanner(System.in);
            String Username = sc.next();//阻塞方法
            System.out.println("您输入的用户名：" + Username);
            System.out.println("请输入密码：");
            String Password = sc.next();
            System.out.println("您输入的密码是：" + Password);
            // File file = new File("C:\\Users\\lenovo\\IdeaProjects\\Consaleshop\\src\\test.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/User.xlsx");
            InputStream inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (Username.equals(users[i].getUsername()) && Password.equals(users[i].getPassword())) {
                    System.out.println("登录成功");
                    bo = false;
                    /*显示商品*/
                    ReadproductExcel readproductExcel = new ReadproductExcel();
                    Product products[] = readproductExcel.getAllProduct(inProduct);
                    for (Product product : products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getDsc());
                    }
                    System.out.println("请输入商品ID把该商品加入购物车");
                    String Id = sc.next();
                    int count = 0;
                    /*创建一一个购物车的数组：存的是商品
                     */
                    Product carts[] = new Product[3];
                    /*根据此ID去ExCel中查找是否有该ID的商品信息。如果有则返回该商品即可*/
                    inProduct = null;
                    inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                    Product product = readproductExcel.getProductById(Id, inProduct);
                    System.out.println("要购买的商品价格：" + product.getPrice());
                    if (product != null) {
                        carts[count++] = product;
                    }
                    System.out.println("继续购买商品请按1");
                    System.out.println("查看购物车请按2");
                    int choose = sc.nextInt();
                    if (choose == 1) {
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        readproductExcel = new ReadproductExcel();
                        products = readproductExcel.getAllProduct(inProduct);
                        for (Product p : products) {
                            System.out.print(product.getId());
                            System.out.print("\t" + product.getName());
                            System.out.print("\t" + product.getPrice());
                            System.out.println("\t" + product.getPrice());
                        }
                        System.out.println("请输入商品ID把商品加入购物车");
                        Id = sc.next();
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        product = readproductExcel.getProductById(Id, inProduct);
                        System.out.println("要购买的商品价格：" + product.getPrice());
                        if (product!= null) {
                            carts[count++] = product;
                        }
                        break;
                    }
                    else if (choose == 2) {

                        /*查看购物车*/
                          /*
                            Product []Products=new Product[5];
                            Product Product=new Product();
                            product.setId("1");
                            product.setName("华为");
                            product.setPrice("3800");
                            product.setDsc("5G");
                            System.out.print(product.getId());
                            System.out.print("\t" + product.getName());
                            System.out.print("\t" + product.getPrice());
                            System.out.println("\t" + product.getPrice());*/
                        System.out.println("当前购物车里的商品如下：");
                        for(Product  p :carts){
                            if(p!=null){
                                System.out.print(product.getId());
                                System.out.print("\t" + product.getName());
                                System.out.print("\t" + product.getPrice());
                                System.out.println("\t" + product.getDsc());
                            }
                        }
                    }
                }
                else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}






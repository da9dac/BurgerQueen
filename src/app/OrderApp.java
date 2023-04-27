package app;

import app.product.Product;
import app.product.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    public OrderApp() {

    }
    public void start() {//애를 호출
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        //아까 여기서 가져온거처럼
        Product[] products = productRepository.getProducts();

        Menu menu = new Menu(products);
        //카트 클래스의 메소드를 사용해야하니
        Cart cart = new Cart(productRepository, menu);
        //저희가 코드를 작성하면서 카트 클래스의 생성자를 수정했으니
        //카트 클래스로 가서 생성자를 확인해봐요
        //메뉴는 위에 마침 선언해둔게 있으니
        System.out.println("🍔 BurgerQueen Order Service");

        while (true) {
            menu.printMenu();
            String input = scanner.nextLine();
            //카트 클래스 사용해서
            if (input.equals("+")) {//입력 받은게 +면 주문내역 출력 및 프로그램 종료
//                주문 내역 출력
                break;
            }
            else {
                int menuNumber = Integer.parseInt(input);
                //입력을 스트링으로 받았으니
                //addToCart(menuNumber) 이 메소드는 인트형 메뉴번호를
                //받아야하니 인트형으로 바꿔서 변수에 담고

                if (menuNumber == 0) cart.printCart(); //0이라면 장바구니 출력
                else if (1 <= menuNumber && menuNumber <= products.length){
                    cart.addToCart(menuNumber);
                    //1에서 상품목록의 길이만큼이면 현재는 6까지니
                    //상품을 제대로 골랐다는 뜻이고
                    //상품번호를 그대로 addToCart메소드에 보내서
                    //주문을 시작해요
                }
            }
        }
    }
}

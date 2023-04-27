package app;

import app.product.Product;
import app.product.ProductRepository;

public class Main {

    public static void main(String[] args) {
        OrderApp orderApp = new OrderApp();
        orderApp.start();
        //이제 다 대충 만들었으니 시작해보면
        //이게 상품저장소의 배열에 있는 상품 중 하나를
        // product 라는 변수에 담아서 이거 하나만으로
        //주문을 반복하니 값이 하나는 적용되지 않는 경우가 있어서
        //product를 가져와서 newProduct라는 변수에 한번 더
        //옮겨주는 작업이 필요해요
        //음...
    }
}

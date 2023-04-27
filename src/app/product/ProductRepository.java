package app.product;

import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class ProductRepository {//이 클래스에 있는거니까
    //이제 생성자를 다 만들었으니
    //방금 만든 생성자를 사용해서 상품저장소에
    //상품목록을 만들어야해요
    //상품은 당연히 상품 타입이니
    //상품타입의 배열에 담아주면 되요

    //만약 햄버거 메뉴를 추가한다치면
    //햄버거의 생성자는 매개변수가 조상4 본인2 해서 6개니까
    // 6개의 매개변수를 모두 입력해주시면 되요
    //id, name price kcal 세트여부 세트가격

    //이 상품 배열을 사용해야 하니
    private Product[] products = new Product[] {
        new Hamburger(1,"새우버거",3500, 500, false, 4500),//여기 세미콜론 찍으시면 안되요 계속 입력해야해서
        new Hamburger(2,"치킨버거",4000, 600, false, 5000),
        //이제 사이드를 추가할 차례니 사이드의 생성자를 추가해요
        //사이드는 인자가 5개니 5개를 채워줘요
        new Side(3,"감자튀김", 1000, 300, 1),
        new Side(4,"어니언링", 1000, 300, 1),
        //이제 음료 할 차례니 마찬가지로 음료 생성자를 추가
        new Drink(5,"코카콜라",1000,200,true),//기본값을 true로 바꿀게요
        new Drink(6,"제로콜라",1000,0,true),
    };
    //이러면 상품목록 끝
    //이 상품 목록을 다른 클래스에 전달해줘야하니
    public Product[] getProducts() {
        return products;
        //이 배열 전체를 리턴해주는 getter를 만들어서
        //애를 앞으로 메뉴나 카트 클래스에서 사용할거에요
    }
    //애를 사용해서 저 생성자에 배열을 보내줘야해요

    //여기에서 id를 받아서 일치하는 상품을 반환해주는 메소드를 만들어요
    //외부에서 접근 할 수 있어야 하니 public
    //상품을 찾아서 그 상품을 반환해야하니 반환타입은 Product
    public Product findById(int productId) {//id를 전달 받아야하니 매개변수로 인트타입
        //상품타입의 배열에서 아이디와 일치하는걸 찾아야하니
        //일단은 무조건 배열을 처음부터 돌아야해요
        for (Product product : products) {
            //조건문으로 매개변수로 받은 int productId
            //저거랑 product애의 id가 일치하는지 비교해요
            if(productId == product.getId()) {
                //일치하면 해당 상품을 리턴
                return product;
            }
        }
        //일치하지 않을 경우에는 아무것도 반환하지 않을거니
        return null;
    }
    //이제 이 메소드를 사용하면 되요
}

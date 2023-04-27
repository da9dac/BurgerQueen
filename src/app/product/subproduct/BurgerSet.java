package app.product.subproduct;

import app.product.Product;

public class BurgerSet extends Product { //애도 당연히 상품을 상속
    //이 햄버거 세트는 햄버거 + 사이드 + 음료니까 애네를 멤버로 가지고 있어야해요
    private Hamburger hamburger;
    private Side side;
    private Drink drink;

    public BurgerSet(String name, int price, int kcal, Hamburger hamburger, Side side, Drink drink) {
        super(name, price, kcal);
        //이러면 이제 버거세트의 조상 클래스인 상품 클래스에
        //3개를 입력 받는 생성자가 없다고 하니 3개짜리를 만들어줘요
        //그리고 지금 햄버거 클래스에 있는 자기 멤버만
        this.hamburger = hamburger;
        this.side = side;
        this.drink = drink;
    }//아니면 애를 수정해도 상관 없으니 애를 수정할게요
    //이 id는 매개변수로 전달 해주지 않을거니 지우면 해결

    public Hamburger getHamburger() {
        return hamburger;
    }

    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }
}

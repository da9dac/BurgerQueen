package app.product.subproduct;

import app.product.Product;

public class Hamburger extends Product { //상품의 공통 요소를 상속 받아야하니
    //이제 햄버거에만 있는 속성을 멤버로 추가해줘요
    //( 단품 / 세트 여부, 세트 가격 )
    private boolean isBurgerSet;//이 햄버거세트여부 값을 컨트롤 해야하니
    private int burgerSetPrice;

    //여기도 마찬가지로
    //조상 클래스인 프로덕트의 멤버+자기멤버 해서 총 6개를 매개변수로
    //int id, String name, int price, int kcal 애네는 조상 멤버니까
    //super를 통해서 조상생성자로 사용해야해요
    public Hamburger(int id, String name, int price, int kcal, boolean isBurgerSet, int burgerSetPrice) {
        super(id, name, price, kcal);
        //그리고 지금 햄버거 클래스에 있는 자기 멤버만
        this.isBurgerSet = isBurgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }
    //그래서 햄버거를 만드는 생성자를 하나 새로 만들어요
    public Hamburger(Hamburger hamburger) {
        super(hamburger.getName(), hamburger.getPrice(),
                hamburger.getKcal());
        //이걸 복사생성자라고 하는데
        //이건 저도 아직 설명을 잘 못하겠네요...
        this.isBurgerSet = hamburger.isBurgerSet();
        this.burgerSetPrice = hamburger.getBurgerSetPrice();
    } //햄버거 클래스에서 만든 복사생성자를 이용해서
    //메뉴 4개 클래스도 마찬가지로 애는 일단 나중에 할게요
//    public boolean setBurgerSet() {
//        if
//    }

    //아 getter를 안만들었네요
    public boolean isBurgerSet() {
        return isBurgerSet;
    }

    public void setIsBurgerSet(boolean isBurgerSet) {
        this.isBurgerSet = isBurgerSet;
    }//애는 버거의 세트 여부를 바꾸는 setter

    public int getBurgerSetPrice() {
        return burgerSetPrice;
    }//애는 버거의 세트 가격을 가져오는 getter

    public void setBurgerSetPrice(int burgerSetPrice) {
        this.burgerSetPrice = burgerSetPrice;
    }//애는 버거의 세트 가격을 바꾸는 setter
}

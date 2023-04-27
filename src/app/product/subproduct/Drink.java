package app.product.subproduct;

import app.product.Product;

public class Drink extends Product {
    //애도 멤버를
    //빨대 유무  요거 하나 추가
    private boolean hasStraw;

    //그 다음에 마찬가지로 생성자
    public Drink(int id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        //그리고 지금 음료 클래스에 있는 자기 멤버만
        this.hasStraw = hasStraw;
    }
    public Drink(Drink drink) {
        super(drink.getName(), drink.getPrice(), drink.getKcal());
        this.hasStraw = drink.hasStraw();
    }
    public boolean hasStraw() {
        return hasStraw;
    }

    public void setHasStraw(boolean hasStraw) {
        this.hasStraw = hasStraw;
    }
}

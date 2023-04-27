package app.product.subproduct;

import app.product.Product;

public class Side extends Product { //여기도 마찬가지로 상품 속성 상속
    //애는 케첩 개수
    private int ketchup;
    //애도 마찬가지로
    public Side(int id, String name, int price, int kcal, int ketchup) {
        super(id, name, price, kcal);
        //그리고 지금 사이드 클래스에 있는 자기 멤버만
        this.ketchup = ketchup;
    }
    //일단 나머지도 복사 생성자를 만들어줘요
    //일단은 그냥 자기 자신을 매개변수로 받아서
    //저장공간이 겹치지 않는 다른 참조변수(주소)를 가진
    //애를 복사한다는거에요
    public Side(Side side) {
        super(side.getName(), side.getPrice(), side.getKcal());
        this.ketchup = side.getKetchup();
    }
    //애네도 만들어줘야해요...
    public int getKetchup() {
        return ketchup;
    }

    public void setKetchup(int ketchup) {
        this.ketchup = ketchup;
    }
}

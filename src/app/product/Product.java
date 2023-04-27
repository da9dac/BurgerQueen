package app.product;

public class Product {
    //일단은 상품마다 공통적인 속성을 이 상품 클래스의 멤버로 만들어줘야해요
    //상품 = ( 번호, 이름, 가격(원), 열량(Kcal) ) << 애네
    private int id;//id는 인트타입이니까
    private String name;
    private int price;
    private int kcal;
    //애네 4개의 값을 외부에서 관리해야하니
    //public으로 메소드를 만들어줘요

    //이제 각 클래스마다 생성자를 만들어줘야해요
    //이 생성자는 계속 사용해야하니 외부에서도 접근 가능하게 퍼블릭으로
    //이제 이 괄호에 위에 멤버들을 다 넣어줘야해요
    public Product(int id, String name, int price, int kcal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }
    //복사해서
    public Product(String name, int price, int kcal) {
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }
    //이렇게 3개짜리만
    //이제 애네 클래스들의 값을 가져오고 바꿀
    //getter랑 setter를 만들어줘요

    //애넨 getter
    public int getId() {
        return id;
    }

    public int getKcal() {
        return kcal;
    }

    public int getPrice() { //요거!
        return price;
    }

    public String getName() {
        return name;
    }
    //이제 setter

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    //이제 상품 클래스는 끝
}

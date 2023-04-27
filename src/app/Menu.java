package app;

import app.product.Product;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class Menu {
    //여기서 멤버로 선언해줘야해요
    //멤버들은 꼭 private으로!
    private Product[] products;//이제 이 배열을 읽어서 불러올게요

    //이 메뉴 클래스를 외부에서 사용해야하니 생성자를 만들어줘야해요
    //private Product[] products; 저희가 메뉴를 출력하는데
    //애를 사용했으니까 다른 클래스에서 똑같은 결과를 보려면
    //저걸 사용해야해서 생성자에 재를 추가해줘야해요
    public Menu(Product[] products) { //메뉴의 생성자를 확인하고
        this.products = products;
    }//상품배열을 전달 받아야하니

    //메뉴를 출력할 메소드를 하나 만들어요
    //애는 출력만 할거니까 반환값이 필요 없으니 void
    public void printMenu() { //이 메소드를 실행할거에요
        //저거를 만들어야하니
        System.out.println("[\uD83D\uDD3B] 메뉴");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);
        //메뉴를 고르는 곳에선 가격이 표시된 메뉴판을 출력해야하니
        //트루로
        //사실 여기 귀찮은데 패스해도 상관없어요

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    public void printDrinks(boolean printPrice) {
        System.out.println("\uD83E\uDD64 음료");
        for (Product product : products) {
            //이제 받아온 product가 햄버거 타입인지 확인해서
            //햄버거 타입만 출력해야해요
            if (product instanceof Drink) {
                //그래서 햄버거라면 햄버거만 출력되게
                //저 상품의 번호 이름 칼로리 가격을 받아와요
                printEachMenu(product, printPrice);
            }
            //그러면 이 메소드를 사용 하는 곳에서도 트루나 펄스를 입력 받아야하니
        }
    }

    //근데 이 사이드 메뉴는 지금 private로 보호받고 있어서
    //사용을 못하기 때문에 public으로 바꿔줘요
    //음료 메뉴도 필요하니 음료랑 사이드 메소드를 publice으로

    //그리고 이제 이 printSide 음료 햄버거 애들을 호출하는 곳을
    //true나 false를 넘겨주게 수정해야해요
    public void printSides(boolean printPrice) {
        //위에 코드를 복사해서
        //나머지 사이드랑 음료도 출력해줘요
        System.out.println("\uD83C\uDF5F 사이드");
        for (Product product : products) {
            //이제 받아온 product가 햄버거 타입인지 확인해서
            //햄버거 타입만 출력해야해요
            if (product instanceof Side) {
                //그래서 햄버거라면 햄버거만 출력되게
                //저 상품의 번호 이름 칼로리 가격을 받아와요
                printEachMenu(product, printPrice);
            }
        }
    }
    //사이드랑 음료 메뉴 출력 메소드를 한 번 더 나눌거래요
    //이 프로그램이 처음 시작할 때랑 주문 뒤에
    //전체 메뉴를 출력하는거랑
    //옵션을 선택할 때 보여주는 메뉴의 모양이 다르니
    //그걸 귀찮지만 나눌거에요

    private void printHamburgers(boolean printPrice) {
        System.out.println("\uD83C\uDF54 햄버거");
        //products 배열에 있는 상품들은 다 Product 타입이니
        //저 타입으로 값을 받아와야해요
        for (Product product : products) {
            //이제 받아온 product가 햄버거 타입인지 확인해서
            //햄버거 타입만 출력해야해요
            if (product instanceof Hamburger) {
                //그래서 햄버거라면 햄버거만 출력되게
                //저 상품의 번호 이름 칼로리 가격을 받아와요
                printEachMenu(product, printPrice);//방금 수정한 메소드가 매개변수를 하나
                //더 입력 받아야하니 추가해줘요
            }
        }
    }

    //기존의 메소드를 조건문을 추가해서 두가지 경우에 맞게 출력되게
    private static void printEachMenu(Product product, boolean printPrice) {
        if (printPrice) System.out.printf("   (%d) %s %5dKcal %5d원\n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
        else System.out.printf("   (%d) %s %5dKcal\n", product.getId(), product.getName(), product.getKcal());
    }
    //근데 조건에 따라 출력하려면 조건을 입력 받아야하니
    //이 메소드의 매개변수에 하나를 더 입력 받아요
    //가격을 보여줄지 말지를 입력받을거니 boolean형태로
}

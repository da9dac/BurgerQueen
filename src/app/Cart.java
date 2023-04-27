package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subproduct.Hamburger;
import app.product.subproduct.BurgerSet;
import app.product.subproduct.Side;
import app.product.subproduct.Drink;

import java.util.Scanner;

public class Cart {
    private Scanner scanner = new Scanner(System.in);
    //먼저 장바구니로 사용할 배열을 하나 만들어야해요
    //장바구니는 여러가지 상품이 당기니 당연히 배열로!
    //상품을 저장할거니 상품타입의 배열
    Product[] items = new Product[0];
    //이 장바구니 배열을 저희가 맨첨에 길이를 0으로 설정 했으니
    //상품을 하나 넣으려면 길이를 하나 늘려줘야해요
    //1차원 배열을 생성할 때는 길이를 무조건 지정해줘야하는데
    //저희는 길이를 모르니 일단은 0으로 만들고 나중에 늘려줄거에요

    //일단 생성자가 없으니 당장은 가져온 클래스도 없으니 기본생성자 사용
    //저희가 카트 클래스는 생성자를 하나도 만들지 않았으니 기본으로
    //public Cart() {} // 이 생성자가 생성되서 방금은 매개변수를 안채워도 되는거에요
    //저 메소드는 ProductRepository 클래스에 있는거니
    //메뉴에 있는 클래스를 사용하려면 메뉴 클래스를 가져와야하니
    //이거랑 똑같이
    private ProductRepository productRepository = new ProductRepository();
    private Menu menu = new Menu(productRepository.getProducts());
    //상품저장소에서 배열을 가져오는 메소드 활용해서 배열을 매개변수로 줘요
    //메뉴 클래스를 카트 클래스에서 사용 중이니 애도 당연히 카트의 생성자에 추가
    //다른 클래스를 사용하려 가져왔으니 자기의 생성자에 또 추가해줘야해요
    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }
    //상품저장소 말고 메뉴도 전달 받아야하네요

//    장바구니 담기 → addToCart()
    //어 이거 안만들었네요
    //이제 addToCart 메소드를 만들거에요
    //메소드 만들 때 반환타입을 어떻게 해야할지 당장 생각이 안나면
    //일단은 void로 만들고 시작
    public void addToCart(int productId) {//인트타입으로 매개변수를 받아요
        //클래스를 사용할 준비가 되었으니 메소드를 호출해줘요
        //매개변수로 받아온 값을
        //근데 상품을 받아오면 저장할 변수가 필요하니
        //상품타입의 변수를 아무거나 만들어줘요
        Product product = productRepository.findById(productId);
        //사용자가 고른 상품이 담긴 product를 newProduct에 옮길건데
        Product newProduct;//일단 옮길 변수를 하나 만들고
        if (product instanceof Hamburger) newProduct = new Hamburger((Hamburger) product);
        //이프문 첫번째는 상품이 햄버거면
        //새로 만든 newProduct에 기존 product가 가지고 있던 상품 정보를
        //토대로 같지만 주소만 다른 햄버거를 복사해서 담아요


        else if (product instanceof Side) newProduct = new Side((Side) product);
        //나머지도 위와 똑같은 구조
        else newProduct = new Drink((Drink) product);



        //그러면 이제 저 product라는 변수에 방금 가져온
        //2번을 골랐다면 치킨버거의 정보가 담겨요
        //저 메소드에 넘겨줘서 일치하는 상품을 받아와요

        //그러면 이제 상품을 가지고 있는 객체는 product도 맞지만
        //product를 계속 사용하면 지금과 같은 오류가 계속 생기니
        //newProduct를 사용해서 기존 작업들을 진행해야해요
        //product가 들어가던 곳을 다 새로만든거로 바꿔줘야해ㅔ요
        chooseOption(newProduct);//이제 이 메소드가 실행될 차례니 이 메소드를 작성해줘요


        if (newProduct instanceof Hamburger) { // 상품이 햄버거인지 확인하고
            //햄버거라면 상품의 타입을 햄버거로 바꿔서
            Hamburger hamburger = (Hamburger) newProduct;
            if (hamburger.isBurgerSet()) newProduct = composeSet(hamburger);
            //햄버거의 세트여부가 트루라면 상품을 세트를 완성하는 메소드로 보내줘요
        }

//        //이제 상품이 다 만들어졌으니 장바구니에 추가해줘야 하는데
        //길이가 장바구니보다 1긴 배열을 하나 새로 만들게요\
        //상품을 담을 배열이니 프로덕트 타입
        //장바구니가 items 니까 애의 길이인 length에 +1 해주면
        Product[] newItems = new Product[items.length + 1];
        //이제 이 새로운 배열에 기존의 장바구니를 다시 담아줘야해요
        System.arraycopy(items,0,newItems,0, items.length);
        //items의 0번째 인덱스부터  새로 만든 배열이 newItems의
        //0번째 배열(맨처음)에 items 배열의
        newItems[newItems.length-1] = newProduct;
        items = newItems; //그리고 기존 작은 장바구니를 큰 새로운 장바구니로 바꾸면
        //장바구니에 4개가 담기게 되는 구조

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.",product.getName());
    }
//    옵션 고르게 하기 → chooseOption()
    private void chooseOption(Product product) {//상품을 받아와야하니까
        String input;//입력 받은 값이 문자열이니 문자열 2로 비교하려면
        // ==이 아니라 equals로!
        //방금 매개변수로 받아온 상품이 Product product
        if (product instanceof Hamburger) {//사이드 타입을 보냈으니 이 조건문에는 해당이 안되;고
            //단품과 세트의 가격을 따로 출력해야하니
            System.out.printf(
                    "단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)",
                    product.getPrice(),((Hamburger) product).getBurgerSetPrice()
                    );// ((Hamburger) product) 여기도 형변환
                    //햄버거 세트의 가격은 상품 클래스엔 없고 햄버거 클래스에만 있으니
            input = scanner.nextLine();
            if (input.equals("2")) { //만약 세트를 선택했다면
                ((Hamburger) product).setIsBurgerSet(true);
                //햄버거 클래스에 있는 세트여부를 트루로
            }
        }
        else if (product instanceof Side) {//여기가 타입이 일치하니 이 조건문이 실행
            //그래서 사이드의 옵션을 선택하는 조건문 실행
            System.out.println("케첩은 몇 개가 필요하신가요?");
            input = scanner.nextLine();//입력받은 값이 문자열이라
            //정수형으로 바꿔주기 위해
            ((Side) product).setKetchup(Integer.parseInt(input));
            //상품 리모컨으로 사이드의 케찹을 건들기 위해
            //사이드 리모컨으로 바꿔서 케찹을 input만큼 변경
        }
        else if (product instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = scanner.nextLine();
            if (input.equals("2")) {
                //product의 hasStraw를 false로 바꿈
                //마찬가지로 상품에는 빨대여부 멤버가 없으니
                //빨대여부 멤버가 있는 음료 리모컨으로 형변환
                ((Drink) product).setHasStraw(false);
            }
        }
    }
    //이 메소드는 끝
    //    햄버거 세트 구성하기 → composeSet()

    //애는 햄버거 세트를 만들고 반환해야 하니
    //반환 타입이 BurgerSet 햄버거 세트 클래스여야 해요
    //그리고 아까 선택한 상품을 세트로 만들어야 하니
    //아까 선택한 상품을 매개변수로 입력 받아요
    //햄버거 세트를 만드려면 당연히 햄버거를 골랐다는거니
    //전달받는 타입은 햄버거
    private BurgerSet composeSet(Hamburger hamburger) {
        //햄버거의 세트를 구성하는 메소드
        //햄버거 + 사이드 + 음료
        System.out.println("사이드를 골라주세요");
        //메뉴는 아까 저희가 메뉴 클래스에서 만들어둔걸
        //다시 사용해요 두번 만들 필요는 없으니
        //이제 가져온 메뉴 클래스를 사용해서
        menu.printSides(false); //사이드 메뉴 출력 메소드를 사용
        String sideId = scanner.nextLine();
        Side side = (Side)(productRepository.findById(Integer.parseInt(sideId)));//sideId를 id로 가지는 상품 검색
        //애네도 마찬가지로 아까 만든 복사생성자들로 새로 만들어줘요
        Side newSide = new Side(side); // 기존 side변수에 담아뒀던 애를
        //복사생성자의 매개변수로 전해주고 새로 만들어진 객체를
        //newSide 변수에 담아주고
        chooseOption(newSide); //기존에 side를 매개변수로 주던거도
        //newSide로!
        //이 상품 찾는 메소드에서 가져온 상품은 타입이 상품이라
        //Side side 사이드 타입의 변수에 담을 수 없으니
        //side타입으로 형변환 해서 담기!
        //상품을 검색하는 메소드도 아까 만들어둔거 재사용
//        사이드 옵션 선택
        //옵션선택 메소드도 아까 바로 위에 만들어둔거 재사용
        //사이드 상품을 담아서 저 메소드로 보내면
        System.out.println("음료를 골라주세요.");
//        음료 메뉴 출력 이거도 마찬가지로 아까 만들어둔
        menu.printDrinks(false); //재사용!
        //옵션 선택에서 출력되는 메뉴는 값을 표현안하는걸 출력하게 false
//        String drinkId = 사용자 입력 받기
//        Drink drink = drinkId를 id로 가지는 상품 검색
//        드링크 옵션 선택
        //위에랑 똑같이
        //이름만 음료로 바꾸기
        String drinkId = scanner.nextLine();
        Drink drink = (Drink) (productRepository.findById(Integer.parseInt(drinkId)));
        //여기도 똑같이
        Drink newDrink = new Drink(drink);
        chooseOption(newDrink);
        String name = hamburger.getName() + "세트";
        int price = hamburger.getBurgerSetPrice();//hamburger의 BurgerSetPrice필드의 값
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();//햄버거, 사이드, 드링크의 칼로리 총합
//
        return new BurgerSet(name, price, kcal, hamburger, newSide, newDrink);
        //여기가 빨간줄이 뜨는데
        //BurgerSet의 생성자에 6개의 매개변수를 넘겨주려고 하는 상황에서
        //매개변수가 너무 적다고 하니까 BurgerSet 클래스를 확인
        //버거세트의 생성자는 7개를 입력 받아야 하는데
        //6개를 주려고 하니 부족해서 오류가 있으니
        //버거세트의 생성자를 6개짜리로 하나를 더 만들어서 사용해요
    }
//    장바구니 출력하기 → printCart()
    //장바구니 출력 먼저 만들게요
    //애도 반환할 값은 없고 출력만할거니 반환타입은 보이드

    //이제 printCart 메소드를 다 완성 했으니 테스트로 호출해볼게요
    //애는 Cart 클래스니
    public void printCart() { //이 퍼블릭 상태인 메소드를 사용해서
        //장바구니의 내용을 출력하려면 이 장바구니 배열을 읽어야하니
        //배열을 읽으려면 무조건 for문!
        //장바구니 배열에 있는 요소들은 모두 상품타입이니
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printCartItemDetails();//장바구니 출력하는 메소드 호출
        //그래서 저 메소드로 이제 장바구니를 출력하고

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());
        //여기에 저 변수 값이 들어가서 출력되요
        //이제 저 금액합계 이거를 구할 메소드를 만들어야해요

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scanner.nextLine();
    }

    private void printCartItemDetails() { //장바구니 출력하는 메소드

        for (Product product : items) { //장바구니 배열의 상품을 하나하나 받아서
            if (product instanceof BurgerSet) { //상품이 버거세트 타입인지 확인
                BurgerSet burgerSet = (BurgerSet) product; // 아래 설명 참고
                //(BurgerSet) 이 괄호가 아까 말한 형변환이에요
                //
                System.out.printf(
                        "  %s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "있음" : "없음"
                );
            }
            else if (product instanceof Hamburger) {
                // 애도 마찬가지로 햄버거타입 이라면 그에 맞는 프린트문을
                System.out.printf(
                        "  %-8s %6d원 (단품)\n",
                        product.getName(),
                        product.getPrice()
                );
            }
            else if (product instanceof Side) { //나머지 사이드랑 음료모 똑같이
                System.out.printf(
                        "  %-8s %6d원 (케첩 %d개)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup()  // 아래 설명 참고
                );
            }
            else if (product instanceof Drink) {
                System.out.printf(
                        "  %-8s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "있음" : "없음"  // 아래 설명 참고
                );
            }
        }
    }
    //호출할거니까 어차피 이 클래스에서만 사용하니
    //private으로 생성
    //근데 애는 금액 합계 << 애를 리턴해야 하니까
    //돈은 숫자(정수)니까 반환타입은 인트 타입
    private int calculateTotalPrice() {
        int totalPrice = 0;//장바구니에 담긴 물품의 전체 가격을 담을 변수
        //이제 저 전체 가격을 계산해주려면
        //장바구니를 처음부터 끝까지 돌면서 = for문
        //상품의 가격만 더해주면 되죠 = getPrice()
        //item은 장바구니에서 하나씩 꺼내올 상품, items는 맨처음에 만든 장바구니 배열
        for (Product item : items) {
            totalPrice += item.getPrice();//배열을 돌면서 item 상품의 가격만 계속 더해주는거에요
            //맨처음에 만든 변수에
        }
        //끝!
        return totalPrice;//애를 리턴해주면
        //이 리턴 값이 이 메소드를 호출한 곳으로 리턴되서
    }
}

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll  // тут описываются действия перед всеми тестами
    static void beforeAll(){    // обязательно указать static!!!
        System.out.println("\n### beforeAll() - Выполняется перед всеми тестами\n");
    }

    @AfterAll  // тут описываются действия после всех тестов
    static void afterAll(){    // обязательно указать static!!!
        System.out.println("\n### afterAll() - Выполняется после всех тестов\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("###     beforeEach() - Выполняется перед каждым тестом");
        result = getResult();
    }

    @AfterEach
    void afterEach(){
        System.out.println("###     afterEach() - Выполняется после каждого теста\n");
        result = getResult();
    }

    @Test
    void test1() {
        System.out.println("###       test1()");
        Assertions.assertTrue(3 > 2);

    }
    @Test
    void test2() {
        System.out.println("###        test2()");
        Assertions.assertTrue(3 > 2);

    }
    @Test
    void test3() {
        System.out.println("###        test3()");
        Assertions.assertTrue(3 > 3);

    }
    @Disabled
    @Test   // метка для JUnit - обозначающая что это тест для запуска
    void successfulSearchTest(){
        open("https://www.google.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $("id=search").shouldHave(text("https://selenide.com"));
    }

    int getResult(){
        return 3;
    }
}

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll  // ��� ����������� �������� ����� ����� �������
    static void beforeAll(){    // ����������� ������� static!!!
        System.out.println("\n### beforeAll() - ����������� ����� ����� �������\n");
    }

    @AfterAll  // ��� ����������� �������� ����� ���� ������
    static void afterAll(){    // ����������� ������� static!!!
        System.out.println("\n### afterAll() - ����������� ����� ���� ������\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("###     beforeEach() - ����������� ����� ������ ������");
        result = getResult();
    }

    @AfterEach
    void afterEach(){
        System.out.println("###     afterEach() - ����������� ����� ������� �����\n");
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
    @Test   // ����� ��� JUnit - ������������ ��� ��� ���� ��� �������
    void successfulSearchTest(){
        open("https://www.google.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $("id=search").shouldHave(text("https://selenide.com"));
    }

    int getResult(){
        return 3;
    }
}

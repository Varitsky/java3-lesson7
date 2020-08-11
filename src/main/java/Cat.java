public class Cat {
    @BeforeSuite
    public void beforeSuite1() {
        // Без приоритета default 5
        System.out.println("BeforeSuite1");
    }

//    @BeforeSuite
//    public void beforeSuite2() {
//        System.out.println("BeforeSuite2");
//    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("test1 with priority 1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("test2 with priority 2");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("test3 with priority 3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("test4 with priority 4");
    }

    @Test(priority = 5)
    public void test5() {
        System.out.println("test5 with priority 5");
    }

    @Test(priority = 6)
    public void test6() {
        System.out.println("test6 with priority 6");
    }

    @Test(priority = 7)
    public void test7() {
        System.out.println("test7 with priority 7");
    }

    @Test(priority = 8)
    public void test8() {
        System.out.println("test8 with priority 8");
    }

    @Test(priority = 9)
    public void test9() {
        System.out.println("test9 with priority 9");
    }

    @AfterSuite
    public void afterSuite1() {
        // Без приоритета default 5
        System.out.println("AfterSuite1");
    }

//    @AfterSuite
//    public void afterSuite2() {
//        // Без приоритета default 5
//        System.out.println("AfterSuite2");
//    }

}
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/*
Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами
методов с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в
качестве параметра передается или объект типа Class, или имя класса. Из «класса-теста» вначале
должен быть запущен метод с аннотацией @BeforeSuite если такой имеется, далее запущены методы
с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite. К каждому
тесту необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет
выбираться порядок их выполнения, если приоритет одинаковый то порядок не имеет значения.
Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном
экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования»
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class c = Cat.class; // Почему бы и не кот.
        String className = "Cat";
//        start(c);
        start(className);
    }

    public static void start(Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object virtualCat = c.newInstance(); // Cоздаем экземляр класса с помощью рефлексии.
        Method[] methods = c.getDeclaredMethods();

        /**
         * Сначала проверяем на повторы
         * BeforeSuit & AfterSuit
         */
        int before = 0;
        int after = 0;

        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (before == 0) before++;
                else throw new RuntimeException("BeforeSuite должен быть в единственном экземпляре.");
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (after == 0) after++;
                else throw new RuntimeException("AfterSuite должен быть в единственном экземпляре.");
            }
        }

        /**
         * Теперь запускаем Before
         * Цикл по Test
         * After
         */

        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                o.invoke(virtualCat);
            }
        }

        for (int i = 9; i >= 0; i--) {
            for (Method o : methods) {
                if (o.isAnnotationPresent(Test.class)) {
                    if (o.getAnnotation(Test.class) != null) {
                        if (o.getAnnotation(Test.class).priority() == i) {
                            o.invoke(virtualCat);
                        }
                    }
                }
            }
        }

        for (Method o : methods) {
            if (o.isAnnotationPresent(AfterSuite.class))
                o.invoke(virtualCat);
        }
    }





    public static void start(String className) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        Class c = Class.forName(className); // Почему бы и не кот.
        Object virtualCat = c.newInstance(); // Cоздаем экземляр класса с помощью рефлексии.
        Method[] methods = c.getDeclaredMethods();

        /**
         * Сначала проверяем на повторы
         * BeforeSuit & AfterSuit
         */
        int before = 0;
        int after = 0;

        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (before == 0) before++;
                else throw new RuntimeException("BeforeSuite должен быть в единственном экземпляре.");
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (after == 0) after++;
                else throw new RuntimeException("AfterSuite должен быть в единственном экземпляре.");
            }
        }

        /**
         * Теперь запускаем Before
         * Цикл по Test
         * After
         */

        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                o.invoke(virtualCat);
            }
        }

        for (int i = 9; i >= 0; i--) {
            for (Method o : methods) {
                if (o.isAnnotationPresent(Test.class)) {
                    if (o.getAnnotation(Test.class) != null) {
                        if (o.getAnnotation(Test.class).priority() == i) {
                            o.invoke(virtualCat);
                        }
                    }
                }
            }
        }

        for (Method o : methods) {
            if (o.isAnnotationPresent(AfterSuite.class))
                o.invoke(virtualCat);
        }
    }
}
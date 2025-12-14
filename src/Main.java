import functions.*;
import functions.basic.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторная работа №5: Переопределение методов ===");

        // Тест 1: FunctionPoint
        System.out.println("\n1. Тестирование FunctionPoint:");
        testFunctionPoint();

        // Тест 2: ArrayTabulatedFunction
        System.out.println("\n2. Тестирование ArrayTabulatedFunction:");
        testArrayTabulatedFunction();

        // Тест 3: LinkedListTabulatedFunction
        System.out.println("\n3. Тестирование LinkedListTabulatedFunction:");
        testLinkedListTabulatedFunction();

        // Тест 4: Сравнение разных реализаций
        System.out.println("\n4. Сравнение Array и LinkedList реализаций:");
        testDifferentImplementations();

        // Тест 5: Клонирование через интерфейс
        System.out.println("\n5. Тестирование клонирования через интерфейс:");
        testCloningViaInterface();

        // Тест 6: Проверка согласованности equals() и hashCode()
        System.out.println("\n6. Проверка согласованности equals() и hashCode():");
        testEqualsHashCodeConsistency();
    }

    private static void testFunctionPoint() {
        FunctionPoint p1 = new FunctionPoint(1.5, 2.5);
        FunctionPoint p2 = new FunctionPoint(1.5, 2.5);
        FunctionPoint p3 = new FunctionPoint(1.5000001, 2.5);

        System.out.println("  p1 = " + p1.toString());
        System.out.println("  p2 = " + p2.toString());
        System.out.println("  p3 = " + p3.toString());

        System.out.println("  p1.equals(p2) = " + p1.equals(p2));
        System.out.println("  p1.equals(p3) = " + p1.equals(p3));

        System.out.println("  p1.hashCode() = " + p1.hashCode());
        System.out.println("  p2.hashCode() = " + p2.hashCode());
        System.out.println("  p3.hashCode() = " + p3.hashCode());

        FunctionPoint p4 = (FunctionPoint) p1.clone();
        System.out.println("  p4 = clone(p1) = " + p4);
        System.out.println("  p1.equals(p4) = " + p1.equals(p4));
    }

    private static void testArrayTabulatedFunction() {
        FunctionPoint[] points = {
                new FunctionPoint(0, 0),
                new FunctionPoint(1, 1),
                new FunctionPoint(2, 4)
        };

        ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(points);
        ArrayTabulatedFunction func2 = new ArrayTabulatedFunction(points);
        ArrayTabulatedFunction func3 = new ArrayTabulatedFunction(0, 2, 3);

        System.out.println("  func1 = " + func1.toString());
        System.out.println("  func2 = " + func2.toString());
        System.out.println("  func3 = " + func3.toString());

        System.out.println("  func1.equals(func2) = " + func1.equals(func2));
        System.out.println("  func1.equals(func3) = " + func1.equals(func3));

        System.out.println("  func1.hashCode() = " + func1.hashCode());
        System.out.println("  func2.hashCode() = " + func2.hashCode());
        System.out.println("  func3.hashCode() = " + func3.hashCode());

        ArrayTabulatedFunction cloned = (ArrayTabulatedFunction) func1.clone();
        System.out.println("  cloned = " + cloned.toString());
        System.out.println("  func1.equals(cloned) = " + func1.equals(cloned));

        // Проверка глубокого клонирования
        func1.setPointY(0, 100);
        System.out.println("  После изменения func1[0].y = 100:");
        System.out.println("    func1 = " + func1.toString());
        System.out.println("    cloned = " + cloned.toString());
        System.out.println("    func1.equals(cloned) = " + func1.equals(cloned));
    }

    private static void testLinkedListTabulatedFunction() {
        FunctionPoint[] points = {
                new FunctionPoint(0, 0),
                new FunctionPoint(1, 1),
                new FunctionPoint(2, 4)
        };

        LinkedListTabulatedFunction func1 = new LinkedListTabulatedFunction(points);
        LinkedListTabulatedFunction func2 = new LinkedListTabulatedFunction(points);
        LinkedListTabulatedFunction func3 = new LinkedListTabulatedFunction(0, 2, 3);

        System.out.println("  func1 = " + func1.toString());
        System.out.println("  func2 = " + func2.toString());
        System.out.println("  func3 = " + func3.toString());

        System.out.println("  func1.equals(func2) = " + func1.equals(func2));
        System.out.println("  func1.equals(func3) = " + func1.equals(func3));

        System.out.println("  func1.hashCode() = " + func1.hashCode());
        System.out.println("  func2.hashCode() = " + func2.hashCode());
        System.out.println("  func3.hashCode() = " + func3.hashCode());

        LinkedListTabulatedFunction cloned = (LinkedListTabulatedFunction) func1.clone();
        System.out.println("  cloned = " + cloned.toString());
        System.out.println("  func1.equals(cloned) = " + func1.equals(cloned));

        // Проверка глубокого клонирования
        func1.setPointY(0, 100);
        System.out.println("  После изменения func1[0].y = 100:");
        System.out.println("    func1 = " + func1.toString());
        System.out.println("    cloned = " + cloned.toString());
        System.out.println("    func1.equals(cloned) = " + func1.equals(cloned));
    }

    private static void testDifferentImplementations() {
        FunctionPoint[] points = {
                new FunctionPoint(0, 0),
                new FunctionPoint(1, 1),
                new FunctionPoint(2, 4)
        };

        TabulatedFunction arrayFunc = new ArrayTabulatedFunction(points);
        TabulatedFunction listFunc = new LinkedListTabulatedFunction(points);

        System.out.println("  ArrayTabulatedFunction: " + arrayFunc.toString());
        System.out.println("  LinkedListTabulatedFunction: " + listFunc.toString());
        System.out.println("  arrayFunc.equals(listFunc) = " + arrayFunc.equals(listFunc));
        System.out.println("  listFunc.equals(arrayFunc) = " + listFunc.equals(arrayFunc));
    }

    private static void testCloningViaInterface() {
        FunctionPoint[] points = {
                new FunctionPoint(0, 0),
                new FunctionPoint(1, 1),
                new FunctionPoint(2, 4)
        };

        TabulatedFunction func1 = new ArrayTabulatedFunction(points);
        TabulatedFunction func2 = new LinkedListTabulatedFunction(points);

        TabulatedFunction clone1 = (TabulatedFunction) func1.clone();
        TabulatedFunction clone2 = (TabulatedFunction) func2.clone();

        System.out.println("  Исходные функции равны своим клонам:");
        System.out.println("    func1.equals(clone1) = " + func1.equals(clone1));
        System.out.println("    func2.equals(clone2) = " + func2.equals(clone2));

        // Модифицируем исходные функции
        func1.setPointY(0, 999);
        func2.setPointY(0, 999);

        System.out.println("  После модификации исходных функций:");
        System.out.println("    func1.equals(clone1) = " + func1.equals(clone1));
        System.out.println("    func2.equals(clone2) = " + func2.equals(clone2));
    }

    private static void testEqualsHashCodeConsistency() {
        System.out.println("  Проверка согласованности для FunctionPoint:");
        FunctionPoint p1 = new FunctionPoint(1.0, 2.0);
        FunctionPoint p2 = new FunctionPoint(1.0, 2.0);
        FunctionPoint p3 = new FunctionPoint(1.000001, 2.0);

        System.out.println("    p1.equals(p2) = " + p1.equals(p2));
        System.out.println("    p1.hashCode() == p2.hashCode() = " + (p1.hashCode() == p2.hashCode()));
        System.out.println("    p1.equals(p3) = " + p1.equals(p3));
        System.out.println("    p1.hashCode() == p3.hashCode() = " + (p1.hashCode() == p3.hashCode()));

        System.out.println("\n  Проверка согласованности для функций:");
        TabulatedFunction func1 = new ArrayTabulatedFunction(0, 2, 3);
        TabulatedFunction func2 = new ArrayTabulatedFunction(0, 2, 3);
        TabulatedFunction func3 = new ArrayTabulatedFunction(0, 2, 4);

        System.out.println("    func1.equals(func2) = " + func1.equals(func2));
        System.out.println("    func1.hashCode() == func2.hashCode() = " + (func1.hashCode() == func2.hashCode()));
        System.out.println("    func1.equals(func3) = " + func1.equals(func3));
        System.out.println("    func1.hashCode() == func3.hashCode() = " + (func1.hashCode() == func3.hashCode()));
    }
}
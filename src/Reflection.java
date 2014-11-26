import java.lang.reflect.*;

/**
 * Created by А on 26.11.14.
 */
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class c = Class.forName("A"); // получить класс. или:
        Class c2 = A.class;
        // A.getSuperClass - получить базовый класс
        Field[] fields = c.getDeclaredFields(); // ВСЕ поля но только для этого класса
        Field[] f1 = c.getFields(); // public поля класса и его базовых
        for (Field f : fields) {
            System.out.println(f.getType() + " " + f.getName());
        }
        Class[] paramTypes = {int.class}; //объект класса Класс для примитива Инт
        Constructor con = c.getDeclaredConstructor(paramTypes); // получаем конкретный конструктор, который принимает инт
        Object[] o = {new Integer(20)};
        A pa = (A)con.newInstance(o); // создаем новый объект класса А
        Class c3 = pa.getClass();
        System.out.println(pa.getA());

        Field field = c.getDeclaredField("a"); // получаем поле
        field.setAccessible(true); // отменили для Runtime модификатор поля private для доступа через field или:
        AccessibleObject.setAccessible(fields, true); // всем полям отменяет модификатор private
        field.set(pa, new Integer(10));
        System.out.println(pa.getA());

        Class[] typesOfMethod = {int.class};
        Method m = c.getDeclaredMethod("setA", typesOfMethod); // получили метод
        Object[] param = {new Integer(50)};
        m.invoke(pa, param); // вызываем этот метод у ра
        System.out.println(pa.getA());
        Method m2 = c.getDeclaredMethod("getA", null); // получаем метод, который не принимает параметры
        int s = (Integer)m2.invoke(pa, null); // вызываем этот метод

        int mod = field.getModifiers(); // получаем модификаторы поля
        System.out.println(Modifier.isPrivate(mod)); // узнаем, есть ли среди модификаторов private
    }
}

class A {
    private int a;

    A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}


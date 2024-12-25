package JavaSE;

 /**
 * 泛型的三种使用方式，以及泛型擦除
 */
 public class JavaSE {
     
    // 1.泛型类
    // 此处 T 可以随便写为任意标识，常见的如 T、E、K、V 等形式的参数常用于表示泛型，实例化泛型类时，必须指定 T 的具体类型
     class Generic<T>{

        private T key;
        // 泛型擦除："private T key" 编译后的代码（伪代码）
        // private Object key;

        // Generic<String> box = new Generic<>();
        // System.out.println(box.getClass().getTypeParameters()); // 输出：[T]，运行时无法获取泛型类型

        // 2.泛型方法
        // <E> ：定义一个类型参数 E
        // 非静态方法，可以使用类上声明的泛型类型 T，也可以定义自己的泛型类型 E
        public <E> void printArray2(E[] EArray,T[] TArray)
        {
            for (E e : EArray ){
                System.out.printf( "%s ", e );
            }
            for (T t : TArray ){
                System.out.printf( "%s ", t );
            }
        }

        // ！！！（有点难理解）
        // 静态方法无法依赖于类的泛型类型，静态方法需要显式声明自己的泛型类型 E。泛型是个占位符，静态方法在类加载时就已经存在，而类的泛型类型是在实例化对象时才确定的。
        // public static <E> void printItem(E item) {
        //     System.out.println(item);
        // }
    }

    // 3.泛型接口
    interface Generator<T> {
        public T method();
    }

    // 实现泛型接口，不指定类型
    class GeneratorImpl1<T> implements Generator<T>{
        @Override
        public T method() {
            return null;
        }
    }

    // 实现泛型接口，指定类型
    class GeneratorImpl2 implements Generator<String> {
        @Override
        public String method() {
            return "hello";
        }
    }

}

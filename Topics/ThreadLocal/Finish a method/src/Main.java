
class UseThreadLocal {
    public static ThreadLocal<Integer> makeThreadLocal(int counter) {
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        integerThreadLocal.set(counter + 1);
        return integerThreadLocal;
    }
}
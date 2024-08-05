package SingletonClass;

public class SingletonClass {
    //singleton method make only one object
    //lazy loading
    //step  1
    private static SingletonClass instance;
    //step 2 private constructor
    private  SingletonClass(){

    }
    //step 3
    public  static  SingletonClass getInstance(){
        if(instance==null){
            instance = new SingletonClass();
        }
        return instance;

    }

    public static void main(String[] args) {
        //cant create object with new keyword because of private constructor
        SingletonClass sc =  SingletonClass.getInstance();
        System.out.println(sc.hashCode());
        SingletonClass sc1 =SingletonClass.getInstance();
        System.out.println(sc1.hashCode());
    }
}

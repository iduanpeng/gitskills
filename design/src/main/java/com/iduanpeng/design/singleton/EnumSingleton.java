package com.iduanpeng.design.singleton;

public class EnumSingleton {
    private EnumSingleton(){}

    public static EnumSingleton getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    enum SingletonEnum{
        INSTANCE,;
        private EnumSingleton enumSingleton;

        SingletonEnum(){
            enumSingleton = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return enumSingleton;
        }

    }
}

package taest.pattern.factory.simplefactory;

import java.util.function.Consumer;

public class FoodFactory {

//    public Food create(String className){
//        if (className  == null || "".equals(className)){
//            return null;
//        }
//        try {
//            Food result = (Food)Class.forName(className).newInstance();
//            return result;
//        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public Food create(Class<? extends Food> clazz){
        try {
            Food result = clazz.newInstance();
            return result;
        } catch (InstantiationException | IllegalAccessException  e) {
            e.printStackTrace();
            return null;
        }
    }
}

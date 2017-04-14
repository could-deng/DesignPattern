package com.sdk.dyq.designpattern.common;

import android.util.Log;

/**
 * 备忘录模式
 */

public class PatternMemento {


    class Memento{
        String value;

        public Memento(String value) {
            this.value = value;
        }
    }

    class Original{
        String value;

        public Original(String value) {
            this.value = value;
        }

        Memento createMenento(){
            return new Memento(value);
        }
        void restorate(Memento memento){
            value = memento.value;
        }
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    class Storage{
        Memento memento;

        public Storage(Memento memento) {
            this.memento = memento;
        }
    }

    void test(){
        Original ori = new Original("original");//原始
        Memento men = ori.createMenento();//备份
        Storage storate = new Storage(men);//仓库
        Log.i("TT",ori.value);

        ori.setValue("edit");
        Log.i("TT",ori.value);
        ori.restorate(men);
        Log.i("TT",ori.value);
    }

}

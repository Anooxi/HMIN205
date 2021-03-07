package fr.maximereiter.tp3;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Utilisation implements LifecycleObserver {

    private int counter = 0;
    private Context c;
    public Utilisation(Context c){
    this.c = c;
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void nombreUtilisation(){
        this.counter++;
        Log.d("Utilisation",counter +"");
    }

    @Override
    public String toString() {
        return "Utilisation{" +
                "counter=" + counter +
                '}';
    }
}

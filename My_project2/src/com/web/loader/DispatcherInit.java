package com.web.loader;


import com.web.administrators.Dispatcher;

/**
 * Created by Asus on 26.10.2016.
 */
public class DispatcherInit {
    private Dispatcher dispatcher = new Dispatcher();

    public DispatcherInit() {
        dispatcher.addNewPilot("Stas", 25, 160, 5, "KV185555", 550);
        dispatcher.addNewStewardess("Stas", 25, 160, 5, "KV185555", 60);
        dispatcher.addNewNavigator("Stas", 25, 160, 5, "KV185555", "First");
        dispatcher.addNewRadioman("Stas", 25, 160, 5, "KV185555", 12);
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DispatcherInit)) return false;
        DispatcherInit that = (DispatcherInit) o;
        return getDispatcher() != null ? getDispatcher().equals(that.getDispatcher()) : that.getDispatcher() == null;

    }

    @Override
    public int hashCode() {
        return getDispatcher() != null ? getDispatcher().hashCode() : 0;
    }
}

package lv.ctco.notepad;

import java.io.Serializable;

public interface Expirable {
    boolean isExpired();
    default void dismiss() {
        System.out.println("DISMISS IS NOT IMPLEMENTED");
    }
}

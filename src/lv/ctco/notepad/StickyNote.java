package lv.ctco.notepad;

public class StickyNote extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StickyNote{" +
                "id=" + getId() +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return text.contains(str);
    }

    @Override
    public void askData() {
        text = Main.askString("Enter text");
    }
}

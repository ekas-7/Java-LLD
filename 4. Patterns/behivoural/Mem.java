import java.util.Stack;

class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
    }
}

class Memento {
    private final String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class EditorHistory {
    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();

    public void saveState(Memento memento) {
        undoStack.push(memento);
        redoStack.clear();
    }

    public Memento undo(Memento currentState) {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            return undoStack.pop();
        }
        return null;
    }

    public Memento redo(Memento currentState) {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            return redoStack.pop();
        }
        return null;
    }
}

public class Mem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.setText("Hello");
        history.saveState(editor.save());

        editor.setText("Hello, World!");
        history.saveState(editor.save());

        editor.setText("Hello, World! Welcome!");
        System.out.println("Current: " + editor.getText());

        Memento previousState = history.undo(editor.save());
        if (previousState != null) {
            editor.restore(previousState);
            System.out.println("After undo: " + editor.getText());
        }

        Memento redoState = history.redo(editor.save());
        if (redoState != null) {
            editor.restore(redoState);
            System.out.println("After redo: " + editor.getText());
        }
    }
}
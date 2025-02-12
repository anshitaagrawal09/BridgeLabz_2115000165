
// Doubly Linked List Node representing a text state
class TextNode {
    String textState;
    TextNode prev;
    TextNode next;

    public TextNode(String textState) {
        this.textState = textState;
        this.prev = null;
        this.next = null;
    }
}

// TextEditor class with Undo/Redo functionality using Doubly Linked List
class TextEditor {
    private TextNode currentState;

    public TextEditor() {
        this.currentState = null;
    }

    // Add a new text state to the history
    public void addState(String newText) {
        TextNode newNode = new TextNode(newText);

        if (currentState == null) {
            currentState = newNode;
        } else {
            newNode.prev = currentState;
            currentState.next = newNode;
            currentState = newNode;
        }
    }

    // Undo operation (move to the previous state)
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.textState);
        } else {
            System.out.println("No previous state to undo.");
        }
    }

    // Redo operation (move to the next state)
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.textState);
        } else {
            System.out.println("No next state to redo.");
        }
    }

    // Display the current text state
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.textState);
        } else {
            System.out.println("No text state available.");
        }
    }
}

// Main Class for Testing the Undo/Redo Functionality
public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Typing actions (adding states)
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        // Display the current state
        editor.displayCurrentState();

        // Undo actions
        editor.undo();  // Should revert to "Hello World"
        editor.undo();  // Should revert to "Hello"

        // Redo actions
        editor.redo();  // Should revert to "Hello World"
        editor.redo();  // Should revert to "Hello World!"
    }
}


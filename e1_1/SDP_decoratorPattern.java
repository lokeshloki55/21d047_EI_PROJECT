package EI_Exercise1;

import java.util.Scanner;

interface TextEditor {
    String write();
}

class SimpleTextEditor implements TextEditor {
    @Override
    public String write() {
        return "Simple Text";
    }
}

abstract class TextEditorDecorator implements TextEditor {
    protected TextEditor decoratedTextEditor;

    public TextEditorDecorator(TextEditor textEditor) {
        this.decoratedTextEditor = textEditor;
    }

    public String write() {
        return decoratedTextEditor.write();
    }
}

class SpellCheckDecorator extends TextEditorDecorator {
    public SpellCheckDecorator(TextEditor textEditor) {
        super(textEditor);
    }

    public String write() {
        return super.write() + " with spell check";
    }
}

class GrammarCheckDecorator extends TextEditorDecorator {
    public GrammarCheckDecorator(TextEditor textEditor) {
        super(textEditor);
    }

    public String write() {
        return super.write() + " with grammar check";
    }
}

public class SDP_decoratorPattern {
    public static void main(String[] args) {
        TextEditor editor = new SimpleTextEditor();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter decorator type (spell or grammar): ");
        String decoratorType = scanner.nextLine();

        if (decoratorType.equalsIgnoreCase("spell")) {
            editor = new SpellCheckDecorator(editor);
        } else if (decoratorType.equalsIgnoreCase("grammar")) {
            editor = new GrammarCheckDecorator(editor);
        } else {
            System.out.println("Invalid decorator type");
            scanner.close();
            return;
        }

        System.out.println(editor.write());
        scanner.close();
    }
}

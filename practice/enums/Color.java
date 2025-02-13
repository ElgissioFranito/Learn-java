package enums;

public enum Color {
    RED("Rouge","FF0000"),
    GREEN("Vert","00FF00"),
    BLUE("bleu","0000FF");

    private String name;
    private String code;

    Color(String name, String code) {
        this.name = name;
        this.code = code;
    }
}

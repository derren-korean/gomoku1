package main.java.model;

public enum GameMode {
    FIFTY_BY_FIFTY("15x15",15),
    NINETY_BY_NINETY("19x19",19);

    private String mode;
    private Integer lineCount;

    GameMode(String mode, Integer lineCount) {
        this.mode = mode;
        this.lineCount = lineCount;
    }
    public static GameMode getDefault() {
        return GameMode.FIFTY_BY_FIFTY;
    }

    public Integer getLineCount() {
        return lineCount;
    }
}

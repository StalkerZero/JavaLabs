package ru.StalkerNidus.Computer;

public class GPU {
    private String title;
    private int frequency;
    private int memory;
    private boolean rtx;

    public GPU(){}

    public GPU(String title, int frequency, int memory, boolean rtx) {
        this.title = title;
        this.frequency = frequency;
        this.memory = memory;
        this.rtx = rtx;
    }

    @Override
    public String toString() {
        return "GPU{" +
                "title='" + title + '\'' +
                ", frequency=" + frequency +
                ", memory=" + memory +
                ", rtx=" + rtx +
                '}';
    }

    public GPU copy(){
        return new GPU(title, frequency, memory, rtx);
    }

    public int getRtx(){
        if(rtx==true) return 1;
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public boolean isRtx() {
        return rtx;
    }

    public void setRtx(boolean rtx) {
        this.rtx = rtx;
    }
}

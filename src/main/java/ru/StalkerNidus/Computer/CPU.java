package ru.StalkerNidus.Computer;

public class CPU {
    private String title;
    private int core;
    private float minFrequency;
    private float maxFrequency;

    public CPU(String title, int core, float minFrequency, float maxFrequency) {
        this.title = title;
        this.core = core;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "title='" + title + '\'' +
                ", core=" + core +
                ", minFrequency=" + minFrequency +
                ", maxFrequency=" + maxFrequency +
                '}';
    }

    public CPU copy(){
        return new CPU(title, core, minFrequency, maxFrequency);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public float getMinFrequency() {
        return minFrequency;
    }

    public void setMinFrequency(float minFrequency) {
        this.minFrequency = minFrequency;
    }

    public float getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(float maxFrequency) {
        this.maxFrequency = maxFrequency;
    }
}

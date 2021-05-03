package ru.StalkerNidus.Computer;

public class Memory {
    private float frequency;
    private int memory;

    @Override
    public String toString() {
        return "Memory{" +
                "frequency=" + frequency +
                ", memory=" + memory +
                '}';
    }

    public Memory copy () {
        return new Memory(frequency, memory);
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Memory(float frequency, int memory) {
        this.frequency = frequency;
        this.memory = memory;
    }
}
